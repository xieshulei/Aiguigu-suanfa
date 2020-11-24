package hashtable;

import java.util.Scanner;

public class HashTable {
    public static void main(String[] args) {

        HashTab hashTab = new HashTab(7);

        String key = "";

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add");
            System.out.println("list");
            System.out.println("exit");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "delete":
                    System.out.println("请输入id");
                    id = scanner.nextInt();
                    hashTab.deleteById(id);
                case "exit":
                    scanner.close();
                    System.exit(0);
                case "find":
                    System.out.println("请输入要查的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);

                default:
                    break;
            }

        }


    }
}
// 创建hashtable
class HashTab{
    private final int size;
    private EmplLinkedList[] emplLinkedListArray;

    // 构造器
    public HashTab(int size){
        // 初始化
        this.size = size;
        emplLinkedListArray = new EmplLinkedList[size];
        // ? 不要忘记了分别初始化每一个链表
         for (int i = 0;i<size;i++){
             emplLinkedListArray[i] = new EmplLinkedList();
         }
    }
    public void add(Emp emp){
        // 根据员工的id得到该员工所在的链表
        int empLinkedListNo = hashFun(emp.id);
        emplLinkedListArray[empLinkedListNo].add(emp);
    }
    // 遍历所有的列表
    public void list(){
        for (int i = 0;i < size;i++){
            emplLinkedListArray[i].list();
        }
    }

    // 编写一个散列函数 使用取模法来处理
    public int hashFun(int id){
        return id % size;
    }

    public void findEmpById(int id){

        // 确定到哪条查找
        int empLinkedListNo = hashFun(id);
        Emp emp = emplLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null){
            System.out.println("找到了");
        }else {
            System.out.println("没有找到");
        }


    }

    public void deleteById(int id){
        int empLinkedList = hashFun(id);
        emplLinkedListArray[empLinkedList].deleteById(id);
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next; // 默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmplLinkedList{
    // 头指针 因此这个链表的head是有效的 直接指向第一个雇员
    private Emp head;

    // 添加雇员到链表 假定添加到链表的最后，id是自增长的
    // 因此我们将该雇员直接加入到本链表的最后一个就可以
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }else {
                curEmp = curEmp.next;
            }
        }
        curEmp.next = emp;
    }

    public void list(){
        if (head == null){
            System.out.println("cnm空的");
            return;
        }
        System.out.println("当前链表的信息为");
        Emp curEmp = head;
        while (true){
            System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();

    }

    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("cnm空的啊++++++");
            return null;
        }
        // 辅助指针
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                System.out.println("cnm没找到啊");
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    public void deleteById(int id){
        if (head == null){
            System.out.println("cnm空的啊");
            return;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                curEmp = null;
                System.out.println("___________________");
                return;
            }

            if (curEmp.next.id == id){
                if (curEmp.next.next == null){
                    curEmp.next = null;
                    System.out.println("shanchu");
                    break;
                }
                curEmp.next = curEmp.next.next;
                System.out.println("成功删除");
                break;
            }
            if (curEmp.next == null){
                System.out.println("cnm没找到");
                break;
            }
            curEmp = curEmp.next;
        }
    }
}

