package expcalc.node;

public class Token extends Node {
    private int lineNum,position;

    public Token(int position) {
        this.position = position;
    }

    public Token(int lineNum, int position) {
        this.lineNum = lineNum;
        this.position = position;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public int getPos() {
        return position;
    }

    public void setPos(int position) {
        this.position = position;
    }
}
