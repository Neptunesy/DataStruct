package com.itsun.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    /**
     * 存储顶点集合
     */
    private ArrayList<String> vertexList;
    /**
     * 存储对应的邻接矩阵
     */
    private int[][] edges;
    /**
     * 表示边的数目
     */
    private int numOfEdge;

    /**
     * 创建对应的图
     *
     * @param n 定义N维的数组
     */
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdge = 0;
    }

    //图中常用的方法
    public int getVertex() {
        return vertexList.size();
    }

    public int getNumOfEdge() {
        return numOfEdge;
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeiget(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * @param v1     表示点的下标 即是第几个顶点
     * @param v2     第二个顶点对应的下标
     * @param weight 表示值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdge++;
    }


    public static void main(String[] args) {
        //节点的个数！
        int n = 5;
        String[] vertexValue = {"a", "b", "c", "d", "e"};
        Graph graph = new Graph(n);
        for (int i = 0; i < vertexValue.length; i++) {
            graph.insertVertex(vertexValue[i]);
        }
        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();
    }
}
