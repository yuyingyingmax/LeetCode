package simple;

import java.util.LinkedList;

public class MinStack {
    private LinkedList<Integer> list ;
    private int[] minNum;
    private int index;
    public MinStack(){
        this.list = new LinkedList<>();
        this.minNum = new int[30000];
        this.index = 0;
    }

    public void push(int x){
       if(minNum[index]==0){
           minNum[index]=x;
       }
       if((index-1)>=0){
           if(minNum[index]>minNum[index-1]){
               minNum[index]=minNum[index-1];
           }
       }
        index++;
        list.addFirst(x);
        System.out.println("push:"+x);
    }

    public void pop(){
        list.removeFirst();
        minNum[index-1]=0;
        index--;
        System.out.println("pop,"+list.size()+" in list");
    }

    public int top(){
        System.out.println("the top is:"+list.getFirst());
        return list.getFirst();
    }

    public int getMin(){
        System.out.println("min number is :"+minNum[index-1]);
        return minNum[index-1];
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(2147483646);
        ms.push(2147483646);
        ms.push(2147483647);
        ms.top();
        ms.pop();
        ms.getMin();
        ms.pop();
        ms.getMin();
        ms.pop();
        ms.push(2147483647);
        ms.top();
        ms.getMin();
        ms.push(-2147483648);
        ms.top();
        ms.getMin();
        ms.pop();
        ms.getMin();
    }
}
