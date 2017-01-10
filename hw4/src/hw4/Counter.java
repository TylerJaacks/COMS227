package hw4;

import api.IStatefulComponent;

public class Counter extends AbstractStatefulComponent implements IStatefulComponent {
    private int currentState;
    private int n;

    /**
     * Constructs a new counter with n number of outputs.
     * @param n The number of outputs.
     */
    public Counter(int n) {
        super(0, n);

        this.currentState = 0;
        this.n = n;

        clear();
    }

    /**
     * Updates the internal state, if any, provided that the component is enabled.
     */
    @Override
    public void tick() {
        if (isEnabled() && inputsValid()) {
            invalidateOutputs();

            currentState++;

            String binary = Integer.toBinaryString(currentState);

            char c = ' ';
            int num = 0;

            for (int i = 0; i < Math.min(binary.length(), n); i++) {
                c = binary.charAt(binary.length() - i - 1);
                num = Character.getNumericValue(c);
                outputs()[i].set(num);
            }
        }
    }
}
