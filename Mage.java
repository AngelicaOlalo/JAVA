public class Mage extends Character2 {

    private int mana;

    public Mage(String name, int health, int strength, int level, int mana) {

        /*
         * super(...) must be the first statement because the Character2
         * portion must be initialized before the Mage portion.
         *
         * If super(...) is left out, Java automatically attempts
         * to call super(), which means the parent's no-argument
         * constructor would be used.
         */

        super(name, health, strength, level);

        setMana(mana);
    }

    // =========================
    // GETTER
    // =========================

    public int getMana() {
        return mana;
    }

    // =========================
    // SETTER
    // =========================

    public void setMana(int mana) {

        if (mana < 0) {
            System.out.println("Rejects negative mana");
        } else {
            this.mana = mana;
        }
    }

    // =========================
    // OVERRIDE ATTACK
    // =========================

    @Override
    public void attack() {

        if (mana > 0) {

            mana--;

            System.out.println(
                    getName()
                    + " casts a powerful magic attack!"
                    + " Mana remaining: "
                    + mana
            );

        } else {

            System.out.println(
                    getName()
                    + " has no mana left."
            );

            // Fall back to the ordinary Character2 attack.
            super.attack();
        }
    }

    // =========================
    // OVERRIDE DISPLAY INFO
    // =========================

    @Override
    public void displayInfo() {

        // Parent information first.
        super.displayInfo();

        // Then Mage-specific information.
        System.out.println("Mana: " + mana);
    }
}