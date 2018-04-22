using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Collections.binaryTree
{
    public class Node
    {
        private Toy data;
        private Node left;
        private Node right;

        public Node(Toy data)
        {
            this.data = data;
            left = null;
            right = null;
        }

        public Toy Data
        {
            get => data;
            set => data = value;
        }

        public Node Left
        {
            get => left;
            set => left = value;
        }

        public Node Right
        {
            get => right;
            set => right = value;
        }
    }
}