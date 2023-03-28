package ship;

import ship.Damageable;

import java.util.ArrayList;
import java.util.List;

public class Room extends Object implements Damageable {
    public RoomTier tier;
    public int damageRate;
    public int maxHealth;
    public int health;
    public List<String> actions = new ArrayList<>();

    public Room(RoomTier tier) {
        this.tier = tier;
        damageRate = this.tier.damageMultiplier * DAMAGE_RATE;
        maxHealth = this.tier.healthMultiplier * HEALTH_MULTIPLIER;
        health = this.tier.healthMultiplier * HEALTH_MULTIPLIER;
    }
    public Room(){
        this(RoomTier.BASIC);
    }

    public void damage(){
        health -= damageRate;
    }

    public RoomTier getTier(){
        return this.tier;
    }

    public int getHealth(){
        int percentage;
        percentage = (this.health * 100)/this.maxHealth;
        return percentage;
    }

    public boolean isBroken(){
        if (this.health <= 0){
            return true;
        } return false;
    }

    public boolean needsRepair(){
        if (this.getHealth() < REPAIR_THRESHOLD){
            return true;
        } return false;
    }

    public void ResetHealth(){
        this.health = this.maxHealth;
    }

    public void setDamageRate(int newDamageRate){
        this.damageRate = newDamageRate;
    }

    public void upgrade(){
        if (this.tier == RoomTier.BASIC){
            this.tier = RoomTier.AVERAGE;
        } else{
            this.tier = RoomTier.PRIME;
        }
    }

    public String toString(){
        String className = this.getClass().getSimpleName();
        String info = String.format("ship.Room: %s(%s)health: %d, needs repair: %s", className,
                                                                            this.getTier(),
                                                                            this.getHealth(),
                                                                            this.needsRepair());
        return info;
    }
    
    public List<String> getActions(){

        return this.actions;
    }
}
