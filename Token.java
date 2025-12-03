public class Token {
    public TokenType type;
    public String value;

    public Token(TokenType t, String v) {
        this.type = t;
        this.value = v;
    }

    public String toString() {
        return value;
    }
}

