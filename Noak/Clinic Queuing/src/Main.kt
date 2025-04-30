import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs
import kotlin.math.round


fun main() = runBlocking {
    val doctors = listOf(
        Doctor("A", 3, System.currentTimeMillis()),
        Doctor("B", 4, System.currentTimeMillis()),
        Doctor("C", 4, System.currentTimeMillis()),
    )

    val system = QueueSystem(doctors)

    val patients = listOf(
        "Patient 1", "Patient 2", "Patient 3", "Patient 4", "Patient 5",
        "Patient 6", "Patient 7", "Patient 8", "Patient 9", "Patient 10",
        "Patient 11", "Patient 12", "Patient 13", "Patient 14", "Patient 15",
    )

    patients.forEach { system.registerPatient(it) }

    system.getEstimates(System.currentTimeMillis())

//    uncomment to simulate estimate updates each minute
//    system.start()
//    while (true) {
//        delay(500)
//    }
}

class QueueSystem(
    private val doctors: List<Doctor>
) {
    private val runner = QueueRunner()
    private val patientQueue = mutableListOf<Patient>()

    fun start() {
        runner.start(onTick = ::onTickRunner)
    }

    fun registerPatient(name: String) {
        val availableDoctor = doctors.minByOrNull { it.nextAvailableAt }!!
        val patient = Patient(name, availableDoctor, availableDoctor.nextAvailableAt)

        patientQueue.add(patient)
        availableDoctor.nextAvailableAt += (availableDoctor.averageTime * TimeMultiplier.ONE_MINUTE)
    }

    fun getEstimates(currentTime: Long) {
        val currentDate = getTime(currentTime)
        println("--- ETA at time $currentDate ---")
        patientQueue.forEach { patient ->
            val eta = round(abs(currentTime - patient.estimatedStart) / TimeMultiplier.ONE_MINUTE.toFloat()).toInt()
            println("${patient.name}: ~$eta min(s) (Doctor ${patient.assignedDoctor.id})")
        }
    }

    private fun updateEstimates(currentTime: Long) {
        val currentDate = getTime(currentTime)
        println("--- ETA at time $currentDate ---")
        val newPatients = patientQueue.filter { it.estimatedStart >= currentTime }.map { patient ->
            val eta = round(abs(currentTime - patient.estimatedStart) / TimeMultiplier.ONE_MINUTE.toFloat()).toInt()
            println("${patient.name}: ~$eta min(s) (Doctor ${patient.assignedDoctor.id})")
            patient
        }
        patientQueue.clear()
        patientQueue.addAll(newPatients)
    }

    private fun onTickRunner(currentTime: Long) {
        updateEstimates(currentTime)
    }

    private fun getTime(milliSeconds: Long): String {
        val formatter = SimpleDateFormat("hh:mm:ss")

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }
}

class QueueRunner {
    private val handler = CoroutineExceptionHandler { _, exception ->
        println(exception.message ?: "Something went wrong")
    }
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default + handler)
    private var runnerJob: Job? = null

    // mock clock time
    private var current = 0L

    fun start(onTick: suspend (Long) -> Unit) {
        runnerJob = scope.launch {
            current = System.currentTimeMillis()
            while (true) {
                delay(5000) // mock 5 seconds for observation
                current += TimeMultiplier.ONE_MINUTE // simulate one minute has passed by
                onTick(current)
            }
        }
    }

    fun stop() {
        runnerJob?.cancel()
        runnerJob = null
    }
}

object TimeMultiplier {
    const val ONE_MINUTE = 60_000L
}

data class Doctor(
    val id: String,
    val averageTime: Int,
    var nextAvailableAt: Long = 0L
)

data class Patient(
    val name: String,
    var assignedDoctor: Doctor,
    var estimatedStart: Long = 0L
)
