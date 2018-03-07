package expcalc;

import java.util.regex.Pattern;

public class Tokenizer {
    public static final String PATTERN_STRING = " +|([0-9]+(?:\\.[0-9]+)?)|0[Xx]([0-9A-Fa-f]+)|(?:&&|\\|\\||\\(|\\))|[\\+\\-\\*\\/\\^%<>!]=|[\\+\\-\\*\\/\\\\^%&|<>!=?:]|([A-z_][A-z0-9_]*)(?: *\\()?";
    public static final Pattern PATTERN = Pattern.compile(PATTERN_STRING);

}
