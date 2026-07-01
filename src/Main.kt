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

fun showBalance() {
    println("Balance Inquiry feature is under development.")
}

fun depositMoney() {
    println("Deposit feature is under development.")
}

fun withdrawMoney() {
    println("Withdraw feature is under development.")
}

fun transferFunds() {
    println("Transfer feature is under development.")
}

fun changePin() {
    println("Change pin feature is under development.")
}

fun miniStatement() {
    println("Mini statement feature is under development.")
}

fun updatePhoneNumber() {
    println("Update phone number feature is under development.")
}

fun fastCash() {
    println("Fast Cash feature is under development.")
}

// Created universal time delay function for better user experience displaying content
fun pause(milliseconds: Long = 1000) {
    Thread.sleep(milliseconds)
}

fun main() {
    /*     Permanent Values - This is customer data.    */
    val customerName = "Rakesh Sharma"
    val accountNumber = "AC001"
    val pin = "0123"
    val balance = 25000.0
    val phoneNumber = "9797979797"

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


    // Login Loop - Start
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
            var isSessionActive = true
            println("Session : $isSessionActive") // Printing session just for testing
            // Menu Loop - Start
            do {
                val menuChoice = displayMainMenu(
                    customerName,
                    accountNumber
                ) // Here main() has the customer's answer that the displayMainMenu() is returning
                when (menuChoice) {
                    "1" -> {
                        pause(500)
                        println("Selected : Balance Inquiry | Session : $isSessionActive")
                        showBalance()
                    }

                    "2" -> {
                        pause(500)
                        println("Selected : Deposit | Session : $isSessionActive")
                        depositMoney()
                    }

                    "3" -> {
                        pause(500)
                        println("Selected : Withdrawal | Session : $isSessionActive")
                        withdrawMoney()
                    }

                    "4" -> {
                        pause(500)
                        println("Selected : Fund Transfer | Session : $isSessionActive")
                        transferFunds()
                    }

                    "5" -> {
                        pause(500)
                        println("Selected : Pin Change | Session : $isSessionActive")
                        changePin()
                    }

                    "6" -> {
                        pause(500)
                        println("Selected : Mini Statement | Session : $isSessionActive")
                        miniStatement()
                    }

                    "7" -> {
                        pause(500)
                        println("Selected : Update Phone Number | Session : $isSessionActive")
                        updatePhoneNumber()
                    }

                    "8" -> {
                        pause(500)
                        println("Selected : Fast Cash | Session : $isSessionActive")
                        fastCash()
                    }

                    "9" -> {
                        pause(500)
                        isSessionActive = false
                        println("Selected : Exit | Session : $isSessionActive")
                    }
                }
            } while (isSessionActive != false) // Menu Loop - End
            return
        } else {
            println("Incorrect PIN")
            loginAttempt++
            println("Remaining Attempts: ${3 - loginAttempt}")
        }
    } while (loginAttempt < 3) // // Login Loop - End

    pause()

    println("")

    println("Account Locked!")

    pause()

    println("Exiting ATM...")
}