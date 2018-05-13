class ObjectKotlin(var integer:Int, var string: String){


    companion object {
        fun static(){
            println("static")
        }
    }

    fun nonstatic(){
        println("nonstatic")
    }

    override fun toString(): String {
        return "ObjectKotlin(string='$string', integer=$integer)"
    }
}