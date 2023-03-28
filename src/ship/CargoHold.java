package ship;


import exceptions.InsufficientCapacityException;
import exceptions.InsufficientResourcesException;
import resources.FuelContainer;
import resources.FuelGrade;
import resources.ResourceContainer;
import resources.ResourceType;

import java.util.ArrayList;
import java.util.List;

public class CargoHold extends Room{
    public int MaximumCapacity;
    public int RemainingCapacity;

    public List<ResourceContainer> containerHolder = new ArrayList<>();


    public CargoHold(RoomTier roomTier){
        super(roomTier);
        if (this.tier == RoomTier.BASIC){
            MaximumCapacity = 5;
        } else if (this.tier == RoomTier.AVERAGE){
            MaximumCapacity = 10;
        } else {
            MaximumCapacity = 15;
        }
    }
    public int getMaximumCapacity(){
        return this.MaximumCapacity;
    }
    public int getRemainingCapacity(){
        int remaining;
        remaining = this.getMaximumCapacity() - this.getResources().size();
        return remaining;
    }

    public void storeResource(ResourceContainer resource) throws InsufficientCapacityException {
        if (this.getRemainingCapacity() <= 0){
            throw new InsufficientCapacityException();
        } else {
            this.containerHolder.add(resource);
        }
    }

    public List<ResourceContainer> getResources(){
        return containerHolder;
    }

    public List<ResourceContainer> getResourceByType(FuelGrade grade){
        /**
         * Returns a list of Containers with only the specific fuelgrade
         * @param grade The specific fuel grade
         * @return A list of all the resource containers with the specific
         * fuel grade requested.
         */
        List<ResourceContainer> fuelHolder = new ArrayList<>();

        for (ResourceContainer resource: this.getResources()){
            if (resource.canStore(ResourceType.FUEL)){
                FuelContainer fuel = (FuelContainer) resource;
                if (fuel.getFuelGrade() == grade){
                    ResourceContainer fuelResource = (ResourceContainer) fuel;
                    fuelHolder.add(fuelResource);
                }
            }
        }
        return fuelHolder;
    }

    public List<ResourceContainer> getResourceByType(ResourceType type){
        /**
         *
         */
        List<ResourceContainer> resourceTypeList = new ArrayList<>();
        for (ResourceContainer resource: this.getResources()){
            if (resource.getType() == type){
                resourceTypeList.add(resource);
            }
        }
        return resourceTypeList;
    }
    public int getTotalAmountByType(FuelGrade grade){
        int total = 0;
        for (ResourceContainer container: this.getResourceByType(grade)){
            total += container.getAmount();
        }
        return total;
    }

    public int getTotalAmountByType(ResourceType type){
        int total = 0;
        for (ResourceContainer container: this.getResourceByType(type))
            total += container.getAmount();
        return total;
    }

    public void consumeResource(FuelGrade grade, int amount) throws InsufficientResourcesException {
        if (this.getResourceByType(grade).isEmpty() || amount > this.getTotalAmountByType(grade)){
            throw new InsufficientResourcesException();
        }
        // Removes a resource
        for (ResourceContainer container: this.getResourceByType(grade)){
            int original = container.getAmount();
            container.amount -= amount;
            amount -= original;
            if (container.amount <= 0) {
                this.containerHolder.remove(container);
            } else {
                break;
            }
        }
    }

    public void consumeResource(ResourceType type, int amount) throws InsufficientResourcesException, IllegalArgumentException {
        if (type.equals(ResourceType.FUEL)) {
            throw new IllegalArgumentException();
        }
        if (this.getResourceByType(type).isEmpty() || amount > this.getTotalAmountByType(type)){
            throw new InsufficientResourcesException();
        }

        for (ResourceContainer container: this.getResourceByType(type)){
            int original = container.getAmount();
            container.amount -= amount;
            amount -= original;
            if (container.amount <= 0) {
                this.containerHolder.remove(container);
            } else {
                break;
            }
        }
    }

    public List<String> getActions(){
        List<String> actions = new ArrayList<>();
        String infoActions = String.format("repair %s[COST: 1 REPAIR_KIT", this.getClass().getSimpleName());
        if (this.getResourceByType(ResourceType.REPAIR_KIT).isEmpty() != true){
            actions.add(infoActions);
        }
        return actions;
    }

    public String toString(){
        String info = String.format("ROOM: %s(%s)health: %s%%, needs repair: %s, capacity: %s, items: %s",
                                                                                             this.getClass().getSimpleName(),
                                                                                             this.getTier(),
                                                                                             this.getHealth(),
                                                                                             this.needsRepair(),
                                                                                             this.getMaximumCapacity(),
                                                                                             this.getResources().size());
        for (ResourceContainer container: this.getResources()){
            info += String.format("\n    %s", container);
        }
        return info;
    }
 }
