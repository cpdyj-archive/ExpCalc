package expcalc.node;

public class IdentifyNode extends Token {
    private String identify;

    public String getIdentify() {
        return identify;
    }

    public IdentifyNode(String identify,int pos) {
        super(pos);
        this.identify = identify;
    }

    @Override
    public String toString() {
        return "IdentifyNode: "+this.identify;
    }
}
