public class BinaryOpNode extends Node {
    public String op;
    public Node left;
    public Node right;

    public BinaryOpNode(String op, Node left, Node right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + op);
        left.print(indent + "  ");
        right.print(indent + "  ");
    }
}

