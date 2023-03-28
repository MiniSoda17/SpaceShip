package game;

import exceptions.InsufficientCapacityException;
import exceptions.InsufficientResourcesException;
import ports.Position;
import ports.ShipYard;
import ports.Store;
import resources.FuelContainer;
import resources.FuelGrade;
import resources.ResourceContainer;
import resources.ResourceType;
import ship.CargoHold;
import ship.Room;
import ship.RoomTier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static List<String> rooms = new ArrayList<>(Arrays.asList("Josh", "Honey"));
    public static Position position1 = new Position(5, 3, 2);

    public static  Store store;

    public static void main(String[] args) throws InsufficientCapacityException, InsufficientResourcesException, IllegalArgumentException {
        store = new Store("Joshy", position1);
        System.out.println(store.purchase("REPAIR_KIT", 8));
        System.out.println(store.cargo.getResources());


    }
}