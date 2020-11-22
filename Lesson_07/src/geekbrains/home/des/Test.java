package geekbrains.home.des;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва","Тула");
        graph.addEdges("Москва","Калуга");
        graph.addEdges("Москва","Рязань");
        graph.addEdges("Тула","Липецк");
        graph.addEdges("Рязань","Тамбов");
        graph.addEdges("Калуга","Орел");
        graph.addEdges("Липецк","Воронеж");
        graph.addEdges("Тамбов","Саратов");
        graph.addEdges("Орел","Курск");
        graph.addEdges("Саратов","Воронеж");
        graph.addEdges("Курск","Воронеж");

        System.out.println("Size of graph is " + graph.getVertexSize());
//        graph.display();
//        graph.bfs("Москва");
//        graph.bfs("Москва");
        Stack<String> path = graph.findShortDestination("Москва", "Воронеж");
        displayShortPath(path);
    }

    private static void displayShortPath(Stack<String> path) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        while ( !path.isEmpty() ) {
            if (!isFirst) {
                sb.append(" → ");
            }
            isFirst = false;
            sb.append(path.pop());
        }

        System.out.println(sb);
    }
}
