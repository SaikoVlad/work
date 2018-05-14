package prostmk.Controller;

import prostmk.Model.IO.CheckStream;
import prostmk.Model.Serializable.ObjectWork;
import prostmk.Model.Serializable.Person;
import prostmk.Model.Serializable.PersonChild;
import prostmk.Model.Threads.ThreadCheck;

import java.io.*;
import java.util.ArrayList;

public class MainClass {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Person father = new Person(34,"Roman","Medvedev");
//        Person kid = new PersonChild(14,"Mark",father);
//        ObjectWork.writeObject(kid, "kidFile");
//        PersonChild object = (PersonChild) ObjectWork.readObject("kidFile");
//        System.out.println(object);

        File file = new File("src/webapp/resources/pics/android-p-features-100757396-large.jpg");
        if (file.delete()){
            System.out.println("fine");
        }else{
            System.err.println("not fine");
        }

    }

}
