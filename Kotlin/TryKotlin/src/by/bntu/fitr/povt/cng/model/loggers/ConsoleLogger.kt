package by.bntu.fitr.povt.cng.model.loggers

import by.bntu.fitr.povt.cng.model.decorators.CaseDecorator

class ConsoleLogger : AbstractLogger,  Logger {

    private var decorator: CaseDecorator?

    constructor(){
        decorator = null
    }

    constructor(decorator : CaseDecorator){
        this.decorator = decorator
    }

    override fun logEvent(event: String) {
        val base: String = super.getDate()
        if (decorator != null){
            println(decorator!!.decorate("$base:\t $event"))
        }else{
            println("$base:\t $event")
        }


    }
}