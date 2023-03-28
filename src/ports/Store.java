package ports;

import exceptions.InsufficientCapacityException;
import exceptions.InsufficientResourcesException;
import ports.Position;
import ports.SpacePort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import resources.FuelContainer;
import resources.FuelGrade;
import resources.ResourceContainer;
import resources.ResourceType;
import ship.CargoHold;
import ship.RoomTier;



public class Store extends SpacePort {
    public FuelContainer fuel = new FuelContainer(FuelGrade.TRITIUM, 400);
    public FuelContainer fuel2 = new FuelContainer(FuelGrade.TRITIUM, 500);
    public FuelContainer fuel3 = new FuelContainer(FuelGrade.HYPERDRIVE_CORE, 300);

    public static ResourceContainer container;

    static {
        try {
            container = new ResourceContainer(ResourceType.REPAIR_KIT, 5);
        } catch (InsufficientCapacityException e) {
            System.out.println("There is not enough capacity!!");;
        }
    }

    public static ResourceContainer container2;

    static {
        try {
            container2 = new ResourceContainer(ResourceType.REPAIR_KIT, 10);
        } catch (InsufficientCapacityException e) {
            System.out.println("There is not enough capacity!!");;
        }
    }

    public CargoHold cargo;

    public Store(String name, Position position) throws InsufficientCapacityException{
        super(name, position);
        cargo = new CargoHold(RoomTier.AVERAGE);
        cargo.storeResource(container);
        cargo.storeResource(container2);
        cargo.storeResource(fuel2);
        cargo.storeResource(fuel3);

    }

    public ResourceContainer purchase(String item, int amount) throws InsufficientResourcesException, InsufficientCapacityException {
        FuelGrade grade;
        ResourceType type;
        if (FuelGrade.TRITIUM.name() == item){
            grade = FuelGrade.TRITIUM;
            cargo.consumeResource(grade, amount);
            return new FuelContainer(grade, amount);

        } else if(FuelGrade.HYPERDRIVE_CORE.name() == item){
            grade = FuelGrade.HYPERDRIVE_CORE;
            cargo.consumeResource(grade, amount);
            return new FuelContainer(grade, amount);

        // Check down here pls cause the method should not include a InsufficientCapacityException.
        } else if(ResourceType.REPAIR_KIT.name() == item){
            type = ResourceType.REPAIR_KIT;
            cargo.consumeResource(type, amount);
            return new ResourceContainer(type, amount);

        } else {
            System.out.println("The specified resource does not exist.");
        }
        return new ResourceContainer(null, 0);
    }

//    public List<String> getActions(){
//        HashMap<Integer, Object> totalsList = new HashMap();
//        int tritiumTotal = cargo.getTotalAmountByType(FuelGrade.TRITIUM);
//        int hyperDriveTotal = cargo.getTotalAmountByType(FuelGrade.HYPERDRIVE_CORE);
//        int repairKitTotal = cargo.getTotalAmountByType(ResourceType.REPAIR_KIT);
//        totalsList.add(tritiumTotal);
//        totalsList.add(hyperDriveTotal);
//        totalsList.add(repairKitTotal);
//        String actions = "";
//        for (int total: totalsList) {
//            if (total != 0) {
//                actions += String.format("buy %s 1..%s", total);
//            }
//        }
//
//        return cargo.getActions();
//    }
}
