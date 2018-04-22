package by.bntu.fitr.prostrmk;

import by.bntu.fitr.prostrmk.Tree.BinaryTreeImpl;

public class Main {

    public static void main(String[] args) {

        BinaryTreeImpl tree = new BinaryTreeImpl();
        tree.insert("lol");
        tree.insert("hah");
        tree.insert("ah");
        tree.insert("airh");
        tree.insert("aoh");
        tree.insert("heh");
        System.out.println(tree.getNotesWithLetter('l'));
        System.out.println(tree);

    }
}
