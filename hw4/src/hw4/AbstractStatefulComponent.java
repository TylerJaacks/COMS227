package hw4;

import api.Endpoint;
import api.IComponent;

public abstract class AbstractStatefulComponent implements IComponent {
    private Endpoint[] inputs;
    private Endpoint[] outputs;
    private boolean isEnabled;

    /**
     * Creates a new AbstractComponent
     * @param i The number of inputs
     * @param o The number of outputs
     */
    public AbstractStatefulComponent(int i, int o) {
        inputs = new Endpoint[i];
        outputs = new Endpoint[o];
        isEnabled = false;

        for (int j = 0; j < inputs.length; j++) {
            inputs[j] = new Endpoint(this);
        }

        for (int j = 0; j < outputs.length; j++) {
            outputs[j] = new Endpoint(this);
        }
    }

    /**
     * Returns the array of Endpoints representing this component's inputs.
     *
     * @return array of input Endpoints
     */
    @Override
    public Endpoint[] inputs() {
        return inputs;
    }

    /**
     * Returns the array of Endpoints representing this component's outputs.
     *
     * @return array of output Endpoints
     */
    @Override
    public Endpoint[] outputs() {
        return outputs;
    }

    /**
     * Returns whether all inputs are valid.
     *
     * @return true if all inputs are valid, false otherwise
     */
    @Override
    public boolean inputsValid() {
        for (Endpoint e : inputs) {
            if (!e.isValid()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns whether all outputs are valid.
     *
     * @return true if all outputs are valid, false otherwise
     */
    @Override
    public boolean outputsValid() {
        for (Endpoint e : outputs) {
            if (!e.isValid()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Changes the state of all inputs to invalid.
     */
    @Override
    public void invalidateInputs() {
        for (Endpoint e : inputs) {
            if (e.isValid()) {
                e.invalidate();
            }
        }
    }

    /**
     * Returns whether all outputs are valid.
     *
     * @return true if all outputs are valid, false otherwise
     */
    @Override
    public  void invalidateOutputs() {
        for (int i = 0; i < outputs().length; i++) {
            outputs()[i].set(0);
        }
    }

    /**
     * Clears the internal state, if any (sets to all zeros).
     */
    public void clear() {
        for (int i = 0; i < outputs().length; i++) {
            outputs()[i].set(0);
        }
    }

    /**
     * Propagates inputs to outputs.  Does nothing if not all inputs are valid.
     */
    @Override
    public void propagate() {

    }

    /**
     * Enables updates to the internal state, if any, when processing
     * the tick() operation.
     *
     * @param enabled
     */
    public void setEnabled(boolean state) {
        isEnabled = state;
    }

    /**
     * Check if it is enabled
     */
    public boolean isEnabled() {
        return  isEnabled;
    }
}
