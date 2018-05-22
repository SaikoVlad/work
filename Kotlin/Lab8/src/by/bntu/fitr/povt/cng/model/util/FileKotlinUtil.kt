package by.bntu.fitr.povt.cng.model.util

import java.io.File
import java.io.InputStream

class FileKotlinUtil {

    companion object {
        fun compareFiles(firstFile: String, secondFile: String): Boolean {

            var inputStream: InputStream = File(firstFile).inputStream()
            val s1 = inputStream.bufferedReader().use { it.readText() }
            inputStream = File(secondFile).inputStream()
            val s2 = inputStream.bufferedReader().use { it.readText() }
            return s1 == s2
        }

        fun writeInFile(string: String,filename: String){
            File(filename).printWriter().use {
                out -> out.println(string)
            }
        }

        fun readFromFile(filename: String) :String {
            var stringBuilder: StringBuilder
            File(filename).forEachLine {
                stringBuilder.append(it)
            }
        }

        private fun compareStrings(s1: String, s2:String) : Boolean{
            return s1 == s2
        }
    }

}