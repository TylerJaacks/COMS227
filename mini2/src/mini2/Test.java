package mini2;

public class Test {
    public static void main(String[] args) {
        IntExpression v1 = new IntExpression(2);
        IntExpression v2 = new IntExpression(3);

        System.out.println(v1.toString());
        System.out.println(v2.toString());

        IntExpression v3 = new IntExpression(v1, v2, '+');

        System.out.println(v3.toString());
        System.out.println(v3.getIntValue());

        IntExpression v4 = new IntExpression(v2, v3, '*');

        System.out.println(v4.toString());
    }
}
