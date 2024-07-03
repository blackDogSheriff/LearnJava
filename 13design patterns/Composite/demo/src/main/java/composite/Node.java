import java.util.List;

public interface Node {
    //添加节点
    Node add(Node node);

    //获取子节点
    List<Node> children();

    //输出为Xml
    String toXml();
}
