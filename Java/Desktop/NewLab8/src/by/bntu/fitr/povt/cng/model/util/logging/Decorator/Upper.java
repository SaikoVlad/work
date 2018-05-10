package by.bntu.fitr.povt.cng.model.util.logging.Decorator;

public class Upper implements TextDecorator {
    @Override
    public String change(String string) {
        return string.toUpperCase();
    }
}
