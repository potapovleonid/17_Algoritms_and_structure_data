package geekbrains.home.des.backpackTask;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class CarryingCapacity {

    private Entity[] entities;
    private Entity[] tmpEntities;
    private int tmpCapacity;
    private int valueEntyties;
    private Backpack backpack;

    private Entity[] topCapacity;

    public CarryingCapacity(Entity[] entities, Backpack backpack) {
        this.entities = entities;
        this.backpack = backpack;
        valueEntyties = entities.length;
        this.topCapacity = new Entity[valueEntyties];
    }

    public Entity[] getTopCapacity() {
        topCapacity = new Entity[valueEntyties];
        findCapacity(valueEntyties);
        return topCapacity;
    }

    private void findCapacity(int valueEntyties) {
        if (valueEntyties == 1 && entities[0].getWeigth() <= backpack.getCapacity()) {
            topCapacity[0] = entities[0];
        }
//складирование и поск выгодного
        for (int i = 0; i < valueEntyties; i++) {
            findCapacity(valueEntyties - 1);
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
