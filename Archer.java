public class Archer extends Character2 {

    private int arrows;

    public Archer(String name, int health, int strength, int level, int arrows) {

        /*
         * super(...) must be the first statement because the Character2
         * portion must be initialized before the Archer portion.
         *
         * If super(...) is omitted, Java automatically tries to call
         * super(), which calls Character2's no-argument constructor.
         */

        super(name, health, strength, level);

        setArrows(arrows);
    }

    // =========================
    // GETTER
    // =========================

    public int getArrows() {
        return arrows;
    }

    // =========================
    // SETTER
    // =========================

    public void setArrows(int arrows) {

        if (arrows < 0) {
            System.out.println("Rejects negative arrows");
        } else {
            this.arrows = arrows;
        }
    }

    // =========================
    // OVERRIDE ATTACK
    // =========================

    @Override
    public void attack() {

        if (arrows > 0) {

            arrows--;

            System.out.println(
                    getName()
                    + " fires an arrow!"
                    + " Arrows remaining: "
                    + arrows
            );

        } else {

            System.out.println(
                    getName()
                    + " has no arrows left."
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

        // Then Archer-specific information.
        System.out.println("Arrows: " + arrows);
    }
}