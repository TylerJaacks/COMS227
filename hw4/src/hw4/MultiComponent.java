package hw4;

import api.IComponent;

public class MultiComponent extends CompoundComponent implements IComponent {
    /**
     * Constructs a new MultiComponent with one parameter.
     * @param components Represents a IComponent array.
     */
    public MultiComponent(IComponent[] components) {
        super(components[0].inputs().length * components.length, components.length);

        // Inputs are initially invalid.
        for (int i = 0; i < components.length; i++) {
            for (int j = 0; j < components[i].inputs().length; j++)
                components[i].inputs()[j].invalidate();
            for (int j = 0; j < components[i].outputs().length; j++)
                components[i].outputs()[j].invalidate();
        }

        int m = 0;
        int n = 0;

        for (IComponent c : components) {
            addComponent(c);

            for (int i = 0; i < c.inputs().length; i++) {
                inputs()[m].connectTo(c.inputs()[i]);
                m++;
            }

            for (int j = 0; j < c.outputs().length; j++) {
                c.outputs()[j].connectTo(outputs()[n]);
                n++;
            }
        }
    }

    @Override
    public void propagate() {
        for (IComponent c : getComponents()) {
            c.propagate();
        }
    }
}
