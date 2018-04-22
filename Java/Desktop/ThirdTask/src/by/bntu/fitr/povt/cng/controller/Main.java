package by.bntu.fitr.povt.cng.controller;


import by.bntu.fitr.povt.cng.model.entity.RapTrack;
import by.bntu.fitr.povt.cng.model.entity.RockTrack;

import by.bntu.fitr.povt.cng.model.entity.container.Disk;
import by.bntu.fitr.povt.cng.model.logic.Sort;

public class Main {

    public static void main(String[] args) {

        Disk disk = new Disk(new RockTrack("asd","asd","rock",2.44,0,"asd",23),
                new RapTrack("asd","asd","rock",4.44,3,140,"grime"),
                new RockTrack("asd","asd","rock",1.44,6,"asd",23));



        Sort.insert(disk);
        System.out.println(disk);

//        Disk disk = new Disk(new RockTrack("me","Mike","Alt","21 pilots",4),new Track("sone","kel","rap"));
//        System.out.println(disk.toString());


    }
}
