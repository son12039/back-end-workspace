package artificialNeuralNetwork;

import java.util.Arrays;

public class NeuralNetwork {
    private int inputLayerSize;
    private int hiddenLayerSize;
    private int outputLayerSize;

    private double[][] weightsInputToHidden;
    private double[][] weightsHiddenToOutput;
    private double[] hiddenLayerBias;
    private double[] outputLayerBias;

    public NeuralNetwork(int inputLayerSize, int hiddenLayerSize, int outputLayerSize) {
        this.inputLayerSize = inputLayerSize;
        this.hiddenLayerSize = hiddenLayerSize;
        this.outputLayerSize = outputLayerSize;

        this.weightsInputToHidden = new double[inputLayerSize][hiddenLayerSize];
        this.weightsHiddenToOutput = new double[hiddenLayerSize][outputLayerSize];
        this.hiddenLayerBias = new double[hiddenLayerSize];
        this.outputLayerBias = new double[outputLayerSize];

        initializeWeights();
    }

    private void initializeWeights() {
        for (int i = 0; i < inputLayerSize; i++) {
            for (int j = 0; j < hiddenLayerSize; j++) {
                weightsInputToHidden[i][j] = Math.random();
            }
        }
        for (int i = 0; i < hiddenLayerSize; i++) {
            for (int j = 0; j < outputLayerSize; j++) {
                weightsHiddenToOutput[i][j] = Math.random();
            }
        }
        Arrays.fill(hiddenLayerBias, Math.random());
        Arrays.fill(outputLayerBias, Math.random());
    }

    private double[] sigmoid(double[] x) {
        double[] result = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = 1 / (1 + Math.exp(-x[i]));
        }
        return result;
    }

    private double[] sigmoidDerivative(double[] x) {
        double[] result = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = x[i] * (1 - x[i]);
        }
        return result;
    }

    public double[] feedForward(double[] inputs) {
        double[] hiddenLayerInput = new double[hiddenLayerSize];
        for (int i = 0; i < hiddenLayerSize; i++) {
            for (int j = 0; j < inputLayerSize; j++) {
                hiddenLayerInput[i] += inputs[j] * weightsInputToHidden[j][i];
            }
            hiddenLayerInput[i] += hiddenLayerBias[i];
        }
        double[] hiddenLayerOutput = sigmoid(hiddenLayerInput);

        double[] outputLayerInput = new double[outputLayerSize];
        for (int i = 0; i < outputLayerSize; i++) {
            for (int j = 0; j < hiddenLayerSize; j++) {
                outputLayerInput[i] += hiddenLayerOutput[j] * weightsHiddenToOutput[j][i];
            }
            outputLayerInput[i] += outputLayerBias[i];
        }
        return sigmoid(outputLayerInput);
    }

    public void train(double[][] inputs, double[][] outputs, int epochs, double learningRate) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int i = 0; i < inputs.length; i++) {
                double[] hiddenLayerInput = new double[hiddenLayerSize];
                for (int j = 0; j < hiddenLayerSize; j++) {
                    for (int k = 0; k < inputLayerSize; k++) {
                        hiddenLayerInput[j] += inputs[i][k] * weightsInputToHidden[k][j];
                    }
                    hiddenLayerInput[j] += hiddenLayerBias[j];
                }
                double[] hiddenLayerOutput = sigmoid(hiddenLayerInput);

                double[] outputLayerInput = new double[outputLayerSize];
                for (int j = 0; j < outputLayerSize; j++) {
                    for (int k = 0; k < hiddenLayerSize; k++) {
                        outputLayerInput[j] += hiddenLayerOutput[k] * weightsHiddenToOutput[k][j];
                    }
                    outputLayerInput[j] += outputLayerBias[j];
                }
                double[] outputLayerOutput = sigmoid(outputLayerInput);

                double[] outputError = new double[outputLayerSize];
                for (int j = 0; j < outputLayerSize; j++) {
                    outputError[j] = outputs[i][j] - outputLayerOutput[j];
                }
                double[] outputDelta = new double[outputLayerSize];
                for (int j = 0; j < outputLayerSize; j++) {
                    outputDelta[j] = outputError[j] * sigmoidDerivative(outputLayerOutput)[j];
                }

                double[] hiddenError = new double[hiddenLayerSize];
                for (int j = 0; j < hiddenLayerSize; j++) {
                    for (int k = 0; k < outputLayerSize; k++) {
                        hiddenError[j] += outputDelta[k] * weightsHiddenToOutput[j][k];
                    }
                }
                double[] hiddenDelta = new double[hiddenLayerSize];
                for (int j = 0; j < hiddenLayerSize; j++) {
                    hiddenDelta[j] = hiddenError[j] * sigmoidDerivative(hiddenLayerOutput)[j];
                }

                for (int j = 0; j < hiddenLayerSize; j++) {
                    for (int k = 0; k < outputLayerSize; k++) {
                        weightsHiddenToOutput[j][k] += hiddenLayerOutput[j] * outputDelta[k] * learningRate;
                    }
                }
                for (int j = 0; j < outputLayerSize; j++) {
                    outputLayerBias[j] += outputDelta[j] * learningRate;
                }

                for (int j = 0; j < inputLayerSize; j++) {
                    for (int k = 0; k < hiddenLayerSize; k++) {
                        weightsInputToHidden[j][k] += inputs[i][j] * hiddenDelta[k] * learningRate;
                    }
                }
                for (int j = 0; j < hiddenLayerSize; j++) {
                    hiddenLayerBias[j] += hiddenDelta[j] * learningRate;
                }
            }
        }
    }
}

