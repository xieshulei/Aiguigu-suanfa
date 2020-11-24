package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    String VertexValue[] = {"A","B","C","D","E"};
    //定义一个数组 记录节点是否被访问过
    private boolean[] isVisited = new boolean[5];
    public static void main(String[] args) {
        int n = 5;
        String VertexValue[] = {"A","B","C","D","E"};
        Graph graph = new Graph(5);
        for (int i = 0;i<VertexValue.length;i++){
            graph.insertVertex(VertexValue[i]);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.showGraph();
//        graph.dfs();
        graph.bfs();
    }

    public void bfs(){
        for (int i = 0;i< VertexValue.length;i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    // 对一个节点广度优先的算法
    private void bfs(boolean[] isVisited,int i){
        int u;  // 队列的头节点对应的下标
        int w;  // 邻接节点的w
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "-->");
        isVisited[i] = true;
        // 将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()){
            // 取出队列的头节点下标
            u = (Integer)queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "-->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                // 以u为前驱点，找w后面的下一个邻接点
                w = getNextNeighbor(u,w);// 体现出广度优先
            }
        }

    }
    public String getValueByIndex(int i){
        return VertexValue[i];
    }

    // 深度优先算法
    private void dfs(boolean[] isVisited,int i){
        // 首先访问该节点，输出
        System.out.print(getValueByIndex(i) + "-->");
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            // 如果w节点已经被访问过，查找临界节点的下一个节点
            w = getNextNeighbor(i,w);
        }
    }

    public void dfs(){
        // 遍历所有的节点进行dfs
        for (int i = 0;i< VertexValue.length;i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    // 得到第一个临街节点的下标  存在返回对应的下表  否则返回-1
    public int getFirstNeighbor(int index){
        for (int j = 0;j<vertexList.size();j++){
            if (edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }
    public int getNextNeighbor(int v1,int v2){
        for (int j = v2+1;j<vertexList.size();j++){
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    // 构造器
    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }
    // 插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    // 插入边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getWeight(int a,int b){
        return edges[a][b];
    }

    // 显示图对应的矩阵
    public void showGraph(){
        for (int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }
}


