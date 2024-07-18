package artificialNeuralNetwork;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {	 	
    	
        NeuralNetwork nn = new NeuralNetwork(2, 2, 1);

        // AND 연산을 학습하는 예제 데이터
        double[][] trainingInputs = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
        };

        double[][] trainingOutputs = {
            {0},
            {0},
            {0},
            {1}
        };

        // 신경망 학습
        nn.train(trainingInputs, trainingOutputs, 10000, 0.1);

        // 테스트 입력
        double[] testInput1 = {0, 0};
        double[] testInput2 = {0, 1};
        double[] testInput3 = {1, 0};
        double[] testInput4 = {1, 1};

        System.out.println("Test Input: " + Arrays.toString(testInput1) + " Output: " + Arrays.toString(nn.feedForward(testInput1)));
        System.out.println("Test Input: " + Arrays.toString(testInput2) + " Output: " + Arrays.toString(nn.feedForward(testInput2)));
        System.out.println("Test Input: " + Arrays.toString(testInput3) + " Output: " + Arrays.toString(nn.feedForward(testInput3)));
        System.out.println("Test Input: " + Arrays.toString(testInput4) + " Output: " + Arrays.toString(nn.feedForward(testInput4)));
    }
}

