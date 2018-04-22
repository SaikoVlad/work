using ReadyToExam.NewYearGift.Model.Abstracts;
using ReadyToExam.NewYearGift.Model.Entity.Container;

namespace ReadyToExam.NewYearGift.Model.Logic
{
    public class Sort
    {
        public static void Insert(Gift gift) {
            Candy temp;
            int j;
            for(int i = 0; i < gift.GetSize() - 1; i++){
                if (gift.GetCandy(i).Price > gift.GetCandy(i + 1).Price) {
                    temp = gift.GetCandy(i + 1);
                    gift.ChangeCandy(gift.GetCandy(i),i + 1);
                    j = i;
                    while (j > 0 && temp.Price < gift.GetCandy(j - 1).Price) {
                        gift.ChangeCandy(gift.GetCandy(j - 1),j);
                        j--;
                    }
                    gift.ChangeCandy(temp,j);
                }
            }
        }

        public static void Bubble(Gift gift) {
            bool sorted = true;
            for (int i = gift.GetSize(); i > 0; i--) {
                for (int j = 0; j < i - 1; j++) {
                    if (gift.GetCandy(j).Price > gift.GetCandy(j + 1).Price) {
                        Candy tmp = gift.GetCandy(j);
                        gift.ChangeCandy(gift.GetCandy(j + 1), j);
                        gift.ChangeCandy(tmp, j + 1);
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