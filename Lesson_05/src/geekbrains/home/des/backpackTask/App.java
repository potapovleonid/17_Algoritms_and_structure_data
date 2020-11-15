package geekbrains.home.des.backpackTask;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Backpack backpack = new Backpack(20);
        Entity[] entities = {
                new Entity(2, 35),
                new Entity(7, 15),
                new Entity(4, 25),
                new Entity(6, 40),
                new Entity(12, 150),
                new Entity(5, 80),
        };
        CarryingCapacity carryingCapacity = new CarryingCapacity(entities, backpack);
        ArrayList<Entity> enti = carryingCapacity.getTopCapacity();
        int totalCoast = 0;
        for (Entity e: enti) {
            System.out.println(e.toString());
            totalCoast += e.getCost();
        }
        System.out.println("total cost: " + totalCoast);
    }
}
