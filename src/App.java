
// import java.util.Scanner;
// import java.util.function.IntPredicate;
// import java.util.Random;
// import java.io.IOException;
// import java.nio.Buffer;
// import java.io.InputStreamReader;

// import java.security.cert.CertPath;
// import java.io.FileWriter;
// import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Random;

public class App {

    public static double[][] inputdata = new double[314][8];
    public static double[][] desireoutputdata = new double[314][1];
    public int[] firstHiddenlayer;
    public double loss;

    public int rowCount = 314;
    public int columnCount = 9;
    public double[][] trainedData = new double[rowCount][columnCount];

    public static void main(String args[]) {
        ReadandStoreData();

        Layer firsthiddenlayer = new Layer(8, 8);
        Layer outputlayer = new Layer(1, firsthiddenlayer);
        double[][] firsthiddenResult = firsthiddenlayer.feedForward(inputdata);
        double[][] outputResult = outputlayer.feedForward(firsthiddenResult);

        // print output node result
        for (int i = 0; i < outputResult.length; i++) {
            for (int j = 0; j < outputResult[0].length; j++) {
                System.out.print("output row[" + i + "] = " + outputResult[i][j] + " ");
            }
            System.out.println("\n");
        }

        // System.out.println(lossFunction(outputResult, desireoutputdata));

        // System.out.println(firsthiddenResult[0].length);
        // System.out.println(outputResult.length);
        // System.out.println(outputResult[0].length);

        // // print first
        // for (int i = 0; i < firsthiddenResult.length; i++) {
        // for (int j = 0; j < firsthiddenResult[0].length; j++) {
        // System.out.print(firsthiddenResult[i][j] + " ");
        // }
        // System.out.println("\n");
        // }

    }

    public static void ReadandStoreData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            String eachline;
            int loopCount = 0;
            int count = 0;
            String[] str = new String[9];
            int[] nums = new int[9];
            double[] nums2 = new double[9];

            while ((eachline = reader.readLine()) != null) {
                if (loopCount > 1) {
                    str = eachline.split("\t");
                    // to int
                    for (int i = 0; i < 9; i++) {
                        nums[i] = Integer.parseInt(str[i]);
                    }
                    // to double
                    for (int x = 0; x < 9; x++) {
                        Double d = Double.valueOf(nums[x]);
                        nums2[x] = d;

                    }
                    // store input
                    for (int k = 0; k < 8; k++) {
                        inputdata[count - 2][k] = nums2[k];
                    }
                    // store desireoutput
                    desireoutputdata[count - 2][0] = nums2[8];

                }
                loopCount++;
                count++;

            }

            reader.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public static double lossFunction(double[][] output, double[][] label) {
        double sum = 0;
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                sum += Math.pow(output[i][j] - label[i][j], 2);

            }
        }

        return sum * 0.5;

    }

    public static void printInput() {
        for (int i = 0; i < 314; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(inputdata[i][j] + " ");
            }
            System.out.println("\n");
        }

    }

    public static void printDesireoutput() {

        for (int i = 0; i < desireoutputdata.length; i++) {
            System.out.println(desireoutputdata[i][0]);
        }
        System.out.println(inputdata[0][0]);

    }

}