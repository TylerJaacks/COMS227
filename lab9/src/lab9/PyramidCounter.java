package lab9;

public class PyramidCounter {
    public static void main(String[] args) {
        System.out.println(PyramidCounter(7));
    }

    public static int PyramidCounter(int n) {
        if (n == 1) {
            return 1;
        }

        return (n * n) + PyramidCounter(n - 1);
    }
}