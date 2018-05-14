package by.bntu.fitr.povt.cng.model.decorators

class UpperDecorator : CaseDecorator {
    override fun decorate(event: String) :String {
        return event.toUpperCase()
    }
}