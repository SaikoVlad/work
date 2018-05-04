package by.bntu.fitr.prostrmk;

import java.util.*;

public class Graph {

    private final int VERTEX_MAX = 100;
    private Vertex[] vertexList;
    private int vertexCount;
    private Queue<Integer> queue;
    private int[][] matrix;

    public Graph() {
        matrix = new int[VERTEX_MAX][VERTEX_MAX];
        //перед началом работы заполняем матрицу смежности нулями
        for (int i = 0; i < VERTEX_MAX; i++)
            for (int j = 0; j < VERTEX_MAX; j++)
                matrix[i][j] = 0;
        vertexCount = 0;
        vertexList = new Vertex[VERTEX_MAX];
    }

    public Graph(int...params){
        new Graph();
        for (int param : params) {
//            addVertex(param);
        }
    }


    public void addVertex(String label) {
        vertexList[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int begin, int end) {
        matrix[begin][end] = 1;
        matrix[end][begin] = 0;
    }

    public void detourWidth(int v) {
        vertexList[v].setVisited(true);
        queue.add(v);
        int vertex;

        //выведем вершину, с которой начинается обход, на экран
        System.out.println(vertexList[v].getLabel());

        while (!queue.isEmpty())//пока очередь не опустеет
        {
            int current = queue.poll();
            while ((vertex = getSuccessor(current)) != -1) {
                vertexList[vertex].setVisited(true);
                queue.add(vertex);
                //вывод вершины на экран
                System.out.println(vertexList[vertex].getLabel());
            }

        }
        //сброс флагов
        for (int j = 0; j < vertexCount; j++)
            vertexList[j].setVisited(false);
    }
    public void detourDeep(int v){
        Stack<Integer> stack = new Stack<>();
        vertexList[v].setVisited(true);//алгоритм начинает обход с вершины 0
        stack.push(0);//занесение в стек
        int i = 0;
        //выведем вершину, с которой начинается обход, на экран
        System.out.println(vertexList[v].getLabel());


        while(!stack.isEmpty()) //пока стек не опустеет
        {
            int current = stack.peek();
            //получение непосещенной вершины, смежной с текущей
            int vertex = getSuccessor (current);
            if(vertex == -1)
                stack.pop();//элемент извлекается из стека
            else //если вершина найдена
            {
                vertexList[vertex].setVisited(true);//пометка
//                displayVertex(vertex);//вывод
                System.out.println(vertex);
                stack.push(vertex);//занесение в стек
            }
        }

//сброс флагов
        for(int j = 0; j < vertexCount; j++)//сброс флагов
            vertexList[j].setVisited(false);

    }

    private int getSuccessor(int v) {
        for (int j = 0; j < vertexCount; j++)
            if (matrix[v][j] == 1 && !vertexList[j].isVisited())
                return j;
        return -1;
    }


}
