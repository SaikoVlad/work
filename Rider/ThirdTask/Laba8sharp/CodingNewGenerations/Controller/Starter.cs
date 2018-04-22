using System;
using Laba8sharp.CodingNewGenerations.Model.Abstracts;
using Laba8sharp.CodingNewGenerations.Model.Entity;
using Laba8sharp.CodingNewGenerations.Model.Entity.Container;
using Laba8sharp.CodingNewGenerations.Model.Logic;
using Laba8sharp.CodingNewGenerations.View;

namespace Laba8sharp
{
    internal class Starter
    {
        public static void Main(string[] args)
        {
            Toy []toy = {new Garland(5.33,5.4,2.2,4.4,5,"stars"),new Lights(4.4,2.3,5.5,56,60,700),new StuffedToy(4.3,1.23,65.3,"Sonic","male",15)};
            Tree tree = new Tree(toy);
            //Output.WriteLine(tree);
            //Sort.Insert(tree);

            //Console.WriteLine(Search.FindBySize(tree, 2.2));
            Output.WriteLine(tree);
        }
    }
}