package by.bntu.fitr.prostrmk.model.logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolTest {

    @Test
    public void compare() {
        assertEquals(true, Pol.compare("uouou"));
        assertEquals(false, Pol.compare("asddsaarfegdfbrfhbrgdgdgtmntfbhjdhjbyjh"));
    }


}