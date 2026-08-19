package Java8;

public class AnonymousVsLambda {
//    Anonymous ek class
//    Lambda functional interface method ki implementation
//    int x = 3;
    private void doSomething(){
        int x = 3;
        Employee employee = ()->{
//            System.out.println(this.x); lambda instance variable ko change kr sakta h local variable jo ki method ke under h unko nhi
            return "100";
        };

        Employee employee1 = new Employee() {
            int x = 3;
            @Override
            public String getSalary() {
//                int x = 3;
                System.out.println(this.x);//ye krega kyuki anonymous ek class h method ke bhr x = 3; instance variable hai
                return "200";
            }
        };
    }


}
