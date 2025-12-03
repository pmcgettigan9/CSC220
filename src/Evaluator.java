public class Evaluator {
    public double eval(Node node) {
        if (node instanceof NumberNode) {
            return ((NumberNode) node).value;
        }

        if (node instanceof UnaryOpNode) {
            UnaryOpNode u = (UnaryOpNode) node;
            if (u.op.equals("-"))
                return -eval(u.child);
        }

        if (node instanceof BinaryOpNode) {
            BinaryOpNode b = (BinaryOpNode) node;

            double left = eval(b.left);
            double right = eval(b.right);

            switch (b.op) {
                case "+": return left + right;
                case "-": return left - right;
                case "*": return left * right;
                case "/": return left / right;
            }
        }

        throw new RuntimeException("Unknown node type");
    }
}

