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

    Thread.sleep(1000)

    println("Welcome! Please enter your ATM card...")

    Thread.sleep(1000)

    var loginAttempt = 0

    do {
        println("")
        Thread.sleep(1000)

        print("Please enter your 4-Digit PIN: ")
        val enteredPin: String? = readlnOrNull()

        Thread.sleep(1000)
        println("")

        if (enteredPin.isNullOrBlank()) {
            println("PIN cannot be empty")
            loginAttempt++
        } else if (enteredPin == pin) {
            println("PIN verified successfully")
            return
        } else {
            println("Incorrect PIN")
            loginAttempt++
            println("Remaining Attempts: ${3 - loginAttempt}")
        }
    } while (loginAttempt < 3)

    Thread.sleep(1000)

    println("")

    println("Account Locked!")

    Thread.sleep(1000)

    println("Exiting ATM...")
}