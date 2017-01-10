package hw4;

public class AndGate extends AbstractComponent {
    /**
     * Constructs a new AndGate object that sets the two inputs and output to new endpoints.
     */
    public AndGate() {
        super(2, 1);
    }

    /**
     * Propagates inputs to outputs.  Does nothing if not all inputs are valid.
     */
    @Override
    public void propagate() {
        if (inputsValid()) {
            outputs()[0].set(inputs()[0].getValue() * inputs()[1].getValue());
        }
    }
}