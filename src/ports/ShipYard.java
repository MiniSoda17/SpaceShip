package ports;

import ports.Position;
import ship.Room;
import java.util.ArrayList;
import java.util.List;

public class ShipYard extends SpacePort {
    public List<String> canUpgrade;

    public ShipYard (String name, Position position, List<String> canUpgrade){
        super(name, position);

        this.canUpgrade = canUpgrade;
    }

    public void upgrade (Room room){
        room.upgrade();
    }

    public List<String> getActions(){
        List<String> newList = new ArrayList<>();
        for (String s: this.canUpgrade){
            newList.add(String.format("upgrade %s", s));
        }
        return newList;
    }
}
