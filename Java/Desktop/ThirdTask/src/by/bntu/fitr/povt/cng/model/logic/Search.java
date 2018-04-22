package by.bntu.fitr.povt.cng.model.logic;


import by.bntu.fitr.povt.cng.model.entity.container.Disk;

public class Search {

    public static String findByName(Disk disk,String name){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < disk.getSize(); i++) {
            if (disk.getTrackName(i).equals(name)){
                out.append("\nThat's track with name ").append(name).append("\n").append(disk.getTrack(i).toString());
            }
        }
        return out.toString();
    }

}
