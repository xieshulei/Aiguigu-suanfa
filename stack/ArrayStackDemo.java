package stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(4);
        boolean loop = true;
        String key = " ";
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show ");
            System.out.println("exit ");
            System.out.println("push ");
            System.out.println("pop ");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.show();
                    break;
                case "exit":
                    loop = false;
                    break;
                case "push":
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
//                case "pop":
//                    int res = arrayStack.pop();
//                    System.out.printf("出来的是%d\n",res);
                default:
                    break;

            }
        }

    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(int value){
        if (isFull()){
            System.out.println("man le");
            return;
        }
        top ++;
        stack[top] = value;
    }

    public Integer pop(){
        if (isEmpty()){
            System.out.println("mei you");
            return null;
        }
//        top = top - 1;
//        return stack[top + 1];
        int value = stack[top];
        top--;
        return value;
    }
    public void show(){
        while (true){
            if (isEmpty()){
                break;
            }
            System.out.println(stack[top]);
            top --;

        }
    }
}
