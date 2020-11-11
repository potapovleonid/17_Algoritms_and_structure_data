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
        topCapacity.clear();
        findCapacity(valueEntyties);
        return topCapacity;
    }

    private void findCapacity(int ents) {
        if (valueEntyties == 1 && entities[0].getWeigth() <= backpack.getCapacity()) {
            topCapacity.add(entities[0]);
            return;
        }
        if (ents == 1){
            return;
        }
        for (int i = 0; i < ents; i++) {
            findCapacity(ents - 1);
            check();

            swap(ents);

            check();
        }
    }

    private void swap(int values) {
        int pos = entities.length - values;
        Entity tmp = entities[pos];
        for (int i = pos + 1; i < entities.length; i++) {
            entities[i - 1] = entities[i];
        }
        entities[entities.length - 1] = tmp;
        for (int i = 0; i < valueEntyties; i++) {
            System.out.print(entities[i].toString() + " || " );
        }
    }

    private void check(){
        for (int j = 0; j < valueEntyties; j++) {
            if (entities[j].getWeigth() <= backpack.getFreeCapacity()){
                backpack.addEntityInBackpack(entities[j]);
                System.out.println(backpack.getFreeCapacity());
            }
        }

        if (tmpCoast < backpack.getTotalCoast()){
            topCapacity.clear();
            tmpCoast = backpack.getTotalCoast();
            topCapacity = (ArrayList<Entity>) backpack.getEntities().clone();
        }

        backpack.clearContent();
    }
}
