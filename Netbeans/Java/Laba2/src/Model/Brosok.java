/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author prostrmk
 */
public class Brosok {
    public static int brosok() {
        Random random = new Random();
        return (random.nextInt(6) + 1);
    }
}
