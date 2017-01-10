package hw4;

public class Multiplexer extends AbstractComponent {
    private int k;

    /**
     * Constructs a new Multiplexer
     * @param k The variable for the number of inputs formula.
     */
    public Multiplexer(int k) {
        super(((int) Math.pow(2, k) + k), 1);

        this.k = k;
    }

    /**
     * Propagates the solution through the component.
     */
    @Override
    public void propagate() {
        int constant = k - 1;
        int output = 0;

        for (int i = (int) (Math.pow(2, k) + k) - 1; i >= (int) (Math.pow(2, k) + k) - k; i--) {
            output += inputs()[i].getValue() * Math.pow(2, constant);
            constant--;
        }

        outputs()[0].set(inputs()[output].getValue());
    }
}
