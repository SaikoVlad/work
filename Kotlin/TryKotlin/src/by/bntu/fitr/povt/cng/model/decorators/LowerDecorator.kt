package by.bntu.fitr.povt.cng.model.decorators

class LowerDecorator : CaseDecorator {
    override fun decorate(event: String) : String {
        return event.toLowerCase()
    }
}