fun main(args: Array<String>){

    val objectJava = ObjectJava(5, "String")
    val objectKotlin = ObjectKotlin(5, "String")
    println(objectJava)
    println(objectKotlin)

    println(inte(1,2))
    println(str("reversed"))

}


fun inte(a: Int, b: Int): Int{
    return a + b
}

fun str(a: String): String {
    return a.reversed()
}