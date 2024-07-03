package singleton;

//使用enum实现单例，因为每个枚举都是单例
//使用enum实现单例，还避免了序列化和反序列化会绕过普通类的构造方法，从而创建出多个实例的问题；
public enum World {
    INSTANCE;

    private String name = "world";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
