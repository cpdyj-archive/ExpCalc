package expcalc.node;

public class FloatNode extends Token{
    private double d;

    public double getD() {
        return d;
    }

    public FloatNode(double d,int pos) {
        super(pos);
        this.d = d;
    }

    public FloatNode(String s,int pos) {
        super(pos);
        this.d = Double.parseDouble(s);
    }

    @Override
    public String toString() {
        return "FloatNode: " + d;
    }
}
