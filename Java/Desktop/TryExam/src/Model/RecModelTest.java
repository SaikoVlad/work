package Model;

import static org.junit.Assert.*;

public class RecModelTest {

    @org.junit.Test
    public void recursion() {
        try {

            assertEquals(true, RecModel.recursion(3, 2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}