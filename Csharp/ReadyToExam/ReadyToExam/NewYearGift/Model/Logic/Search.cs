using System;
using ReadyToExam.NewYearGift.Model.Entity.Container;

namespace ReadyToExam.NewYearGift.Model.Logic
{
    public class Search
    {
        public static string FindByCreator(Gift gift, string creator){
            for (int i = 0; i < gift.GetSize(); i++) {
                if (gift.GetCandy(i).Creator == creator){
                    return "That's our toy with creator " + creator + ":\n" + gift.GetCandy(i);
                }
            }
            return "No one";
        }

        public static string FindByWeight(Gift gift, double weight){
            for (int i = 0; i < gift.GetSize(); i++) {
                if (gift.GetCandy(i).Weight == weight){
                    return "That's our toy with weight " + weight + ":\n" + gift.GetCandy(i);
                }
            }
            return "No one";
        }

        public static string FindByPrice(Gift gift, double price){
            for (int i = 0; i < gift.GetSize(); i++) {
                if (gift.GetCandy(i).Price == price){
                    return "That's your toy with price " + price + ":\n" + gift.GetCandy(i);
                }
            }
            return "No one";
        }
    }
}