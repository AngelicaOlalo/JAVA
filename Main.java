public class Main {

    public static void main(String[] args) {

        // ==========================================
        // CREATE ONE OF EACH SUBCLASS
        // ==========================================

        Warrior warrior = new Warrior(
                "Arthur",
                100,
                20,
                5,
                10
        );

        Mage mage = new Mage(
                "Merlin",
                90,
                25,
                6,
                2
        );

        Archer archer = new Archer(
                "Robin",
                85,
                18,
                4,
                2
        );

        // Plain Character2
        Character2 character = new Character2(
                "Recruit",
                100,
                10,
                1
        );

        // ==========================================
        // CHARACTER2 ARRAY
        // ==========================================

        /*
         * Warrior, Mage, and Archer are all subclasses
         * of Character2, so they can all be stored in
         * one Character2 array.
         */

        Character2[] heroes = {
                warrior,
                mage,
                archer,
                character
        };

        // ==========================================
        // LOOP THROUGH ALL CHARACTERS
        // ==========================================

        for (Character2 hero : heroes) {

            System.out.println("\n==============================");

            // Same line of code for every object.
            hero.attack();

            // Same line of code for every object.
            hero.displayInfo();
        }

        // ==========================================
        // TEST MANA RUNNING OUT
        // ==========================================

        System.out.println("\n==============================");
        System.out.println("Testing Mage mana:");

        mage.attack();
        mage.attack();
        mage.attack();

        // ==========================================
        // TEST ARROWS RUNNING OUT
        // ==========================================

        System.out.println("\n==============================");
        System.out.println("Testing Archer arrows:");

        archer.attack();
        archer.attack();
        archer.attack();

        // ==========================================
        // TEST WARRIOR ARMOR
        // ==========================================

        System.out.println("\n==============================");
        System.out.println("Testing Warrior armor:");

        System.out.println(
                "Warrior health before damage: "
                + warrior.getHealth()
        );

        warrior.takeDamage(15);

        System.out.println(
                "Warrior health after damage: "
                + warrior.getHealth()
        );

        // ==========================================
        // TEST PROTECTED METHOD
        // ==========================================

        System.out.println("\n==============================");
        System.out.println("Testing protected clampHealth():");

        warrior.demonstrateProtectedAccess(150);

        // ==========================================
        // TOTAL CHARACTER COUNT
        // ==========================================

        /*
         * The counter was increased by Character2's constructor.
         *
         * Creating Warrior, Mage, and Archer calls super(...),
         * which calls the Character2 constructor.
         *
         * Therefore all subclasses are included in the count.
         */

        System.out.println("\n==============================");

        System.out.println(
                "Total characters created: "
                + Character2.getTotalCharacters()
        );
    }
}