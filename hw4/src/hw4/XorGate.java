package hw4;

public class XorGate extends AbstractComponent {
    /**
     * Constructs a new XorGate object that sets the two inputs and output to new endpoints.
     */
    public XorGate() {
        super(2, 1);
    }

    /**
     * Propagates inputs to outputs.  Does nothing if not all inputs are valid.
     */
    @Override
    public void propagate() {
        int newValue = 0;

        if (inputsValid()) {
            if (inputs()[0].getValue() == inputs()[1].getValue()) {
                newValue = 0;
            } else if (inputs()[0].getValue() == 1 || inputs()[1].getValue() == 1) {
                newValue = 1;
            }

            outputs()[0].set(newValue);
        }
    }
}