using System;
using System.Collections;
using System.Collections.Specialized;
using Lab8.cng.Model.Collections.Comparators;
using Lab8.cng.Model.Entity;
using Lab8.cng.Model.Entity.Container.JSFContainer;
using Lab8.cng.Model.Logic;

namespace Lab8.cng.Controller
{
    class MainController
    {
        static void Main(string[] args)
        {
            var stuffedToys = new StuffedToys(18,2,7,"star","male",1);
            var lights = new Lights(-5,5,3,1,1,1);
            var garland = new Garland(9999, 1, 6, 1, 1, "1");

            ArrayList arrayList = new ArrayList();
            arrayList.Add(stuffedToys);
            arrayList.Add(lights);
            arrayList.Add(garland);
            arrayList.Sort(new SizeComparatorToLower());
            foreach (var VARIABLE in arrayList)
            {
                Console.WriteLine(VARIABLE);
            }

        }
    }
}