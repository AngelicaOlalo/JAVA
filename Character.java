public class Character {
private String name;  //Step 1 add privates fields
private int health;
private int strength;
private int level;
private static int totalCharacterCreated; //step 1 private static int totalCaharactersCreated
public static final String KINGDOM_NAME = "Westeros"; //add a final string KINGDOM_NAME

public Character (String name, int health, int strength, int level) {
    this.name = name;
    this.health = health;
    this.strength = strength;
    this.level = level;
    this.name = name;
    totalCharacterCreated++; //increment 
}

public void displayInfo() { //Step 2, returns void and prints all fields
    System.out.println("\nName: " + name + "\nHealth: " + health + "\nStrength: " + strength + "\nLevel: " + level + "\n");
}

public String attack() { //Step 3, returns a string that describes the attack
    return name + " swings a sword for " + strength + " damage";
}

public void rest() { //Step 4
    health = health + 10; //adds 10 in health
    if (health > 100) { //does not exceed 100
        health = 100;
    }
}
//Step 5
//one with parameter
public void train(int strength) {
    this.strength += strength; //adds strength if the user uses damage
    this.level = level + 1; //adds level whenever the user trains
}

//one returns a non-void value
public int getHealth() {
    return health;
}

//method that returns the totalCharacterCreated count
public static int getTotalCharacters() {
    return totalCharacterCreated;
}

//Overloaded methods
//1
public void levelUp() {
    this.level += 1;
    this.strength += 5;
}

//2
public void levelUp(int bonusPoints) {
    this.level += 1;
    this.strength += bonusPoints;
}

//3
public void levelUp(int bonusPoints, String skillLearned) {
    this.level += 1;
    this.strength += bonusPoints;
    System.out.println(name + " has learned a new skill " + skillLearned);
}

public void levelUp(Integer wrapperPoints) {
    this.level += 1;
    this.strength += wrapperPoints;
    System.out.println(wrapperPoints + " are added to the strength");
}

public static void main(String[] args) {
    Character ch1 = new Character("Daenarys", 100, 50, 15);

    ch1.levelUp();
    ch1.displayInfo();

    ch1.levelUp(5);
    ch1.displayInfo();

    ch1.levelUp(5, "Dragonfire");
    ch1.displayInfo();

    //I passed a plain int 50, then java automatically autboxes the primitive int 50 into an Integer wrapper object since the LevelUp(Integer wrapperpoints) method expects an object
    ch1.levelUp(50);
    ch1.displayInfo();

}
}

//  CHRONICLES 2
// public class Character {
// private String name;
// private int health;
// private int strength;
// private int level;
// private static int totalCharacterCreated; //step 1 private static int totalCaharactersCreated
// public static final String KINGDOM_NAME = "Westeros"; //add a final string KINGDOM_NAME

// public Character (String name, int health, int strength, int level) {
//     this.name = name;
//     this.health = health;
//     this.strength = strength;
//     this.level = level;
//     this.name = name;
//     totalCharacterCreated++; //increment
// }

// public void displayInfo() { //Step 2, returns void and prints all fields
//     System.out.println("Name: " + name + "\nHealth: " + health + "\nStrength: " + strength + "\nLevel: " + level + "\n");
// }

// public String attack() { //Step 3, returns a string that describes the attack
//     return name + " swings a sword for " + strength + " damage";
// }

// public void rest() { //Step 4
//     health = health + 10; //adds 10 in health
//     if (health > 100) { //does not exceed 100
//         health = 100;
//     }
// }
// //Step 5
// //one with parameter
// public void train(int strength) {
//     this.strength += strength; //adds strength if the user uses damage
//     this.level = level + 1; //adds level whenever the user trains
// }

// //one returns a non-void value
// public int getHealth() {
//     return health;
// }

// //method that returns the totalCharacterCreated count
// public static int getTotalCharacters() {
//     return totalCharacterCreated;
// }

// public static void main(String[] args) {
//     Character ch1 = new Character("Daenarys", 100, 50, 15);
//     Character ch2 = new Character("Daemon", 100, 60, 20);
//     Character ch3 = new Character("Drogon", 100, 70, 25);
//     Character ch4 = new Character("Drogon", 100, 70, 25);

//     ch1.displayInfo();
//     ch2.displayInfo();
//     ch3.displayInfo();

//     System.out.println("Kingdom Name: " + Character.KINGDOM_NAME);
//     System.out.println("Total Characters: " + getTotalCharacters());
// }
// }