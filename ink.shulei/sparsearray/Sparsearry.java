package ink.shulei.sparsearray;

public class Sparsearry {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11*11
        // 0 表示没有棋子 1表示黑子 2表示蓝子
        int chessArryp[][] = new int[11][11];
        chessArryp[1][2] = 1;
        chessArryp[2][4] = 2;
        for (int[] row:chessArryp){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        // 遍历二维数组 得到非零数据的个数
        int sum = 0;
        for (int i = 0; i<11;i++){
            for (int j = 0;j<11;j++){
                if(chessArryp[i][j] != 0){
                    sum++;
                }
            }
        }



        int sparseArray [][] = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;


        int count = 0;
        for (int i = 0; i<11;i++){
            for (int j = 0;j<11;j++){
                if(chessArryp[i][j] != 0){

                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArryp[i][j];

                }
            }
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        for (int i = 0;i<sparseArray.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();


        System.out.println("-----------------------------------------------");



        int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1;i<sparseArray.length;i++){
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for (int[] row:chessArr2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }





    }
}
