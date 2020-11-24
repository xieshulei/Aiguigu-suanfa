package linkdlist;

public class SingleLinkedList {

    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(5,"shulei","sl");
        HeroNode hero2 = new HeroNode(2,"eating","sl");
        HeroNode hero3 = new HeroNode(3,"shayun","sl");



        SingleLinked singleLinked = new SingleLinked();
//        singleLinked.add(hero1);
//        singleLinked.add(hero2);
//        singleLinked.add(hero3);
        System.out.println(hero1);
        System.out.println(hero2);
        System.out.println(hero3);
        singleLinked.addByOrder(hero1);
        singleLinked.addByOrder(hero2);
        singleLinked.addByOrder(hero3);
        singleLinked.showList();
        System.out.println(hero1.next);
        System.out.println(hero2.next);
        System.out.println(hero3.next);

    }

    // 定义一个单链表来管理英雄
    static class SingleLinked {
        // 初始化头节点,头节点不要动,不存放具体数据
        private HeroNode head = new HeroNode(0,"","");

        // 添加节点到单向链表
        public void add(HeroNode heroNode){
            HeroNode temp = head;
            while (true){
                // 找到链表最后
                if (temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            // 退出循环时，temp指向链表的最后
            temp.next = heroNode;
        }

        public void addByOrder(HeroNode heroNode){
            // 因为头节点不可移动 所以通过辅助指针来找到添加的位置
            // temp为添加位置的前一个结点
            HeroNode temp = head;
            boolean flag = false; // 添加的编号是否存在
            while (true){
                if (temp.next == null){
                    break;
                }
                if (temp.next.no > heroNode.no){
                    break;
                }else if (temp.next.no == heroNode.no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag == true){
                System.out.println("已经有啦~~~~不能添加");
            }else {
                heroNode.next = temp.next;
                temp.next = heroNode;
            }

        }

        public void showList(){
            // 判断链表是否为空
            if (head.next == null){
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head.next;
            while (true){
                if (temp == null){
                    break;
                }
                // 输出节点信息
                System.out.println(temp);
                temp = temp.next;
            }
        }

    }

    static class HeroNode {
        public int no;
        public String name;
        public String nickName;
        public HeroNode next;

        public HeroNode(int hNo,String hName,String hNickname){
            this.no = hNo;
            this.name = hName;
            this.nickName = hNickname;

        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
    }

