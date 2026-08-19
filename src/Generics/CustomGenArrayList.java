package Generics;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomGenArrayList<T> {
    private Object[] data;
    private int size = 0;
    private  static int DEFAULT_SIZE = 10;

    public CustomGenArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }
    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }
    private boolean isFull(){
        return data.length==size;
    }
    private void resize(){
        Object[] temp = new Object[data.length*2];
        for (int i = 0; i< data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }
    public T remove(){
        T removed = (T)data[--size];
        return removed;
    }
    public T get(int index){
        return (T) data[index];
    }
    public  int size(){
        return size;
    }
    public void set(int index, T value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        //ArrayList list = new ArrayList();
//        CustomGenArrayList list = new CustomGenArrayList();
//        list.add(5);
//        list.add(3);
//        list.add(9);
//        for(int i = 0; i<14; i++){
//            list.add(i);
//        }
//        System.out.println(list);
//
//        ArrayList lt = new ArrayList<>();
//        lt.add(33.3);
//        lt.add("Ishan");
//        System.out.println(lt);
        //  Type Erasure
        //Generics were introduced to the Java language to provide tighter type checks at compile time and to support generic programming. To implement generics, the Java compiler applies type erasure to:
        //Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded. The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.
        //Insert type casts if necessary to preserve type safety.
        //Generate bridge methods to preserve polymorphism in extended generic types.
        //Type erasure ensures that no new classes are created for parameterized types; consequently, generics incur no runtime overhead.

        CustomGenArrayList<Integer> list = new CustomGenArrayList<>();
//        list.add("Ishan");
        for (int i = 0; i < 14; i++){
            list.add(2*i);
        }
        System.out.println(list);
    }
}
