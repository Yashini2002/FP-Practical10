class Account(var balance: Double) {

  // Deposit method to add money to the account
  def deposit(amount: Double): Unit = {
    if (amount > 0) balance += amount
  }

  // Withdraw method to remove money from the account
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
  }

  // Transfer method to transfer money to another account
  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
    }
  }

  // Apply interest based on positive or negative balance
  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05 // Deposit interest for positive balances
    } else {
      balance += balance * 0.1 // Overdraft interest for negative balances
    }
  }

  override def toString: String = s"Account Balance: $$${balance}"
}

class Bank(var accounts: List[Account]) {

  // 4.1 List of Accounts with negative balances
  def negativeBalances(): List[Account] = {
    accounts.filter(_.balance < 0)
  }

  // 4.2 Calculate the sum of all account balances
  def totalBalance(): Double = {
    accounts.map(_.balance).sum
  }

  // 4.3 Apply the interest function to all accounts
  def applyInterestToAll(): Unit = {
    accounts.foreach(_.applyInterest())
  }
}

object BankApp extends App {
  // Create some accounts
  val acc1 = new Account(500)
  val acc2 = new Account(-200)
  val acc3 = new Account(300)
  val acc4 = new Account(-100)

  // Create a bank with a list of accounts
  val bank = new Bank(List(acc1, acc2, acc3, acc4))

  // 4.1 List of Accounts with negative balances
  val negativeAccounts = bank.negativeBalances()
  println("Accounts with negative balances:")
  negativeAccounts.foreach(println)

  // 4.2 Calculate the sum of all account balances
  val totalBalance = bank.totalBalance()
  println(s"Total balance of all accounts: $$${totalBalance}")

  // 4.3 Apply interest to all accounts
  bank.applyInterestToAll()
  println("Balances after applying interest:")
  bank.accounts.foreach(println)
}
