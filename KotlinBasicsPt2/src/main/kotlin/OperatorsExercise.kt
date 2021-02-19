import java.util.*

fun main(args : Array<String>) {

    val scanner = Scanner(System.`in`)

    println("Please write your first value: ")
    val firstValue: Int = scanner.nextInt()

    println("Please write your second value: ")
    val secondValue: Int = scanner.nextInt()

    println("$firstValue + $secondValue = ${firstValue + secondValue}")
    println("$firstValue - $secondValue = ${firstValue - secondValue}")
    println("$firstValue * $secondValue = ${firstValue * secondValue}")
    println("$firstValue / $secondValue = ${firstValue / secondValue}")

}