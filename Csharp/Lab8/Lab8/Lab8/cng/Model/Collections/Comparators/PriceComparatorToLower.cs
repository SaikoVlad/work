using System.Collections;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Collections.Comparators
{
    public class PriceComparatorToLower : IComparer
    {
        public int Compare(object x, object y)
        {
            var toy = (Toy) x;
            var toy1 = (Toy) y;
            return (int) (toy1.GetPrice() - toy.GetPrice());
        }
    }
}