package scala.func

object MyModule {

  def abs(n: Int): Int = {
   if (n < 0) -n
    else n
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def recurFact(n: Int): Int = {
    def loop(n: Int, a: Int, b: Int): Int = {
      if (n == 0) a
      else loop(n - 1, b, a + b)
    }
    loop(n, 0, 1)
  }

  def caseFact(n: Int): Int = {
    def loop(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => loop(n - 1, b, a + b)
    }
    loop(n, 0, 1)
  }

  def fib3(n: Int): Int = {
    def fib_tail(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => fib_tail(n - 1, b, a + b)
    }
    fib_tail(n, 0, 1)
  }

  //    def main(args: Array[String]) = {
  def main(args: Array[String]) = {
    println(recurFact(5))
    println(caseFact(5))
    println(fib3(5))
  }

}
