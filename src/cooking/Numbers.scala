package cooking

import scala.util.Random

/**
 * Created by mykola.kozhemiaka on 16.05.2015.
 */
object Numbers {

  def main(args: Array[String]) {
    println(~=(0.199999,0.2,0.00001))

    //random

    val r1 = Random.nextInt(100)
    println(r1)
  }

  def ~=(a: Double, b: Double, precision: Double) = {
    if((a - b).abs < precision) true else false
  }

  // create a range of random numbers

  var r2 = Random
  val randRange1 = for(c <- 1 to 5) yield r2.nextInt(100)
  println("Range of random numbers: "+randRange1)

  // collection of random length

  var randRange2 = 0 to r2.nextInt(10)
  println(randRange2)

  // random range with for generator

  var randRange3 = for(c <- 0 to r2.nextInt(10)) yield c * 2
  println(randRange3)

  // create range with step
  var stepRange = 0 to 10 by 3
  println(stepRange)

//  1 to 10 toArray
//  1 to 10 toList




}
