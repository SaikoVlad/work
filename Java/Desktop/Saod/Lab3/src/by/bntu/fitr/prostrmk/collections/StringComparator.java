package by.bntu.fitr.prostrmk.collections;
import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String firstString, String secondString) {
        int len1 = firstString.length();
        int len2 = secondString.length();
        int lim = Math.min(len1, len2);
        char v1[] = firstString.toCharArray();
        char v2[] = secondString.toCharArray();
        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
}
