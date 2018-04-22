using System.Collections;
using System.Collections.Generic;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Collections.Comparators
{
    public class Sort
    {
        
        
        
        public static void Bubble(IList<Toy> tree)
        {
            
            bool sorted = true;
            for (int i = tree.Count; i > 0; i--)
            {
                for (int j = 0; j < i - 1; j++)
                {
                    if (tree[j].CompareTo(tree[j + 1]) > 0)
                    {
                        Toy tmp = tree[j];
                        tree[j] = tree[j+1];
                        tree[j + 1] = tmp;
                        sorted = false;
                    }

                    if (sorted)
                    {
                        return;
                    }
                }
            }
        }
    }
}