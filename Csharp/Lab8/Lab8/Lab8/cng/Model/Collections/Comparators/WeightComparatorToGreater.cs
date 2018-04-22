using System.Collections;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Collections.Comparators
{
    public class WeightComparatorToGreater : IComparer
    {
        public int Compare(object x, object y)
        {
            var t = (Toy) x;
            var t1 = (Toy) y;
            return (int) (t.GetWeight() - t1.GetWeight());

        }
    }
}