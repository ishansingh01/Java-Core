public class swapping {
    public static void swap(int a , int b){
        int temp = a;
        a = b;
        b = temp;
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        final int num = 10;
        System.out.println(num);
        swap(a,b);
        System.out.println(a+" "+b);

    }
}