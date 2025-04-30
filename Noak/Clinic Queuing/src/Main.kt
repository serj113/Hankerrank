import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*


fun main() = runBlocking {
    val csList = listOf(
        CustomerService("A", 3, System.currentTimeMillis()),
        CustomerService("B", 4, System.currentTimeMillis()),
        CustomerService("C", 4, System.currentTimeMillis()),
    )

    val system = QueueSystem(csList)

    val customers = listOf(
        "Cust1", "Cust2", "Cust3", "Cust4", "Cust5",
        "Cust6", "Cust7", "Cust8", "Cust9", "Cust10",
        "Cust11"
    )

    customers.forEach { system.registerCustomer(it) }

    while (true) {
        delay(500)
    }
}

// System state
class QueueSystem(
    private val csList: List<CustomerService>
) {
    private val runner = QueueRunner()
    private val customerQueue = mutableListOf<Customer>()

    init {
        runner.start(onTick = ::onTickRunner)
    }

    fun registerCustomer(name: String): Customer {
        val availableCS = csList.minByOrNull { it.nextAvailableAt }!!
        val estimatedStart = availableCS.nextAvailableAt
        val customer = Customer(name, availableCS, estimatedStart)

        customerQueue.add(customer)
        availableCS.nextAvailableAt += (availableCS.avgTime * 1000L)

        return customer
    }

    fun handleCustomerFinished(csId: String, actualFinishTime: Int) {
        val cs = csList.find { it.id == csId } ?: return

        // Backtrack to correct nextAvailableAt based on actual finish
        if (actualFinishTime > cs.nextAvailableAt - (cs.avgTime * 2000L)) {
            val delay = actualFinishTime - (cs.nextAvailableAt - (cs.avgTime * 2000L))
            cs.nextAvailableAt += delay

            // Adjust ETA for remaining customers in this CS queue
            for (cust in customerQueue) {
                if (cust.assignedCS.id == csId && cust.estimatedStart > actualFinishTime) {
                    cust.estimatedStart += delay
                }
            }
        }
    }

    private fun printAllEstimates(currentTime: Long) {
        val currentDate = getDate(currentTime)
        println("--- ETA at time $currentDate ---")
        for (customer in customerQueue) {
            val eta = getDate(getEtaAtTime(customer, currentTime))
            println("${customer.name}: $eta min (CS ${customer.assignedCS.id})")
        }
    }

    private fun getEtaAtTime(customer: Customer, currentTime: Long): Long {
        val rawEta = customer.estimatedStart - currentTime
        return rawEta.coerceAtLeast(0L)
    }

    private fun onTickRunner(currentTime: Long) {
        printAllEstimates(currentTime)
    }

    private fun getDate(milliSeconds: Long): String {
        val formatter = SimpleDateFormat("hh:mm:ss")

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }

    inner class QueueRunner {
        private val handler = CoroutineExceptionHandler { _, exception ->
            println(exception.message ?: "Something went wrong")
        }
        private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default + handler)
        private var runnerJob: Job? = null

        fun start(onTick: suspend (Long) -> Unit) {
            runnerJob = scope.launch {
                while (true) {
                    delay(2000)
                    onTick(System.currentTimeMillis())
                }
            }
        }

        fun stop() {
            runnerJob?.cancel()
            runnerJob = null
        }
    }
}

data class CustomerService(
    val id: String,
    val avgTime: Int, // average handling time in minutes
    var nextAvailableAt: Long = 0L // in minutes since start (e.g., 0 = 08:00)
)

data class Customer(
    val name: String,
    var assignedCS: CustomerService,
    var estimatedStart: Long = 0L
)
