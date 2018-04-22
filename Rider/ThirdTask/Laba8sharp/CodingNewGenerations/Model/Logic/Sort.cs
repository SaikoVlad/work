using Laba8sharp.CodingNewGenerations.Model.Abstracts;
using Laba8sharp.CodingNewGenerations.Model.Entity.Container;

namespace Laba8sharp.CodingNewGenerations.Model.Logic
{
    public class Sort
    {
        public static void Insert(Tree tree) {
            Toy temp;
            int j;
            for(int i = 0; i < tree.GetSize() - 1; i++){
                if (tree.GetToy(i).GetPrice() > tree.GetToy(i + 1).GetPrice()) {
                    temp = tree.GetToy(i + 1);
                    tree.ChangeToy(tree.GetToy(i),i + 1);
                    j = i;
                    while (j > 0 && temp.GetPrice() < tree.GetToy(j - 1).GetPrice()) {
                        tree.ChangeToy(tree.GetToy(j - 1),j);
                        j--;
                    }
                    tree.ChangeToy(temp,j);
                }
            }
        }

        public static void Bubble(Tree tree) {
            bool sorted = true;
            for (int i = tree.GetSize(); i > 0; i--) {
                for (int j = 0; j < i - 1; j++) {
                    if (tree.GetToy(j).GetPrice() > tree.GetToy(j + 1).GetPrice()) {
                        Toy tmp = tree.GetToy(j);
                        tree.ChangeToy(tree.GetToy(j + 1), j);
                        tree.ChangeToy(tmp, j + 1);
                        sorted = false;
                    }
                    if (sorted){
                        break;
                    }

                }
            }
        }
    }
}