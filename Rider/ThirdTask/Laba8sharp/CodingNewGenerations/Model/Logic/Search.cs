using System;
using Laba8sharp.CodingNewGenerations.Model.Entity.Container;

namespace Laba8sharp.CodingNewGenerations.Model.Logic
{
    public class Search
    {
        public static string FindBySize(Tree tree, double size){
            for (int i = 0; i < tree.GetSize(); i++) {
                if (tree.GetToy(i).GetSize() == size){
                    return "That's our toy with size " + size + ":\n" + tree.GetToy(i).ToString();
                }
            }
            return "No one";
        }

        public static string FindByWeight(Tree tree, double weight){
            for (int i = 0; i < tree.GetSize(); i++) {
                if (tree.GetToy(i).GetWeight() == weight){
                    return "That's our toy with weight " + weight + ":\n" + tree.GetToy(i).ToString();
                }
            }
            return "No one";
        }

        public static string FindByPrice(Tree tree, double price){
            for (int i = 0; i < tree.GetSize(); i++) {
                if (tree.GetToy(i).GetPrice() == price){
                    return "That's your toy with price " + price + ":\n" + tree.GetToy(i).ToString();
                }
            }
            return "No one";
        }
    }
}