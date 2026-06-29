/* displayMainMenu function */
fun displayMainMenu(customerName: String, accountNumber: String): String? {

    // Display welcome message
    println("")
    println("------------------------")
    println(" Welcome, $customerName!")
    println(" Account Number : $accountNumber")
    println("------------------------")

    // Display menu
    println("")
    println("Please select a service")
    println("1. Balance Inquiry")
    println("2. Deposit")
    println("3. Withdrawal")
    println("4. Fund Transfer")
    println("5. Pin Change")
    println("6. Mini Statement")
    println("7. Update Phone Number")
    println("8. Fast Cash")
    println("9. Exit")
    println("")

    // Read user's choice
    print("Please enter your choice : ")
    val menuChoice: String? = readlnOrNull()

    // Return the choice
    return menuChoice
}

// Created universal time delay function for better user experience displaying content
fun pause() {
    Thread.sleep(1000)
}

fun main() {
    /*     Permanent Values - This is customer data.    */
    val customerName: String = "Rakesh Sharma"
    val accountNumber: String = "AC001"
    val pin: String = "0123"
    val balance: Double = 25000.0
    val phoneNumber: String = "9797979797"

    /* ATM Operation - This is business logic. */
    println("")
    println("=================================")
    println("       Rakesh Bank ATM           ")
    println("=================================")
    println("")

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
            do {
                val menuChoice = displayMainMenu(customerName, accountNumber)
                when (menuChoice) {
                    "1" -> {
                        println("Selected : Balance Inquiry")
                    }

                    "2" -> {
                        println("Selected : Deposit")
                    }

                    "3" -> {
                        println("Selected : Withdrawal")
                    }

                    "4" -> {
                        println("Selected : Fund Transfer")
                    }

                    "5" -> {
                        println("Selected : Pin Change")
                    }

                    "6" -> {
                        println("Selected : Mini Statement")
                    }

                    "7" -> {
                        println("Selected : Update Phone Number")
                    }

                    "8" -> {
                        println("Selected : Fast Cash")
                    }

                    "9" -> {
                        println("Selected : Exit")
                    }
                }
            } while (menuChoice != "9")
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