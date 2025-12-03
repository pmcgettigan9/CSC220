public class NumberNode extends Node {
    public double value;

    public NumberNode(double value) {
        this.value = value;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + value);
    }
}

