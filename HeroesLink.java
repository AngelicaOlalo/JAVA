import java.util.*;

class Superheroes {
    String hero;
    Superheroes next = null;
    static Superheroes head;
    static Superheroes tail;

    public Superheroes(String hero) {
        if (head == null) {
            head = this;
            tail = this;
        } else {
            tail.next = this;
            tail = this;
        }
        this.hero = hero;
    }
}
public class HeroesLink {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Superheroes \n1. Add\n2. View\n3. Exit ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter a superheroes's name: ");
                    String hero = sc.nextLine();

                    new Superheroes(hero);

                    System.out.println("Hero added");
                    break;

                case 2:
                    if (Superheroes.head == null) {
                        System.out.println("No heroes found");
                    } else {
                        System.out.println("Heroes: ");

                        Superheroes x  = Superheroes.head;

                        while (x != null) {
                            System.out.println(x.hero);
                            x = x.next;
                        }
                        System.out.println("null");
                    }
                    break;

                case 3:
                    break;

            }
        } while (choice != 3);
        System.out.println("Exit successfully");
    }
}
