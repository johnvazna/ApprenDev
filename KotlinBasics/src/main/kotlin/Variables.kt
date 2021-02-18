fun main(args: Array<String>) {

    /*
      This example, the variable can detected the assigned value and
      convert it to its data type.

      val - Use val for a variable whose value never change. You cannot
      reassign a value to a variable that was declared by val.

      var - User var for a variable whose value can change.

     */

    val simpleVariable = 10
    var secondSimpleVariable = 20

    /*
        Variables can contain null values, assigned null security
        in our variables
     */

    val thirtySimpleVariable : Int? = null

    //And we can print values with new ways of concatenation

    val fourSimpleVariables = "Course android developer"
    println("Welcome to $fourSimpleVariables")

}