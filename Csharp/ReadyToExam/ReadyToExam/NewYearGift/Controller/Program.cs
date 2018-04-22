using System;
using ReadyToExam.NewYearGift.Model.Abstracts;
using ReadyToExam.NewYearGift.Model.Entity;
using ReadyToExam.NewYearGift.Model.Entity.Container;
using ReadyToExam.NewYearGift.Model.Logic;

namespace ReadyToExam
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            
            Candy candy = new Candy(2.2,"ya",7.4);
            Lollipop lollipop = new Lollipop(2.2,"me",5.5,1.1,"good");
            Chocolate chocolate = new Chocolate(2.1, "opl", 0.11, "milk", true, "quad");
            //Gift gift = new Gift(new Candy[]{new Candy(1.1,"roflyan",2.1),new Lollipop(2,"asd",2.3,4.3,"der"), });
            Gift gift = new Gift();            
            gift.Add(candy);
            gift.Add(lollipop);
            gift.Add(chocolate);
            Sort.Bubble(gift);
            Console.WriteLine(gift);
            
        }
    }
}