package lab7;

import java.util.ArrayList;
import java.util.Random;

public class Methods {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -5, -1, 3, -9};
        System.out.println("Positive Numbers are: " + java.util.Arrays.toString(getPositiveNumbers(arr)));

        System.out.println(java.util.Arrays.toString(randomExperiment(5, 10)));

        ArrayList<String> string = new ArrayList<String>();

        string.add("Hello");
        string.add("World");
        string.add("World");
        string.add("Tyler");
        string.add("Jaacks");

        removeDuplicates(string);

        System.out.println(string);
    }

    public static int[] getPositiveNumbers(int[] numbers) {
        int total = 0;
        int q = 0;
        int r = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                total++;
            }
        }

        int[] positives = new int[total];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                positives[q] = numbers[i];
                q++;
            }
        }

        return positives;
    }

    public static int[] randomExperiment(int max, int iters) {
        Random r = new Random();
        int arr[] = new int[max];

        for (int i = 0; i < iters; i++) {
            int j = r.nextInt(max);

            System.out.println(j);

            arr[j]++;
        }

        return arr;
    }

    public static void removeDuplicates(ArrayList<String> words) {
        ArrayList<String> temp = new ArrayList<String>();

        for (String word : words) {
            if (!temp.contains(word)) {
                temp.add(word);
            }
        }

        words.clear();
        words.addAll(temp);
    }
}