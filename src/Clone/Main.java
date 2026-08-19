package Clone;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human kunal = new Human("Kunal", 23);
//        Human rahul = new Human(kunal);
        Human rahul = (Human) kunal.clone();
        System.out.println(rahul.age+" "+rahul.name);
    }
}
