package resources;

import exceptions.InsufficientCapacityException;

public class FuelContainer extends ResourceContainer{
    static final int MAXIMUM_CAPACITY = 1000;
    public FuelGrade grade;

    public FuelContainer (FuelGrade grade, int amount) {
        super(amount);
        this.grade = grade;
    }

     public FuelGrade getFuelGrade(){
         return this.grade;
     }

     public boolean canStore(ResourceType type){
         if (type == ResourceType.FUEL){
             return true;
         } else {
             return false;
         }
     }

     public String toString(){
         String info = "FUEL: " + this.getAmount() + " - " + this.getShortName();
         return info;
     }

     public String getShortName(){
         String shortName = this.getFuelGrade() + "";
         return shortName;
     }
}
