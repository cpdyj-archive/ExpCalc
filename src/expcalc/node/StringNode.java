package expcalc.node;

public class StringNode extends Token {
    private String str;

    public String getStr() {
        return str;
    }

    public StringNode(String str,int pos) {
        super(pos);
        this.str = str;
    }

    @Override
    public String toString() {
        return "StringNode: \""+str+"\"";
    }
}
