package hw4;

import api.IStatefulComponent;

public class Register extends AbstractStatefulComponent implements IStatefulComponent {
    /**
     * Constructs a new register.
     * @param n The number inputs and outputs.
     */
    public Register(int n) {
        super(n, n);

        clear();
    }

    /**
     * Updates the internal state, if any, provided that the component is enabled.
     */
    @Override
    public void tick() {
        int[] currentState = new int[inputs().length];

        if (isEnabled() && inputsValid()) {
            for (int i = 0; i < inputs().length; i++) {
                currentState[i] = inputs()[i].getValue();
            }

            for (int j = 0; j < outputs().length; j++) {
                outputs()[j].set(currentState[j]);
            }
        }
    }
}