using System;
using Lab8.cng.Model.Entity.Abstracts;
using Lab8.cng.Model.Entity.Container.JSFContainer;

namespace Lab8.cng.Model.Logic
{
    public class Sort
    {
        public static void Bubble(IJsfTree tree)
        {
            bool sorted = true;
            for (int i = tree.GetSizeOfTree(); i > 0; i--)
            {
                for (int j = 0; j < i - 1; j++)
                {
                    if (tree.GetToy(j).CompareTo(tree.GetToy(j + 1)) > 0)
                    {
                        Toy tmp = tree.GetToy(j);
                        tree.ChangeToy(tree.GetToy(j + 1), j);
                        tree.ChangeToy(tmp, j + 1);
                        sorted = false;
                    }

                    if (sorted)
                    {
                        return;
                    }
                }
            }
        }

        public static void Insert(IJsfTree tree)
        {
            Toy temp;
            int j;
            for (int i = 0; i < tree.GetSizeOfTree() - 1; i++)
            {
                if (tree.GetToy(i).CompareTo(tree.GetToy(i + 1)) > 0)
                {
                    temp = tree.GetToy(i + 1);
                    tree.ChangeToy(tree.GetToy(i), i + 1);
                    j = i;
                    while(j > 0 && tree.GetToy(j - 1).CompareTo(temp) > 0)
                    {
                        tree.ChangeToy(tree.GetToy(j - 1), j);
                        j--;
                    }

                    tree.ChangeToy(temp, j);
                }
            }
        }
    }
}