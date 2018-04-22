using System;
using System.Text;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Collections.binaryTree
{
    public class BinaryTree
    {
        private Node _root;

        public BinaryTree() {
            _root = null;
        }
        
        public void Insert(Toy id){
            Node newNode = new Node(id);
            if(_root==null){
                _root = newNode;
                return;
            }
            Node current = _root;
            Node parent = null;
            while(true){
                parent = current;
                if(current.Data.CompareTo(id) > 0){
                    current = current.Left;
                    if(current==null){
                        parent.Left = newNode;
                        return;
                    }
                }else{
                    current = current.Right;
                    if(current==null){
                        parent.Right = newNode;
                        return;
                    }
                }
            }
        }
        public string GetString(Direction direction){
            if (direction == Direction.LEFT){
                return GetLeft(_root);
            }else{
                return GetRight(_root);
            }
        }
        
        private string GetRight(Node root){
            StringBuilder stringBuilder = new StringBuilder();
            if (root!=null){
                stringBuilder.Append(Display(root.Right));
                stringBuilder.Append(root.Data);
            }
            return stringBuilder.ToString();
        }
    
        private String GetLeft(Node root){
            StringBuilder stringBuilder = new StringBuilder();
            if (root!=null){
                stringBuilder.Append(Display(root.Left));
                stringBuilder.Append(root.Data);
            }
            return stringBuilder.ToString();
        }

        private String Display(Node root){
            StringBuilder stringBuilder = new StringBuilder();
            if(root!=null){
                stringBuilder.Append(Display(root.Left));
                stringBuilder.Append(root.Data);
                stringBuilder.Append(Display(root.Right));
            }
            return stringBuilder.ToString();
        }

        
    }
}