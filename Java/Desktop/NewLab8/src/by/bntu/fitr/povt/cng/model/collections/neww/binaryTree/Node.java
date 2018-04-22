package by.bntu.fitr.povt.cng.model.collections.neww.binaryTree;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

class Node {

    private Toy getDate;
    private Node left;
    private Node right;

    public Node(Toy data){
        this.getDate = data;
        left = null;
        right = null;
    }

    public Toy getData() {
        return getDate;
    }

    public void setData(Toy data) {
        this.getDate = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
