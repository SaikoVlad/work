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
public class NodAndNokFinder {

    public static int finderOfNod(int a, int b) {
        return b == 0 ? a : finderOfNod(b,a % b);
    }

    public static int finderOfNok(int a, int b) {
        return (a/finderOfNod(a, b) * b);
    }

}
