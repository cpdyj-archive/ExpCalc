package expcalc;

import expcalc.node.*;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    public static final String PATTERN_STRING = " +|0[Xx]([0-9A-Fa-f]+)|([0-9]+(?:\\.[0-9]+)?)|(?:&&|\\|\\||\\(|\\))|[\\+\\-\\*\\/\\^%<>!=]=|[\\+\\-\\*\\/\\\\^%&|<>!=?:]|([A-z_][A-z0-9_]*)|\\\"([^\"\\\\]|\\\\.)+?\\\"";
    public static final Pattern PATTERN = Pattern.compile(PATTERN_STRING);

    private LinkedList<Node> tokenize0(String str,int lineNum) {
        str = str.trim();
        LinkedList<Node> list = new LinkedList<>();
        Matcher matcher = PATTERN.matcher(str);
        int lastEnd=0;
        while (matcher.find()) {
            if(matcher.start()!=lastEnd){
                throw new RuntimeException("Tokenizer: 无效内容 position: "+lastEnd);
            }else {
                lastEnd=matcher.end();
            }
            // group 1
            if (matcher.group(1) != null) {
                assert matcher.group(2) == null && matcher.group(3) == null;
                // 16进制
                list.add(new IntegerNode(Integer.parseInt(matcher.group(1), 16),matcher.start()));
                continue;
            }
            // group 2
            if (matcher.group(2) != null) {
                assert matcher.group(1) == null && matcher.group(3) == null;
                // number
                String s = matcher.group(2);
                if (s.indexOf('.') > -1) {
                    // float
                    list.add(new FloatNode(s,matcher.start()));
                } else {
                    // integer
                    list.add(new IntegerNode(s,matcher.start()));
                }
                continue;
            }
            // group 3 identity
            if (matcher.group(3) != null) {
                list.add(new IdentifyNode(matcher.group(3),matcher.start()));
                continue;
            }
            // group 4 String.
            if(matcher.group(4)!=null){

            }
            // operator
            OperatorNode.Type t = OperatorNode.Type.getType(matcher.group());
            if (t != null) {
                list.add(new OperatorNode(t,matcher.start()));
                continue;
            }

            // space
            if(matcher.group().trim().length()==0){
                continue;
            }
            System.out.println(matcher.group());
            throw new  ("Tokenizer: 未处理内容 Position: "+matcher.start());
        }
        return list;
    }

    public Node tokenize(String str,int lineNum) {
        LinkedList<Node> list = tokenize0(str,lineNum);
        if (list.size() == 0) {
            return null;
        }
        Node last = null;
        for (Node node : list) {
            if (last != null) {
                last.insertAfter(node);
            }
            last = node;
        }
        return list.getFirst();
    }
}
