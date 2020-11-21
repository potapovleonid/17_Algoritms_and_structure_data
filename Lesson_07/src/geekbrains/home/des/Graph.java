package geekbrains.home.des;

import java.util.*;

public class Graph {

    private final List<Vertex> list;
    private final boolean[][] adjMat;

    public Graph(int maxVertexCount) {
        this.list = new ArrayList<>(4);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        list.add(new Vertex(label));
    }

    public void addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            throw new IllegalArgumentException("invalid label for vertex index");
        }

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;
    }

    public void addEdges(String startLabel, String secondLabel, String... others) {
        addEdge(startLabel, secondLabel);
        for (String o : others) {
            addEdge(startLabel, o);
        }
    }

    private int indexOf(String label) {
        for (int i = 0; i < list.size(); i++) {
            if (label.equals(list.get(i).getLabel())) {
                return i;
            }
        }
        return -1;
    }

    public int getVertexSize() {
        return list.size();
    }

    public void display() {
        for (int i = 0; i < getVertexSize(); i++) {
            System.out.print(list.get(i));
            for (int j = 0; j < getVertexSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + list.get(j));
                }
            }
            System.out.println();
        }
    }

    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = list.get(startIndex);

        visitVertex(vertex, stack);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(vertex, stack);
            }
            else {
                stack.pop();
            }
        }

        resetVertexState();
    }

    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = list.get(startIndex);

        visitVertex(vertex, queue);
        while (!queue.isEmpty()) {

            vertex = getNearUnvisitedVertex(queue.peek());

            if (vertex != null) {
                visitVertex(vertex, queue);
            }
            else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex : list) {
            vertex.setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = list.indexOf(peek);
        for (int i = 0; i < getVertexSize(); i++) {
            if (adjMat[peekIndex][i] && !list.get(i).isVisited()) {
                return list.get(i);
            }
        }
        return null;
    }
    private Vertex getNearUnvisitedVertexForFind(Vertex peek) {
        int peekIndex = list.indexOf(peek);
        for (int i = 0; i < getVertexSize(); i++) {
            if (adjMat[peekIndex][i] && !list.get(i).isVisited()) {
                System.out.println("vertex input " + peek.getLabel());
                System.out.println(list.get(i).getLabel());
                return list.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Vertex vertex, Stack<Vertex> stack) {
        System.out.println(vertex);
        stack.push(vertex);
        vertex.setVisited(true);
    }
    private void visitVertex(Vertex vertex, Queue<Vertex> queue) {
        System.out.println(vertex);
        queue.add(vertex);
        vertex.setVisited(true);
    }

    public Stack<String> findShortDestination(String startPoint, String endPoint){
        int startIndex = indexOf(startPoint);
        int finishIndex = indexOf(endPoint);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startPoint: " + startPoint);
        }
        if (finishIndex == -1) {
            throw new IllegalArgumentException("Invalid endPoint: " + endPoint);
        }

        Queue<Vertex> queue = new ArrayDeque<>();

        Vertex vertex = list.get(startIndex);
        visitVertex(vertex, queue);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex == null) {
                queue.remove();
            } else {
                visitVertex(vertex, queue);
                vertex.setPreviousVertex(queue.peek());
                if (vertex.getLabel().equals(endPoint)) {
                    return buildPath(vertex);
                }
            }
        }

        resetVertexState();
        return null;
    }

    private Stack<String> buildPath(Vertex vertex) {
        Stack<String> stack = new Stack<>();
        Vertex current = vertex;
        while (current != null) {
            stack.push(current.getLabel());
            current = current.getPreviousVertex();
        }

        return stack;
    }
}
