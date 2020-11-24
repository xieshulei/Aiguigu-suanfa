package josepful;

public class Josepful {

    public static void main(String[] args) {

        CircleSingleLinkedList c = new CircleSingleLinkedList();
        c.addBoy(25);
        c.showBoy();
        c.countBoy(1,2,25);

    }


}

class CircleSingleLinkedList{
    private Boy first = null;

    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("nums应该大于1");
            return;
        }
        Boy cur = null;
        for (int i = 1;i <= nums;i++){
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                cur = first;
            }else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }

    }

    public void showBoy(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Boy cur = first;
        while (true){
            System.out.printf("小孩的编号%d\n",cur.getNo());
            if (cur.getNext() == first){
                System.out.println("遍历完毕");
                break;
            }
            cur = cur.getNext();
        }
    }

    public void countBoy(int startNo,int countNo,int nums){
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("不太行啊宝贝");
            return;
        }
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
            for (int j = 0;j < startNo - 1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            while (true){
                if (helper == first){
                    System.out.println("循环完成");
                    break;
                }
                for (int j = 0;j < countNo - 1;j++){
                    first = first.getNext();
                    helper = helper.getNext();
                }
                System.out.printf("小孩%d出圈\n",first.getNo());
                first = first.getNext();
                helper.setNext(first);
            }
        System.out.printf("最后留下的小孩是%d\n",helper.getNo());

    }


}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no, Boy next) {
        this.no = no;
        this.next = next;
    }

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy() {
    }
}
