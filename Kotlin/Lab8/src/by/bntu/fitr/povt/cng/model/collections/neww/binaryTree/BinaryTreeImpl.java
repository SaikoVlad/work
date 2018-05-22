package by.bntu.fitr.povt.cng.model.collections.neww.binaryTree;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

public class BinaryTreeImpl {

    private Node root;

    public BinaryTreeImpl() {
        root = null;
    }

    public boolean find(Toy id) {
        Node current = root;
        while (current != null) {
            if (current.getData().equals(id)) {
                return true;
            } else if (current.getData().compareTo(id) > 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }


    public void insert(Toy id){
        Node newNode = new Node(id);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(current.getData().compareTo(id) > 0){
                current = current.getLeft();
                if(current==null){
                    parent.setLeft(newNode);
                    return;
                }
            }else{
                current = current.getRight();
                if(current==null){
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }


    public String getString(Direction direction){
        StringBuilder stringBuilder = new StringBuilder();
        if (direction == Direction.LEFT){
            displayLeft(root, stringBuilder);
        }else{
            displayRight(root, stringBuilder);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getString(Direction.LEFT);
    }


    private void displayLeft(Node root, StringBuilder stringBuilder){
        if(root!=null){
            displayLeft(root.getLeft(), stringBuilder);
            stringBuilder.append(root.getData());
            displayLeft(root.getRight(),stringBuilder);
        }
    }

    private void displayRight(Node root, StringBuilder stringBuilder){
        if(root!=null){
            displayRight(root.getRight(), stringBuilder);
            stringBuilder.append(root.getData());
            displayRight(root.getLeft(),stringBuilder);
        }
    }
}

