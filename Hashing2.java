import java.util.*;

public class Hashing2 {
    static class Node {
        int studid;
        String studentname;
        Node next;

        public Node(int studid, String studentname) {
            this.studid = studid;
            this.studentname = studentname;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node[] studentTable = new Node[5];
        int studcount = 0;
        int choice;

        do {
            System.out.println("Hashing \n1. Add \n2. Linear Probing \n3. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if(studcount >= 5) {
                        System.out.println("Student List are full");
                        break;
                    }

                    int id;
                    System.out.print("Enter student ID: ");
                    id = sc.nextInt();

                    if (id < 10 || id > 99) {
                        System.out.println("Valid input, must input 2 digits (10-99)");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    int mod = id % 5;

                    while (studentTable[mod] != null) {
                        System.out.println("Collision at " + mod + ", trying next spot");
                        mod++;

                        if (mod == 5) {
                            mod = 0;
                        }
                    }

                    studentTable[mod] = new Node(id, name);
                    studcount++;
                    break;

                case 2:
                    if (studcount == 0) {
                        System.out.println("Theres no students to view");
                    }
                    
                    for (int i = 0; i < 5; i++) {
                        System.out.print(i + " ");

                        Node x = studentTable[i];

                        if (x != null) {
                        System.out.print(x.studid + " " + x.studentname);
                        } else {
                        System.out.println("Empty");
                    }
                    System.out.println("");
                }
                break;
                case 3:
                    System.out.println("Exit successfully");
                    break;
            }
        } while (choice != 3);
    }
}
