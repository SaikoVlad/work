package NewYearGift.Controller;

import NewYearGift.Model.Entity.Abstract.Candy;
import NewYearGift.Model.Entity.Chocolate;
import NewYearGift.Model.Entity.Container.Gift;
import NewYearGift.Model.Entity.Lollipop;
import NewYearGift.Model.Logic.Search;
import NewYearGift.Model.Logic.Sort;
import NewYearGift.View.Output;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {




        Candy candy = new Candy(2.3,"KOmunarka",2.1);
        Lollipop lollipop = new Lollipop(.22,"Komunarka",1,2.2,"apple");
        Chocolate chocolate = new Chocolate(2.2,"Vicktoria",3,"Milk",false,"Quad");
        Gift gift = new Gift(candy,lollipop,chocolate);


        Sort.bubble(gift);
        Output.write(gift);

    }

}
