package by.bntu.fitr.povt.prostrmk.model.entity.container;

import by.bntu.fitr.povt.prostrmk.model.entity.Bread;
import by.bntu.fitr.povt.prostrmk.model.entity.Milk;
import by.bntu.fitr.povt.prostrmk.model.entity.Orange;
import by.bntu.fitr.povt.prostrmk.model.entity.Snickers;

public class Basket {

    public static final int DEFAULT_SIZE = 10;
    public Snickers[] s;
    public Milk[] milks;
    public Bread[] breads;
    public Orange[] oranges;
    private int countO = 0;
    private int countM = 0;
    private int countB = 0;
    private int countS = 0;

    public int getCountS() {
        return countS;
    }
    
    public int getCountB() {
        return countB;
    }

    public int getCountM() {
        return countM;
    }

    public int getCountO() {
        return countO;
    }

    public Basket() {
        milks = new Milk[DEFAULT_SIZE];
        breads = new Bread[DEFAULT_SIZE];
        oranges = new Orange[DEFAULT_SIZE];
        s = new Snickers[DEFAULT_SIZE];
    }

    public Basket(int size) {
        milks = new Milk[size];
        breads = new Bread[size];
        oranges = new Orange[size];
        s = new Snickers[size];
    }

    public Basket(Snickers[] s, Milk[] milks, Bread[] breads, Orange[] oranges) {
        this.s = s;
        this.milks = milks;
        this.breads = breads;
        this.oranges = oranges;
    }

    public boolean add(Snickers ss) {
        if (countS < s.length) {
            s[countS++] = ss;
            return true;
        }

        return false;
    }

    
    public boolean add(Orange o) {
        if (countO < oranges.length) {
            oranges[countO++] = o;
            return true;
        }

        return false;
    }

    public boolean add(Milk m) {
        if (countM < milks.length) {
            milks[countM++] = m;
            return true;
        }

        return false;
    }

    public boolean add(Bread b) {
        if (countB < breads.length) {
            breads[countB++] = b;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("List of products:\n");

        for (int i = 0; i < countM; i++) {
            builder.append(milks[i]).append("\n");
        }

        for (Snickers sn : s) {
            if (sn != null) {
                builder.append(sn).append("\n");
            } else {
                break;
            }
        }
        
        for (Bread b : breads) {
            if (b != null) {
                builder.append(b).append("\n");
            } else {
                break;
            }
        }

           for (Orange orange : oranges) {
            if (orange != null) {
                builder.append(orange).append("\n");
            } else {
                break;
            }
        }

        return builder + "";
    }
}
