package prim;

import java.util.Arrays;

public class Prim {
    public static void main(String[] args) {
        // 测试图是否创建成
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };
        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
        minTree.showGraph(mGraph);
        minTree.prim(mGraph,0);
    }
}

class MinTree{
    // 创建图的邻接矩阵
    public void createGraph(MGraph graph,int verxs,char data[],int[][] weight){
        for (int i = 0;i<verxs;i++){
            graph.data[i] = data[i];
            for (int j = 0;j<verxs;j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph){
        for (int[] link: graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    // 编写prim算法，得到最小生成树
    // v表示从图的第几个顶点开始生成
    public void prim(MGraph graph,int v){
        // 标记节点是否被访问过
        int visited[] = new int[graph.verxs];
//        默认都是0
        for (int i = 0;i<graph.verxs;i++){
            visited[i] = 0;
        }

        // 把当前节点标记为以访问
        visited[v] = 1;
        // h1与2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int miniWeight = 10000;
        // 会有节点-1条边
        for (int k = 1;k< graph.verxs;k++){
            for (int i = 0;i<graph.verxs;i++){
                for (int j = 0;j<graph.verxs;j++){
                    if (visited[i]==1 && visited[j]==0 && graph.weight[i][j]<miniWeight){
                        miniWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2]+">边");
            visited[h2] = 1;

            miniWeight = 10000;
        }

    }
}

class MGraph{
    int verxs;
    char[] data;
    int[][] weight;

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
