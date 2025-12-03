public class UnaryOpNode extends Node {
    public String op;
    public Node child;

    public UnaryOpNode(String op, Node child) {
        this.op = op;
        this.child = child;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + op);
        child.print(indent + "  ");
    }
}

