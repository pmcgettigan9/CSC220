import java.util.List;

public class Parser {
    private List<Token> tokens;
    private int pos = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    private Token peek() {
        return tokens.get(pos);
    }

    private Token eat(TokenType type) {
        if (peek().type == type) {
            return tokens.get(pos++);
        }
        throw new RuntimeException("Expected " + type + " but got " + peek().type);
    }

    // Grammar:
    // E → T ((+|-) T)*
    // T → F ((*|/) F)*
    // F → NUMBER | (E) | -F

    public Node parseExpression() {
        Node node = parseTerm();

        while (peek().type == TokenType.PLUS || peek().type == TokenType.MINUS) {
            String op = peek().value;
            eat(peek().type);
            Node right = parseTerm();
            node = new BinaryOpNode(op, node, right);
        }

        return node;
    }

    private Node parseTerm() {
        Node node = parseFactor();

        while (peek().type == TokenType.STAR || peek().type == TokenType.SLASH) {
            String op = peek().value;
            eat(peek().type);
            Node right = parseFactor();
            node = new BinaryOpNode(op, node, right);
        }

        return node;
    }

    private Node parseFactor() {
        Token t = peek();

        // Unary minus
        if (t.type == TokenType.MINUS) {
            eat(TokenType.MINUS);
            return new UnaryOpNode("-", parseFactor());
        }

        // Parentheses
        if (t.type == TokenType.LPAREN) {
            eat(TokenType.LPAREN);
            Node node = parseExpression();
            eat(TokenType.RPAREN);
            return node;
        }

        // Number
        if (t.type == TokenType.NUMBER) {
            eat(TokenType.NUMBER);
            return new NumberNode(Double.parseDouble(t.value));
        }

        throw new RuntimeException("Unexpected token: " + t.value);
    }
}

