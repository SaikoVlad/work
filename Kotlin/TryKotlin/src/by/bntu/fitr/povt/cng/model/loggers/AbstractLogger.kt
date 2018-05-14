package by.bntu.fitr.povt.cng.model.loggers

import by.bntu.fitr.povt.cng.model.loggers.Logger
import java.util.*

abstract class AbstractLogger : Logger{

    protected fun getDate() : String{
        return Date().toString()
    }

    abstract override fun logEvent(event: String)
}