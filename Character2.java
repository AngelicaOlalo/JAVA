public class Character2 {

    private final String name;
    private int health;
    private int strength;
    private int level;

    private static int totalCharacterCreated;

    public static final String KINGDOM_NAME = "Westeros";

    // Default constructor
    public Character2() {
        this("Unnamed Recruit", 100, 5, 1);
    }

    // Main constructor
    public Character2(String name, int health, int strength, int level) {
        this.name = name;
        setHealth(health);
        setStrength(strength);
        setLevel(level);

        totalCharacterCreated++;
    }

    // Constructor with name only
    public Character2(String name) {
        this(name, 100, 5, 1);
    }

    // =========================
    // GETTERS AND SETTERS
    // =========================

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = clampHealth(health);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength < 0) {
            System.out.println("Rejects negative values");
        } else {
            this.strength = strength;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            System.out.println("Rejects any value below 1");
        } else if (level < this.level) {
            System.out.println("Rejects any value lower than the current level");
        } else {
            this.level = level;
        }
    }

    // Changed from private to protected for Part 6.
    //
    // private:
    // Only Character2 itself can directly access the member.
    //
    // protected:
    // Character2 and its subclasses can directly access the member.
    //
    // public:
    // Any class that has access to the object can use the member.
    //
    // We do NOT make name, health, strength, or level protected
    // because that would allow subclasses to directly change the
    // fields and would weaken the encapsulation from Part 5.
    protected int clampHealth(int health) {

        if (health < 0) {
            return 0;
        } else if (health > 100) {
            return 100;
        } else {
            return health;
        }
    }

    // =========================
    // METHODS
    // =========================

    public void rest(int healing) {

        if (healing > 0) {
            this.health = clampHealth(this.health + healing);
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public boolean isVeteran() {
        return this.level >= 10;
    }

    public void takeDamage(int amount) {

        if (amount < 0) {
            System.out.println("Rejects negative amount");
        } else {
            this.health = clampHealth(this.health - amount);
        }
    }

    public void attack() {
        System.out.println(name + " performs a basic attack!");
    }

    public void displayInfo() {

        System.out.println(
                "\nName: " + name
                + "\nHealth: " + health
                + "\nStrength: " + strength
                + "\nLevel: " + level
        );
    }

    // =========================
    // STATIC COUNTER
    // =========================

    public static int getTotalCharacters() {
        return totalCharacterCreated;
    }

    /*
     * The counter increases when a Warrior, Mage, or Archer is created
     * because each subclass constructor calls super(...).
     *
     * super(...) calls the Character2 constructor, and the Character2
     * constructor contains:
     *
     * totalCharacterCreated++;
     *
     * Therefore, the subclass does not need to touch the counter itself.
     */
}