package ports;



import java.util.List;
import java.util.ArrayList;
public class SpacePort extends Object{
    public String name;
    public Position position;
    public List<String> canUpgrade = new ArrayList();
    public SpacePort(String name, Position position){
        this.name = name;
        this.position = position;
    }
    public String getName(){
        return name;
    }

    public Position getPosition(){
        return this.position;
    }

    public String toString(){
        String className = this.getClass().getSimpleName();
        String info;
        info = String.format("PORT: %s, %s at %s", this.name, className, this.position);
        return info;
    }
    public List<String> getActions(){
        return canUpgrade;
    }


}
