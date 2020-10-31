package ir.ac.kntu;// comment this before uploading

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author your name
 */
public class Main {
    public static void main(String[] args) {
        // TODO: get the inputs and do as described
        //at the end copy all classes in one .java file without the
        // package and upload the java file
        int sum=0;
        Scanner scanner = new Scanner(System.in);
        int sizeOfThread = scanner.nextInt();
        int sizeOfArray = scanner.nextInt();
        int step = sizeOfArray / sizeOfThread;
        int take = step;
        int leftover = sizeOfArray % sizeOfThread;
        int j=0;
        long time=System.currentTimeMillis();
        Thread[] t = new Thread[sizeOfThread];
        ArraySummer as = null;
        ArraySummer[] arraySummers=new ArraySummer[sizeOfThread];
        Integer[] array = new Integer[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
                array[i] = scanner.nextInt();
        }
        for (int i = 0; i < sizeOfArray; i += take) {
            if (leftover > 0) {
                leftover--;
                take = step + 1;
            } else {
                take = step;
            }

            as = new ArraySummer(array, i, i+take);
            t[j] = new Thread(as);
            t[j].start();
            arraySummers[j]=as;
            j++;
        }
        for (Thread thread:t){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (ArraySummer z:arraySummers){
            sum+=z.getSum();
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis()-time);
    }


}



