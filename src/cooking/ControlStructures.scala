package cooking

import scala.annotation.switch
import util.control.Breaks._

/**
 * Created by mykola.kozhemiaka on 17.05.2015.
 */
object ControlStructures {

  def main(args: Array[String]) {
    var a = Array("mimimi", "kokoko", "olololo")
    // simplest example with multiple operations in the brackets
    var f1 = for(e <- a) yield {
      var s = e.toUpperCase
      println(s)
    }

    // for with zipWithIndex
    for ((e,count) <- a.zipWithIndex) {
      println(s"$count is $e")
    }

    //looping over map
    val m = Map(
      "one" -> "mimimi",
      "two" -> "kokoko",
      "three" -> "olololo"
    )

    for ((a,b) <- m) println(s"$a, value: $b")

    // with several guards
    for  {
      c <- 1 to 10
      if c != 1
      if c % 2 == 0
    } println(c)

    // multiple counters
//    for(i <- 1 to 2 ; e <- 1 to 2) {
//      println(s"i = $i, e = $e")
//    }
    // more preferred style
    for {
      e <- 1 to 2
      i <- 1 to 2
    } println(s"i = $i, e = $e")

    breakLoopExample
    switchMatchExample
    println(oneLineCase(3))
  }


  def breakLoopExample = {
    println("\n BREAK EXAMPLE")
    breakable {
      for (i <- 1 to 10) {
        println(i)
        if (i > 4) break
      }
    }

    println("\n CONTINUE EXAMPLE")
    val searchMe = "peter piper picked a peck of pickled peppers"
    var numPs = 0
    for (i <- 0 until searchMe.length) {
      breakable {
        if(searchMe.charAt((i)) != 'p') {
          break
        } else {
          numPs += 1
        }
      }
    }
    println("Found " + numPs + " p's in the string.")
  }

  def switchMatchExample = {
    val a = 1
    val i = (a: @switch) match {
      case 1 => "one"
      case 2 => "two"
      case _ => "three"
    }
  }

  def oneLineCase(a: Int): String = a match {
    case 1 | 2 | 3 | 4 | 5 => "less then 6"
    case 6|7|8|9  => "less then ten"
  }


}
