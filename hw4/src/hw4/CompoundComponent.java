package hw4;

import api.IComponent;

import java.util.ArrayList;

public class CompoundComponent extends AbstractComponent {
    private ArrayList<IComponent> components;

    /**
     * Constructs a new Compound Component taking two parameters.
     * @param i The number of inputs for the compound component.
     * @param o The number of outputs for the compound component.
     */
    public CompoundComponent(int i, int o) {
        super(i, o);
        components = new ArrayList<>();
    }

    /**
     * Adds a component to the list of components, that make up the Compound Component.
     * @param c The component that you wish to add ArrayList.
     */
    public void addComponent(IComponent c) {
        components.add(c);
    }

    /**
     * Returns a list of components of a compound component.
     * @return The list of compound components.
     */
    public ArrayList<IComponent> getComponents() {
        return components;
    }

    /**
     * Propagates the solution through the component.
     */
    @Override
    public void propagate() {
        for (IComponent c : components) {
            if (c.inputsValid()) {
                c.propagate();
            }
        }
    }
}