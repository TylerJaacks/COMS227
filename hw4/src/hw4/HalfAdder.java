package hw4;

import api.IComponent;

public class HalfAdder extends CompoundComponent {
    private IComponent andGate;
    private IComponent xorGate;

    /**
     * Constructs a new HalfAdder.
     */
    public HalfAdder() {
        super(2, 2);

        andGate = new AndGate();
        xorGate = new XorGate();

        addComponent(andGate);
        addComponent(xorGate);

        inputs()[0].connectTo(xorGate.inputs()[0]);
        inputs()[1].connectTo(xorGate.inputs()[1]);

        xorGate.inputs()[0].connectTo(andGate.inputs()[0]);
        xorGate.inputs()[1].connectTo(andGate.inputs()[1]);

        xorGate.outputs()[0].connectTo(outputs()[0]);
        andGate.outputs()[0].connectTo(outputs()[1]);
    }
}