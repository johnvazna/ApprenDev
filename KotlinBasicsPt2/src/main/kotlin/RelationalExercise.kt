import java.util.*

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    println("Please type a day of the week")
    when (scanner.nextInt()) {
        1 -> println("Monday")
        2 -> println("Tuesday")
        3 -> println("Wednesday")
        4 -> println("Thursday")
        5 -> println("Friday")
        6 -> println("Saturday")
        7 -> println("Sunday")

        else -> {
            println("Please type a correct day of the week")
        }
    }

}