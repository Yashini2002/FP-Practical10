class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def neg: Rational = new Rational(-numer, denom)

  override def toString: String = s"$numer/$denom"

  // Helper function to calculate the greatest common divisor
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}

object RationalTest extends App {
  val x = new Rational(3, 4)
  println(s"x: $x")
  println(s"-x: ${x.neg}")
}
