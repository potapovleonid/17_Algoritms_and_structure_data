package geekbrains.home.des;

import java.util.Random;

public class TestApp {
    public static void main(String[] args) {



        Integer[] array = new Integer[100000];
        System.out.println("start generate Array!");
        Long timesStart = System.currentTimeMillis();


        for (int i = 0; i < 100000; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }

        Long timesEnd = System.currentTimeMillis();
        System.out.println("generate Array time: " + (timesEnd - timesStart));

        ArrayImpl<Integer> array1 = new ArrayImpl<>(100000);
        ArrayImpl<Integer> array2 = new ArrayImpl<>(100000);
        ArrayImpl<Integer> array3 = new ArrayImpl<>(100000);

        array1.setData(array);
        array2.setData(array);
        array3.setData(array);

        System.out.println("start sort buble");
        timesStart = System.currentTimeMillis();
        array1.sortBubble();
        timesEnd = System.currentTimeMillis();
        System.out.println("end sorted Bubble time: " + (timesEnd - timesStart));

        System.out.println("start sort insert");
        timesStart = System.currentTimeMillis();
        array2.sortInsert();
        timesEnd = System.currentTimeMillis();
        System.out.println("end sorted insert time: " + (timesEnd - timesStart));

        System.out.println("start sort select");
        timesStart = System.currentTimeMillis();
        array3.sortSelect();
        timesEnd = System.currentTimeMillis();
        System.out.println("end sorted select time: " + (timesEnd - timesStart));

    }
}
