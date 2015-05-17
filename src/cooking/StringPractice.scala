package cooking

/**
 * Created by mykola.kozhemiaka on 16.05.2015.
 */
object StringPractice {

  def main (args: Array[String]) {
    val string1 = "Hello scala"

    val stringToUpperCase = string1.map(a=> a.toUpper)
    println(stringToUpperCase)

    val stringFilter = string1.filter(a=> a != 'l')
    println(stringFilter)

    // for generator
    for (c <- string1 if c != 'a' if c.toLower != 'h') println(c)
    println()

    val forString = for(c <- string1)yield {
      c.toUpper
    }
    println(forString)

    println("HAL".increment)

  }

  // modifying string possibilities
  implicit class Str(s: String) {
    def increment = s.map(c => (c+1).toChar)
  }

}
