public class Warrior extends Character2 {

    private int armor;

    public Warrior(String name, int health, int strength, int level, int armor) {

        /*
         * super(...) must be the first statement because the parent
         * Character2 part must be initialized before the Warrior part.
         *
         * If super(...) is completely left out, Java automatically
         * tries to call the parent's no-argument constructor:
         *
         * super();
         *
         * Character2 has a no-argument constructor, so that would work
         * here, but it would NOT pass the name, health, strength, and
         * level values we want.
         */

        super(name, health, strength, level);

        setArmor(armor);
    }

    // =========================
    // GETTER
    // =========================

    public int getArmor() {
        return armor;
    }

    // =========================
    // SETTER
    // =========================

    public void setArmor(int armor) {

        if (armor < 0) {
            System.out.println("Rejects negative armor");
        } else {
            this.armor = armor;
        }
    }

    // =========================
    // OVERRIDE ATTACK
    // =========================

    @Override
    public void attack() {

        System.out.println(
                getName()
                + " attacks with a weapon while protected by "
                + armor
                + " armor!"
        );
    }

    // =========================
    // OVERRIDE DISPLAY INFO
    // =========================

    @Override
    public void displayInfo() {

        // Call parent's displayInfo FIRST.
        super.displayInfo();

        // Only display the new Warrior field.
        System.out.println("Armor: " + armor);
    }

    // =========================
    // OVERRIDE TAKE DAMAGE
    // =========================

    @Override
    public void takeDamage(int amount) {

        if (amount < 0) {
            System.out.println("Rejects negative amount");
            return;
        }

        // Armor absorbs part of the incoming damage.
        int reducedAmount = amount - armor;

        if (reducedAmount < 0) {
            reducedAmount = 0;
        }

        /*
         * Call the parent's takeDamage() instead of rewriting
         * the health-changing logic.
         *
         * This means Warrior EXTENDS the parent's behavior.
         */
        super.takeDamage(reducedAmount);
    }

    // =========================
    // PROTECTED ACCESS EXAMPLE
    // =========================

    public void demonstrateProtectedAccess(int value) {

        /*
         * clampHealth() is protected in Character2.
         * Because Warrior extends Character2, Warrior can directly
         * use the protected method.
         */
        int safeHealth = clampHealth(value);

        System.out.println("Clamped health: " + safeHealth);
    }
}