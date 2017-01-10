package lab9;

public class MaxNumber {
    public static void main(String[] args) {
        int[] ar1 = {1, 125, 6, 3, 2, 89};

        System.out.println(arraySum(ar1));
    }

    public static int arraySum(int[] arr) {
        return max(arr, 0, arr.length - 1);
    }

    private static int max(int[] arr, int start, int end) {
        int max = 0;

        if (start == end) {
            return arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftMax = max(arr, start, mid);
            int rightMax = max(arr, mid + 1, end);
            return Math.max(leftMax, rightMax);
        }
    }
}
