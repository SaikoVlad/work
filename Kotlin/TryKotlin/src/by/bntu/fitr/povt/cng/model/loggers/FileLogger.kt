package by.bntu.fitr.povt.cng.model.loggers

import by.bntu.fitr.povt.cng.model.decorators.CaseDecorator
import java.io.File

class FileLogger : AbstractLogger, Logger {

    private var decorator: CaseDecorator? = null
    private var pathToFile: String? = null

    constructor()

    constructor(file: String) : super() {
        this.pathToFile = file
    }

    constructor(decorator: CaseDecorator, pathToFile: String) {
        this.decorator = decorator
        this.pathToFile = pathToFile
    }


    override fun logEvent(event: String) {
        if (decorator != null) {
            File(pathToFile).printWriter().use { out ->
                {
                    out.println(decorator!!.decorate("${super.getDate()}:\t $event"))
                }
            }
        } else {
            File(pathToFile).printWriter().use { out ->
                {
                    out.println("${super.getDate()}:\t $event")
                }

            }
        }

    }


}