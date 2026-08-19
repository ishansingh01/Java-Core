package Clone;

public class Human implements Cloneable{
    int age;
    String name;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
//    public Human(Human human){
//        this.age = human.age;
//        this.name = human.name;
//    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
