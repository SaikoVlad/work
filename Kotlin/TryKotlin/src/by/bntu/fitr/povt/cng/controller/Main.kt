package by.bntu.fitr.povt.cng.controller

import by.bntu.fitr.povt.cng.model.decorators.UpperDecorator
import by.bntu.fitr.povt.cng.model.loggers.ConsoleLogger
import by.bntu.fitr.povt.cng.model.loggers.FileLogger
import by.bntu.fitr.povt.cng.model.loggers.Logger

fun main(args: Array<String>){

    val logger: Logger = FileLogger(UpperDecorator(), "check.txt")
    logger.logEvent("check event logger")

}

