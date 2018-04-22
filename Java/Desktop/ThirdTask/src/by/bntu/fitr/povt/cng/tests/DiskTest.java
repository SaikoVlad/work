package by.bntu.fitr.povt.cng.tests;

import by.bntu.fitr.povt.cng.model.entity.RockTrack;
import by.bntu.fitr.povt.cng.model.entity.container.Disk;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiskTest {

    @Test
    public void getSize() {
        Disk disk = new Disk(new RockTrack("asd","asd","rock",12,2.44,"asd",23),
                new RockTrack("asd","asd","rock",12,2.44,"asd",23),
                new RockTrack("asd","asd","rock",12,2.44,"asd",23));
        assertEquals(3,disk.getSize());
    }

    @Test
    public void getTrackName() {
        Disk disk = new Disk(new RockTrack("Live","asd","rock",12,2.44,"asd",23),
                new RockTrack("asd","asd","rock",12,2.44,"asd",23),
                new RockTrack("asd","asd","rock",12,2.44,"asd",23));
        assertEquals("Live", disk.getTrackName(0));
    }

    @Test
    public void getTrackAutor() {
        Disk disk = new Disk(new RockTrack("Live","Marlin Manson","rock",12,2.44,"asd",23),
                new RockTrack("asd","Victor Tsoi","rock",12,2.44,"asd",23),
                new RockTrack("asd","Curt Cobain","rock",12,2.44,"asd",23));
        assertEquals("Curt Cobain", disk.getTrackAutor(2));
    }

    @Test
    public void getTrackLength() {
        Disk disk = new Disk(new RockTrack("Live","Marlin Manson","rock",12,2.44,"asd",23),
                new RockTrack("asd","Victor Tsoi","rock",12,2.44,"asd",23),
                new RockTrack("asd","Curt Cobain","rock",12,14.44,"asd",23));
        assertEquals(12,disk.getTrackLength(2),0.1);

    }
}