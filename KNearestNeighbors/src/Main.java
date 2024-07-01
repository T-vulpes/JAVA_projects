//The K-Nearest Neighbors (KNN) classifier is a simple, yet powerful,
// machine learning algorithm used for classification tasks. This project
// implements the KNN algorithm in Java, allowing users to classify new data points
// based on the closest examples in the training dataset. The classifier determines
// the class of a new point by looking at the 'k' nearest neighbors in the feature space and selecting the most common class among them.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    private int k;
    private double[][] data;
    private String[] labels;

    public Main(int k, double[][] data, String[] labels) {
        this.k = k;
        this.data = data;
        this.labels = labels;
    }

    public String classify(double[] newPoint) {
        double[] distances = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            distances[i] = distance(newPoint, data[i]);
        }

        int[] indices = argsort(distances);
        Map<String, Integer> voteCount = new HashMap<>();

        for (int i = 0; i < k; i++) {
            String label = labels[indices[i]];
            voteCount.put(label, voteCount.getOrDefault(label, 0) + 1);
        }

        return voteCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    private double distance(double[] point1, double[] point2) {
        double sum = 0;
        for (int i = 0; i < point1.length; i++) {
            sum += Math.pow(point1[i] - point2[i], 2);
        }
        return Math.sqrt(sum);
    }

    private int[] argsort(double[] array) {
        return IntStream.range(0, array.length)
                .boxed()
                .sorted((i, j) -> Double.compare(array[i], array[j]))
                .mapToInt(ele -> ele)
                .toArray();
    }

    public static void main(String[] args) {
        double[][] data = {
                {1.0, 2.0},
                {1.5, 1.8},
                {5.0, 8.0},
                {8.0, 8.0},
                {1.0, 0.6},
                {9.0, 11.0}
        };
        String[] labels = {"U", "X", "B", "B", "C", "D"};
        Main knn = new Main(3, data, labels);

        double[] newPoint = {2.0, 3.0};
        String result = knn.classify(newPoint);

        System.out.println("Classified as: " + result);
    }
}
