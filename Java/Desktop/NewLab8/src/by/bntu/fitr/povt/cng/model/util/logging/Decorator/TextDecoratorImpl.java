package by.bntu.fitr.povt.cng.model.util.logging.Decorator;

public class TextDecoratorImpl implements TextDecorator {
    @Override
    public String toUpper(String string) {
        return string.toUpperCase();
    }

    @Override
    public String toLower(String string) {
        return string.toLowerCase();
    }
}
