package expcalc.node;

public class IntegerNode extends Node {
    private int i;

    public FloatNode requestFloatNode() {
        return new FloatNode(i);
    }

    public int getI() {
        return i;
    }

    public IntegerNode(int i) {

        this.i = i;
    }
}
