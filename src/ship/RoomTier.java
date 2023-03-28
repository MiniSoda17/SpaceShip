package ship;

/**
 * Enumerates the quality tiers for Rooms.
 * @version 1.0
 * @ass1
 */

public enum RoomTier {
    /**
     * The most basic tier of ship.Room. Has healthMultiplier of 10 and damageMultiplier of 2.
     */
    BASIC(10, 2),
    /**
     * The second tier of ship.Room. Has healthMultiplier of 20 and damageMultiplier of 2.
     */
    AVERAGE(20, 2),
    /**
     * The final tier of ship.Room. Has healthMultiplier of 40 and damageMuliplier of 1.
     */
    PRIME(40, 1);

    /**
     * ship.Room quality tier influences the health of a room.
     * @ass1
     */
    public int healthMultiplier;
    /**
     * ship.Room quality tier influences the rate at which it takes damage.
     * @ass1
     */
    public int damageMultiplier;

    /**
     * Constructor which sets healthMultiplier and damageMultiplier for this ship.RoomTier.
     *
     * @param healthMultiplier  The health multiplier for this ship.RoomTier.
     * @param damageMultiplier  The damage multiplier for this ship.RoomTier.
     *
     * @ass1
     */
    RoomTier(int healthMultiplier, int damageMultiplier) {
        this.healthMultiplier = healthMultiplier;
        this.damageMultiplier = damageMultiplier;
    }
}
