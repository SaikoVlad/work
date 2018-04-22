package by.bntu.fitr.povt.cng.model.logic;


import by.bntu.fitr.povt.cng.model.entity.abstracts.Track;
import by.bntu.fitr.povt.cng.model.entity.container.Disk;

public class Sort {


    public static void insert(Disk disk) {
        Track temp;
        int j;
        for(int i = 0; i < disk.getSize() - 1; i++){
            if (disk.getTrackLength(i) > disk.getTrackLength(i + 1)) {
                temp = disk.getTrack(i + 1);
                disk.changeTrack(disk.getTrack(i),i + 1);
                j = i;
                while (j > 0 && temp.getLength() < disk.getTrackLength(j - 1)) {
                    disk.changeTrack(disk.getTrack(j - 1),j);
                    j--;
                }
                disk.changeTrack(temp,j);
            }
        }
    }

//
//
//    public static void bubble(Tree tree) {
//        boolean sorted = true;
//        for (int i = tree.getSize(); i > 0; i--) {
//            for (int j = 0; j < i - 1; j++) {
//                if (tree.getToy(j).getPrice() > tree.getToy(j + 1).getPrice()) {
//                    Toy tmp = tree.getToy(j);
//                    tree.changeToy(tree.getToy(j + 1), j);
//                    tree.changeToy(tmp, j + 1);
//                    sorted = false;
//                }
//                if (sorted){
//                    break;
//                }
//
//            }
//        }
//    }



}
