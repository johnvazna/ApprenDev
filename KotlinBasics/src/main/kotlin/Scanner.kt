import java.util.*

fun main(args: Array<String>) {

    //We create a scanner object to obtain values from out system
    val scanner = Scanner(System.`in`)

    println("Please write your email: ")
    val emailAddress = scanner.nextLine()

    println("Please write your age: ")
    val age = scanner.nextInt()

    println("Hi, your email is $emailAddress and you have a $age years old.")

}