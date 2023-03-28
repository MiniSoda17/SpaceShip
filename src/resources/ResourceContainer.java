package resources;

import exceptions.InsufficientCapacityException;

public class ResourceContainer {
    static final int MAXIMUM_CAPACITY = 10;
    public ResourceType type;
    public int amount;

    public ResourceContainer(ResourceType type, int amount) throws InsufficientCapacityException {
        if (amount > this.MAXIMUM_CAPACITY){
            throw new InsufficientCapacityException();
        } else{
            this.amount = amount;
        }
        this.type = type;
    }

    public ResourceContainer(int amount) {
        this.amount = amount;
    }

    public boolean canStore(ResourceType type){
        if (type == ResourceType.FUEL){
            return false;
        } else {
            return true;
        }
    }

    public int getAmount(){
        /**
         * Returns the given amount
         * @returns the amount within this resource container
         *
         */
        return this.amount;
    }

    public ResourceType getType(){
        return this.type;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public String toString(){
        String info = this.getShortName() + ": " + this.getAmount();
        return info;
    }

    public String getShortName(){
        String info = this.type + "";
        return info;
    }
}
