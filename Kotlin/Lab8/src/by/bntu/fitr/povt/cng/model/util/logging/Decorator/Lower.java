package by.bntu.fitr.povt.cng.model.util.logging.Decorator;

public class Lower implements TextDecorator {
    @Override
    public String change(String string) {
        return string.toLowerCase();
    }
}
