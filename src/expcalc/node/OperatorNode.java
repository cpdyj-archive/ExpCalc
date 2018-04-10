package expcalc.node;

import java.util.HashMap;

public class OperatorNode extends Token {
    public enum Type {
        ADD("+"), SUB("-"), MUL("*"), DIV("/"), MOD("%"), NE("!"),
        EQUAL("=="), GT(">"), LT("<"), GTE(">="), LTE("<="), NEQ("!="),
        LB("("), RB(")"),;

        private String str;
        private static HashMap<String, Type> map;

        @Override
        public String toString() {
            return this.str;
        }

        private void addToMap() {
            if (map == null) {
                map = new HashMap<>();
            }
            assert !map.containsKey(this.str);
            map.put(this.str, this);
        }

        public String getStr() {
            return str;
        }

        Type(String str) {
            this.str = str;
            addToMap();
        }

        public static Type getType(String key) {
            return map.get(key);
        }

    }

    public Type type;

    public OperatorNode(Type type,int pos) {
        super(pos);
        this.type = type;
    }

    public OperatorNode(String str,int pos) {
        super(pos);
        this.type = Type.getType(str);
    }

    @Override
    public String toString() {
        return "OperatorNode: " + type;
    }
}
