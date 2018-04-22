using System;
using System.Collections;
using System.Collections.Generic;
using Lab8.cng.Model.Entity.Abstracts;

namespace Lab8.cng.Model.Collections.Comparators
{
    public class PriceComparatorToGreater : IComparer
    {
        
        public int Compare(object x, object y)
        {
            Toy toy1 = (Toy) x;
            Toy toy2 = (Toy) y;
            return (int) (toy1.GetPrice() - toy2.GetPrice());
        }
    }
}