package prostmk.Model.Serializable;

import java.io.*;

public class ObjectWork {

    public static void writeObject(Object object, String fileName) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("temp");
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    public static Object readObject(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("temp");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }




}
