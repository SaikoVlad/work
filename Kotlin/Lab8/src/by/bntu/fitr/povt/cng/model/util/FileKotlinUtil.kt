package by.bntu.fitr.povt.cng.model.util

import org.apache.log4j.Logger
import java.io.File
import java.io.InputStream

class FileKotlinUtil {


    companion object {

        val logger: Logger = Logger.getLogger(FileKotlinUtil.javaClass)

        fun compareFiles(firstFile: String, secondFile: String): Boolean {

            var inputStream: InputStream = File(firstFile).inputStream()
            val s1 = inputStream.bufferedReader().use { it.readText() }
            inputStream = File(secondFile).inputStream()
            val s2 = inputStream.bufferedReader().use { it.readText() }
            return s1 == s2
        }

        fun writeInFile(string: String,filename: String){
            try {
                File(filename).printWriter().use {
                    out -> out.println(string)
                }
            }catch (e: Exception){
                logger.warn("No such file: $filename")
            }

        }

        fun readFromFile(filename: String) :String {
            val readLines = File(filename).readLines()
            val s = StringBuilder()
            for (readLine in readLines) {
                s.append(readLine)
            }
            return s.toString()
        }


    }

}