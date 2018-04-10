package expcalc;

import expcalc.node.Node;

public class TokenizerTest {
    static String testString = "3+5-35.8*()5==7iden 0xAf56t ident2 ident3ident5de5";

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        Node node = tokenizer.tokenize(testString,1);
        while (node != null) {
            System.out.println(node);
            node = node.getNext();
        }
    }
}
