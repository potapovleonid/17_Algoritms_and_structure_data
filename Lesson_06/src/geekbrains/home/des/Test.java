package geekbrains.home.des;

public class Test {

    public static void main(String[] args) {
        TreeImpl<Integer> tree = new TreeImpl<>();

        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(3);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.display();
    }
}
