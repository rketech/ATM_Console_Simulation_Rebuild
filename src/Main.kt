fun main() {
    /*     Permanent Values     */
    val customerName: String = "Rakesh Sharma"
    val accountNumber: String = "AC001"
    val pin: String = "0123"
    val balance: Double = 25000.0
    val phoneNumber: String = "9797979797"

    /* ATM Operation */
    println("")
    println("=================================")
    println("       Rakesh Bank ATM           ")
    println("=================================")
    println("")

    fun pause(){
        Thread.sleep(1000)
    }

    pause()

    println("Welcome! Please enter your ATM card...")

    pause()

    var loginAttempt = 0

    do {
        println("")
        pause()

        print("Please enter your 4-Digit PIN: ")
        val enteredPin: String? = readlnOrNull()

        pause()
        println("")

        if (enteredPin.isNullOrBlank()) {
            println("PIN cannot be empty")
            loginAttempt++
        } else if (enteredPin == pin) {
            println("Login Successful")
            return
        } else {
            println("Incorrect PIN")
            loginAttempt++
            println("Remaining Attempts: ${3 - loginAttempt}")
        }
    } while (loginAttempt < 3)

    pause()

    println("")

    println("Account Locked!")

    pause()

    println("Exiting ATM...")
}