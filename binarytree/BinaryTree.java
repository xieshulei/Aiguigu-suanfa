package binarytree;

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTreeEntity binaryTreeEntity = new BinaryTreeEntity();

        HeroNode root = new HeroNode(1,"xioayun");
        HeroNode n1 = new HeroNode(2,"yin");
        HeroNode n2 = new HeroNode(3,"gang");
        HeroNode n3 = new HeroNode(4,"kou");
        binaryTreeEntity.setRoot(root);

        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);

        root.preOrder();
        HeroNode heroNode = binaryTreeEntity.preSearch(4);
        System.out.println(heroNode);
    }
}

// 定义一个二叉树
class BinaryTreeEntity{
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("null");
            return;
        }
    }
    public void midOrder(){
        if (this.root != null){
            this.root.midOrder();
        }else {
            System.out.println("null");
            return;
        }
    }
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("null");
            return;
        }
    }
    public HeroNode preSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }
        return null;
    }
    public HeroNode midSearch(int no){
        if (root != null){
            return root.midHeroNodeSearch(no);
        }
        return null;
    }
    public HeroNode postSearch(int no){
        if (root != null){
            return root.postHeroNodeSearch(no);
        }
        return null;
    }
}


class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    // 编写前序遍历方法 后 中
    public void preOrder(){
        System.out.println(this); // 先输出父节点
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
    public void midOrder(){

        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this); // 先输出父节点
        if (this.right != null){
            this.right.midOrder();
        }
    }
    public void postOrder(){

        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this); // 先输出父节点
    }

    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序遍历");
        HeroNode resNode = null;

        if (this.no == no){
            return this;
        }
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;

//        while (true){
//
//        }
//            if (temp.left == null || temp.right == null){
//                System.out.println("没找到");
//                break;
//            }
//            if (temp.no == no){
//                return temp;
//            }
//            if (temp.left != null){
//                if (temp.left.no == no){
//                    return temp.left;
//                }
//                if (temp.left)
//                temp = temp.left;
//            }
//        }
//        return null;
    }
    public HeroNode midHeroNodeSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.midHeroNodeSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resNode = this.right.midHeroNodeSearch(no);
        }
        return resNode;

    }
    public HeroNode postHeroNodeSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.postHeroNodeSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.postHeroNodeSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.no == no){
            return this;
        }
        return resNode;
    }
}
