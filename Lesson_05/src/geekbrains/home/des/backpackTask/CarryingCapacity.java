package geekbrains.home.des.backpackTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class CarryingCapacity {

    private Entity[] entities;
    private int tmpCoast;
    private int valueEntyties;
    private Backpack backpack;

    private ArrayList<Entity> topCapacity;

    public CarryingCapacity(Entity[] entities, Backpack backpack) {
        this.entities = entities;
        this.backpack = backpack;
        valueEntyties = entities.length;
        this.topCapacity = new ArrayList<>();
    }

    public ArrayList<Entity> getTopCapacity() {
        backpack.clearContent();
        findCapacity(valueEntyties);
        return topCapacity;
    }

    private void findCapacity(int valueEntyties) {
        if (valueEntyties == 1 && entities[0].getWeigth() <= backpack.getCapacity()) {
            topCapacity.add(entities[0]);
        }
        for (int i = 0; i < valueEntyties; i++) {
            findCapacity(valueEntyties - 1);
            for (int j = 0; j < valueEntyties; j++) {
                if (entities[j].getWeigth() <= backpack.getFreeCapacity()){
                    backpack.addEntityInBackpack(entities[j]);
                }
            }

            if (tmpCoast < backpack.getTotalCoast()){
                tmpCoast = backpack.getTotalCoast();
                topCapacity = (ArrayList<Entity>) backpack.getEntities().clone();
            }

            backpack.clearContent();

            swap(valueEntyties);
        }
    }

    private void swap(int valueEntyties) {
        int pos = entities.length - valueEntyties;
        Entity tmp = entities[pos];
        for (int i = pos + 1; i < entities.length; i++) {
            entities[i - 1] = entities[i];
        }
        entities[entities.length - 1] = tmp;
    }
}
