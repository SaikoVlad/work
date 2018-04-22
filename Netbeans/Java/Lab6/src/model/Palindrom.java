/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author prostrmk
 */
public class Palindrom {

    public static boolean getPalindrome(int pal) {
        int next = 0;
        int pal2 = pal;

        while (pal2 != 0) {
            next = (next * 10) + (pal2 % 10);
            pal2 /= 10;
        }

        if (pal == next) {
            return true;
        } else {
            return false;
        }
    }

}
