
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.Random;
import java.io.IOException;
import java.nio.Buffer;
import java.io.InputStreamReader;

import java.security.cert.CertPath;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;

public class App {

    public static int rowCount = 314;
    public static int columnCount = 9;
    public static int[][] data = new int[314][9];

    public static Mymed m;

    public static void main(String args[]) {
        ReadandStoreData();

        System.out.println(m.doubleNumber(4));

    }

    public static void ReadandStoreData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            String eachline;
            int loopCount = 0;
            int count = 0;
            String[] str = new String[9];
            int[] nums = new int[9];

            while ((eachline = reader.readLine()) != null) {
                if (loopCount > 1) {
                    str = eachline.split("\t");
                    for (int i = 0; i < 9; i++) {
                        nums[i] = Integer.parseInt(str[i]);
                    }
                    for (int k = 0; k < 9; k++) {
                        data[count - 2][k] = nums[k];
                    }

                }
                loopCount++;
                count++;

            }

            reader.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
