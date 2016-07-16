package sample;

import java.util.Random;

public class TreeFactoryImpl implements TreeFactory {

    public int[] generateTree() {
        int length = 1000;
        int level = 5;
        int[] tree = new int[length];
        Random r = new Random();
        int counter = 0;
        for (int i = 0, j = 0; i < length; i++) {
            tree[i] = j;
            if (counter == 0) {
                counter = level + r.nextInt(5);
                j++;
            } else {
                counter--;
            }
        }
        return tree;
    }
}
