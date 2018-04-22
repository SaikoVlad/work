/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.fitr.povt.model.Test;

import by.bntu.fitr.povt.model.GlasSoglas;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prostrmk
 */
public class GlasSoglasTest {
    
    public GlasSoglasTest() {
    }

    @Test
    public void testObrabotka() {
        String bukvi, s;
        String glas = "ЁёУуЕеЫыАаОоЭэЯяИиЮю";
        String sogl = "БбВвГгДдЖжЗзЙйКкЛлМмНнПпРрСсТтФфХхЦцЧчШшЩщ";

        char[] glasAraay = glas.toCharArray();
        char[] soglAraay = sogl.toCharArray();
        char[] bukviArray = new char[1];
        bukviArray[0] = 'л';
        s = "л - согласная";
        assertEquals(s,GlasSoglas.obrabotka(bukviArray[0], glasAraay, soglAraay));
    }
    
}
