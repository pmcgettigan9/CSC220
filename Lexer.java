import java.util.ArrayList;

public class Lexer {
    private String text;
    private int pos = 0;

    public Lexer(String text) {
        this.text = text;
    }

    private char peek() {
        return pos < text.length() ? text.charAt(pos) : '\0';
    }

    private void advance() {
        pos++;
    }

    public ArrayList<Token> tokenize() {
        ArrayList<Token> tokens = new ArrayList<>();

        while (pos < text.length()) {
            char c = peek();

            if (Character.isWhitespace(c)) {
                advance();
                continue;
            }

            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (Character.isDigit(peek())) {
                    num.append(peek());
                    advance();
                }
                tokens.add(new Token(TokenType.NUMBER, num.toString()));
                continue;
            }

            switch (c) {
                case '+': tokens.add(new Token(TokenType.PLUS, "+")); break;
                case '-': tokens.add(new Token(TokenType.MINUS, "-")); break;
                case '*': tokens.add(new Token(TokenType.STAR, "*")); break;
                case '/': tokens.add(new Token(TokenType.SLASH, "/")); break;
                case '(': tokens.add(new Token(TokenType.LPAREN, "(")); break;
                case ')': tokens.add(new Token(TokenType.RPAREN, ")")); break;
                default:
                    throw new RuntimeException("Invalid character: " + c);
            }

            advance();
        }

        tokens.add(new Token(TokenType.EOF, ""));
        return tokens;
    }
}

