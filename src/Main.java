public class Main {
    public static void main(String[] args) {
        String input = "(3 + 2) * 5 - 1"; // You can change this or make a Scanner

        System.out.println("Input: " + input);
        System.out.println();

        // Tokenizer
        Lexer lexer = new Lexer(input);
        var tokens = lexer.tokenize();
        System.out.println("Tokens: " + tokens);
        System.out.println();

        // Parser → AST
        Parser parser = new Parser(tokens);
        Node ast = parser.parseExpression();

        System.out.println("Parse Tree:");
        ast.print("");
        System.out.println();

        // Evaluator
        Evaluator evaluator = new Evaluator();
        double result = evaluator.eval(ast);

        System.out.println("Evaluation Result: " + result);
    }
}

