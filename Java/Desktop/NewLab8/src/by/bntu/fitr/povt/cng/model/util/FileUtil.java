package by.bntu.fitr.povt.cng.model.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUtil {
    public static boolean compareFiles(String firstFileName, String secondFileName) {
        File firstFile = new File(firstFileName);
        File secondFile = new File(secondFileName);
        List first = null;
        List second = null;
        try {
            first = FileUtils.readLines(firstFile, "UTF-8");
            second = FileUtils.readLines(secondFile, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return first.equals(second) && first != null && second != null;
    }
}
