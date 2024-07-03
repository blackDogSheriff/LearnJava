package main.java.composite;

import java.util.List;

public class TextNode implements Node {
    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    public List<Node> childern() {
        return List.of();
    }

    public String toXml() {
        return text;
    }
}
