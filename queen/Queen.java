package queen;

public class Queen {


    // 定义一个max表示共有多少皇后
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
        System.out.println(count);
    }

    private void check(int n){
        if (n == max){
            print();
            return;
        }
        // 依次放入皇后 并判断是否冲突
        for (int i=0;i<max;i++){
            // 先把当前皇后 n 放到该行的第1列
            array[n] = i;
            if (judge(n)){
                check(n + 1);
            }
        }
    }

    // 将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i = 0;i < array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    private boolean judge(int n){
        for (int i=0;i<n;i++){
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

}
