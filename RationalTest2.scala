class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  // Overloading the minus operator for subtraction
  def -(that: Rational): Rational = {
    new Rational(
      this.numer * that.denom - that.numer * this.denom,
      this.denom * that.denom
    )
  }

  def neg: Rational = new Rational(-numer, denom)

  override def toString: String = s"$numer/$denom"

  // Helper function to calculate the greatest common divisor
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}

object RationalTest2 extends App {
  val x = new Rational(3, 4)
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)

  // Subtract y - z
  val result = y - z

  println(s"x: $x")
  println(s"y: $y")
  println(s"z: $z")
  println(s"y - z: $result")

  // Subtract the result from x (x - (y - z))
  val finalResult = x - result

  println(s"x - (y - z): $finalResult")
}
