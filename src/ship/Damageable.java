package ship;

public interface Damageable {
    static final int DAMAGE_RATE = 5;
    static final int HEALTH_MULTIPLIER = 5;
    static final int REPAIR_THRESHOLD = 30;

    public void damage();
    public int getHealth();

    public default boolean isBroken() {
        return false;
    }

    public default boolean needsRepair() {
        return false;
    }

    public void ResetHealth();
    public void setDamageRate(int newDamageRate);
}
