import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

/* Custom Data Type (Think of it as creating a new data type, just like String, Double, or Boolean.) - Blueprint just like a blank form for students or customers to fill in */
data class Transaction(
    val accountNumber: String,
    val transactionType: String,
    val transactionAmount: Double,
    val balance: Double,
    val date: String,
    val time: String,
    val status: String
)

fun getCurrentDate(): String {
    return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
}

fun getCurrentTime(): String {
    return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"))
}

/* displayWelcomeHeader function once per session */
fun displayWelcomeHeader(customerName: String, accountNumber: String) {
    // Display welcome message
    println("")
    println("------------------------")
    println(" Welcome, $customerName!")
    println(" Account Number : $accountNumber")
    println("------------------------")
}

/* displayMainMenu function */
fun displayMainMenu(): String {

    pause()
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
    val menuChoice: String = readln()

    // Return the choice
    return menuChoice
}

fun showBalance(balance: Double) {
    println("---------------------------")
    println("     Balance Enquiry       ")
    println("---------------------------")
    println(" Available Balance: $balance")
}

fun depositMoney(accountNumber: String, balance: Double, transactionHistory: MutableList<Transaction>): Double {

    println("---------------------------")
    println("     Deposit Money         ")
    println("---------------------------")

    do {
        print("Enter deposit amount (0 to cancel): ")
        val userInputDepositAmount = readln()

        if (userInputDepositAmount.isBlank()) {
            println("Please enter a valid deposit amount")
            continue
        }

        val depositAmount = userInputDepositAmount.toDoubleOrNull()

        if (depositAmount == null) {
            println("Please enter number only")
            continue
        }

        if (depositAmount == 0.0) {
            println("Deposit Canceled.")
            return balance
        }

        if (depositAmount < 0.0) {
            println("Deposit amount must be more than Zero.")
            continue
        }

        val updatedBalance = balance + depositAmount
        val date = getCurrentDate()
        val time = getCurrentTime()
        transactionHistory.add(
            Transaction(
                accountNumber = accountNumber,
                transactionType = "DEPOSIT",
                transactionAmount = depositAmount,
                balance = updatedBalance,
                date = date,
                time = time,
                status = "Success"
            )
        )

        println("Your cash has been deposited successfully!")
        pause()
        println("------------------------------------")
        println("        Transaction Receipt         ")
        println("------------------------------------")
        pause()
        println("Account Number     :   $accountNumber")
        pause()
        println("Type               :   DEPOSIT")
        pause()
        println("Previous Balance   :   $balance")
        pause()
        println("Deposit Amount     :   $depositAmount")
        pause()
        println("Updated Balance    :   $updatedBalance")
        pause()
        println("Status             :   Successful")
        pause()
        println("Date (dd/mm/yyy)   :   $date")
        pause()
        println("Time (hh/mm/ss)    :   $time")
        println("------------------------------------")
        pause()
        println("")
        println("Returning to Main Menu...")
        return updatedBalance
    } while (true)
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
fun pause(milliseconds: Long = 999) {
    Thread.sleep(milliseconds)
}

// main() is acting as the controller
fun main() {
    /*     Permanent Values - This is customer data.    */
    val customerName = "Rakesh Sharma"
    val accountNumber = "AC001"
    val pin = "0123"
    var balance = 25000.0
    val phoneNumber = "9797979797"
    val transactionHistory = mutableListOf<Transaction>() // Create an empty list that will store Transaction objects.

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
            println("PIN Verified Successfully.")
            var isSessionActive = true
            displayWelcomeHeader(customerName, accountNumber)
            // Menu Loop - Start
            do {
                val menuChoice =
                    displayMainMenu() // Here main() has the customer's answer that the displayMainMenu() is returning
                when (menuChoice) {
                    "1" -> {
                        pause()
                        showBalance(balance)
                    }

                    "2" -> {
                        pause()
                        balance =
                            depositMoney(
                                accountNumber,
                                balance,
                                transactionHistory
                            ) // I gave the Deposit Department the current balance, and now I'm storing the updated balance.
                    }

                    "3" -> {
                        pause()
                        withdrawMoney()
                    }

                    "4" -> {
                        pause()
                        transferFunds()
                    }

                    "5" -> {
                        pause()
                        changePin()
                    }

                    "6" -> {
                        pause()
                        miniStatement()
                    }

                    "7" -> {
                        pause()
                        updatePhoneNumber()
                    }

                    "8" -> {
                        pause()
                        fastCash()
                    }

                    "9" -> {
                        pause()
                        isSessionActive = false
                        println("Thank you for banking with Rakesh Bank.")
                        println("Please collect your card.")
                    }

                    else -> {
                        println("Invalid Menu Choice")
                    }
                }
            } while (isSessionActive) // Menu Loop - End
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