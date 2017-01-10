package mini2;

/**
 * Encapsulates an integer value and a text representation of how
 * the value was obtained.
 */
public class IntExpression {
    /**
     * The integer value stored in this object.
     */
    private final int intValue;

    /**
     * Text of the expression via which this value was obtained.
     */
    private final String text;

    /**
     * Constructs an IntExpression of an integer literal.
     *
     * @param v integer value
     */
    public IntExpression(int v) {
        intValue = v;
        text = "" + v;
    }

    /**
     * Constructs a new IntExpression by combining the two given IntExpression
     * objects using the given operator.  Allowed operators are '+', '-', '*',
     * and '/'.
     *
     * @param e1 left hand side
     * @param e2 right hand side
     * @param op operator with which to combine e1 and e2
     */
    public IntExpression(IntExpression e1, IntExpression e2, char op) {
        // compute the value using the given operator
        if (op == '+') {
            intValue = e1.getIntValue() + e2.getIntValue();
        } else if (op == '-') {
            intValue = e1.getIntValue() - e2.getIntValue();
        } else if (op == '*') {
            intValue = e1.getIntValue() * e2.getIntValue();
        } else if (op == '/') {
            intValue = e1.getIntValue() / e2.getIntValue();
        } else {
            throw new IllegalArgumentException("Operator must be one of '+', '*', '-', '/'");
        }

        // finally, create a text representation of the combined expression
        text = "(" + e1 + " " + op + " " + e2 + ")";
    }

    /**
     * Returns the integer value stored in this object.
     *
     * @return the integer value of this object
     */
    public int getIntValue() {
        return intValue;
    }

    /**
     * Returns the text representation of this object.
     *
     * @return string representation of this object
     */
    @Override
    public String toString() {
        return text;
    }
}