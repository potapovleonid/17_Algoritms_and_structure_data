package geekbrains.home.des;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random random = new Random();

        int treeCount = 20;
        int maxLvl = 4;
        int nodeCount = (int) (Math.pow(2, maxLvl) - 1);

        int maxValue = 25;

        int balanceTree = 0;

        boolean treeBalanceStatus = false;

        for (int i = 0; i < treeCount; i++) {

            Tree<Integer> tree = new TreeImpl<>(maxLvl);
            initTree(random, nodeCount, maxValue, tree);

            if (tree.isBalance()){
                balanceTree++;
                if (!treeBalanceStatus){
                    treeBalanceStatus = true;
                    tree.display();
                }
            }

        }
        System.out.println("Balanced Tree Count = " + ((balanceTree / (treeCount * 1.0)) * 100) + "%");
    }

    private static void initTree(Random random, int nodeCount, int maxValue, Tree<Integer> tree) {
        for (int i = 0; i < nodeCount; i++) {

            tree.add(random.nextInt(maxValue * 2 + 1) - maxValue);

        }
    }
}
