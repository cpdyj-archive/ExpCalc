package expcalc.node;

public class IntegerNode extends Token {
    private int i;

    public FloatNode requestFloatNode() {
        return new FloatNode(i,getPos());
    }

    public int getI() {
        return i;
    }

    public IntegerNode(int i,int pos) {
        super(pos);
        this.i = i;
    }

    public IntegerNode(String s,int pos) {
        super(pos);
        this.i = Integer.parseInt(s);
    }

    @Override
    public String toString() {
        return "IntegerNode: " + this.i;
    }
}
