package Generics;

import java.util.Arrays;
import java.util.List;

//Here T should be either Number or its subclasses
public class WildCardExample<T extends Number> {
    private Object[] data;
    private int size = 0;
    private  static int DEFAULT_SIZE = 10;

    public  WildCardExample() {
        this.data = new Object[DEFAULT_SIZE];
    }
    public void getList(List<? extends Number> list){
//        here you can pass only number List<Number>
//        here you can pass number and its subclasses List<? extends Number>
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

    }
}
