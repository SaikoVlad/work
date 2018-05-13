fun main(args: Array<String>){


    val objectKotlin = ObjectKotlin(4, "asd")
    ObjectKotlin.static()
    objectKotlin.nonstatic()

}


fun inte(a: Int, b: Int): Int{
    return a + b
}

fun str(a: String): String {
    return a.reversed()
}