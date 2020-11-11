package geekbrains.home.des.backpackTask;

import java.util.ArrayList;

public class Backpack {
    private int capacity;
    private int freeCapacity;
    private ArrayList<Entity> entities;
    private int totalCoast;

    public Backpack(int capacity) {
        this.capacity = capacity;
        this.freeCapacity = capacity;
        this.entities = new ArrayList<>();
    }

    public void addEntityInBackpack(Entity entity){
        totalCoast += entity.getCost();
        freeCapacity -= entity.getWeigth();
        entities.add(entity);
    }

    public void clearContent(){
        entities.clear();
        totalCoast = 0;
        freeCapacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFreeCapacity() {
        return freeCapacity;
    }

    public int getTotalCoast() {
        return totalCoast;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setFreeCapacity(int freeCapacity) {
        this.freeCapacity = freeCapacity;
    }
}
