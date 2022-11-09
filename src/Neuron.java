
import java.util.Random;

public class Neuron {

    // input output and weight
    public int[][] inputdata;

    public double[] preWeight;
    // random
    public double rangeMin = -1.0;
    public double rangeMax = 1.0;

    // constant
    public double bias = 1.0;
    public double e = 2.71828182846;

    // constructor
    public Neuron(int weightCount) {
        this.preWeight = new double[weightCount];
        for (int i = 0; i < weightCount; i++) {
            double r = new Random().nextDouble();
            double result = rangeMin + (r * (rangeMax - rangeMin));
            this.preWeight[i] = result;

        }

    }

    // public static void setfirstWeight() {

    // for (int i = 0; i < 314; i++) {
    // for (int j = 0; j < 8; j++) {
    // double r = new Random().nextDouble();
    // double result = rangeMin + (r * (rangeMax - rangeMin));
    // weight[i][j] = result;
    // }
    // }

    // }

    public double activationFucntion(double[] data) {
        // net value
        double net = 0.0;

        for (int i = 0; i < data.length; i++) {
            net += data[i] * this.preWeight[i];

        }

        // net with theta
        net = net + this.bias;
        // activation
        double activateValue = net <= 0 ? 0 : net;

        return (double) net;

    }

}