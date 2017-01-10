package hw4;

public class NotGate extends AbstractComponent {
    /**
     * Constructs a new NotGate object that sets the one inputs and output to new endpoints.
     */
    public NotGate() {
        super(1, 1);
    }

    /**
     * Propagates inputs to outputs.  Does nothing if not all inputs are valid.
     */
    @Override
    public void propagate() {
        int newValue = 0;

        if (inputsValid()) {
            if (inputs()[0].getValue() == 0) {
                newValue = 1;
            }

            outputs()[0].set(newValue);
        }
    }
}
