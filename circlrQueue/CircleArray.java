package circlrQueue;

import java.util.Scanner;

public class CircleArray {

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("show：显示队列");
            System.out.println("exit：退出");
            System.out.println("add：加");
            System.out.println("get：取");
            System.out.println("head：队列头");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数据");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出");
                    break;
                default:
                    break;
            }

        }

    }
}

class ArrayQueue {
    private int maxSize; //最大容量
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满了 不可以加数据");
            return;
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }
    public int getQueue(){
        if (isEmpty()){
            System.out.println("队列是空的 不可以取");
            throw new RuntimeException(" 队列空，不可以取数据");
        }
        int value =  arr[front];
        front = (front + 1)%maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("没数据");
            return;
        }
        for (int i = front;i < front+((rear+maxSize-front)%maxSize);i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            System.out.println("kong");
            throw new RuntimeException("空的呀宝贝");
        }
        return arr[front];
    }
}
