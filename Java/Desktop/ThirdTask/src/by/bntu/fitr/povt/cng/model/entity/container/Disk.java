package by.bntu.fitr.povt.cng.model.entity.container;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Track;

public class Disk {
    private Track[] plate;

    public Disk() {
    }

    public Disk(Track...plate) {
        this.plate = plate;
    }


    public void changeTrack(Track newTrack, int index){
        plate[index] = newTrack;
    }

    public int getSize(){
        return plate.length;
    }

    public void setNewTrack(Track newTrack, int index){
        Track[] temp = new Track[plate.length + 1];
        for (int i = 0; i < plate.length; i++) {
            if (i < index) {
                temp[i] = plate[i];
            } else {
                temp[i + 1] = plate[i];
            }
        }
        temp[index] = newTrack;
        plate = temp;
    }

    public String getTrackName(int index){
        return plate[index].getName();
    }

    public String getTrackAutor(int index){
        return plate[index].getAuthor();
    }

    public double getTrackLength(int index){
        return plate[index].getLength();
    }

    public Track getTrack(int index){
        return plate[index];
    }

    public double getDiskLength(){
        double allLength = 0;
        for(Track tr : plate){
            allLength += tr.getLength() - (tr.getLength()/100 * tr.getDefeated());
        }
        return allLength;
    }

    public double typeLength(String searchGenre){
        double out = 0;
        for(Track tr: plate){
            if (tr.getGenre().equals(searchGenre)){
                out += tr.getLength();
            }
        }
        return out;
    }





    public void add(Track newTrack) {
        int index = plate.length;
        Track[] temp = new Track[plate.length + 1];
        for (int i = 0; i < plate.length; i++) {
            if (i < index) {
                temp[i] = plate[i];
            } else {
                temp[i + 1] = plate[i];
            }
        }
        temp[index] = newTrack;
        plate = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Track track : plate) {
            sb.append(track.toString()).append("\n");
        }
        return sb.toString();
    }

}
