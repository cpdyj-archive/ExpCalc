package expcalc.node;

public class OperatorNode extends Node {
    public enum Type {
        ADD, SUB, MUL, DIV, MOD, NE,
        EQUAL, GT, LT, GTE, LTE, NEQ,
        LB, RB,
    }

    public Type type;

    public OperatorNode(Type type) {
        this.type = type;
    }
}
