class Account(var balance: Double) {

  // Deposit method to add money to the account
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $$${amount}. New balance: $$${balance}")
    } else {
      println("Deposit amount must be positive")
    }
  }

  // Withdraw method to remove money from the account
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount}. New balance: $$${balance}")
    } else if (amount > balance) {
      println("Insufficient balance")
    } else {
      println("Withdrawal amount must be positive")
    }
  }

  // Transfer method to transfer money to another account
  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount) // Withdraw from current account
      toAccount.deposit(amount) // Deposit into the given account
      println(s"Transferred $$${amount} to another account")
    } else {
      println("Transfer failed due to insufficient balance or invalid amount")
    }
  }

  override def toString: String = s"Account Balance: $$${balance}"
}

object AccountTest extends App {
  val acc1 = new Account(500)
  val acc2 = new Account(300)

  println(acc1) // Account 1
  println(acc2) // Account 2

  // Deposit into account 1
  acc1.deposit(100)

  // Withdraw from account 2
  acc2.withdraw(50)

  // Transfer from account 1 to account 2
  acc1.transfer(200, acc2)

  // Final balances
  println(acc1)
  println(acc2)
}
