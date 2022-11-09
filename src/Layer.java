
public class Layer {

    public Neuron neurons[];

    public Layer(int nodeCount, Layer l) {
        this.neurons = new Neuron[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            neurons[i] = new Neuron(l.neurons.length);
        }

    }

    public Layer(int nodeCount, int inputnodeCount) {
        this.neurons = new Neuron[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            neurons[i] = new Neuron(inputnodeCount);
        }

    }

    public double[][] feedForward(double[][] x) {

        double[][] y = new double[x.length][this.neurons.length];

        for (int i = 0; i < x.length; i++) {
            for (int k = 0; k < this.neurons.length; k++) {

                y[i][k] = this.neurons[k].activationFucntion(x[i]);

            }
        }

        return y;

    }

}
