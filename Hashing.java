import java.util.*;

public class Hashing {

    static class Node {
        int studid;
        String studentname;
        Node next;


        public Node(int studid, String studentname) {
            this.studid = studid;
            this.studentname = studentname;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node[] studentTable = new Node[5];
        int studcount = 0;
        int choice;

        do {
            System.out.println("Hashing \n1. Add \n2. Show table \n3. Linear probing \n4. Exit");
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

                    Node newStudent = new Node(id, name);
                    newStudent.next = studentTable[mod];
                    studentTable[mod] = newStudent;
                    break;

                case 2:
                    if (studentTable == null) {
                        System.out.println("Theres no students");
                    }
                    for (int i = 0; i < 5; i++) {
                        System.out.print(i + " ");

                        Node x = studentTable[i];

                        while (x != null) {
                        System.out.print(x.studid + " " + x.studentname);

                        if (x.next != null) {
                            System.out.print(" -> ");
                        }
                        x = x.next;
                    }
                    System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Exit successfully");
                    break;
            }
        } while (choice != 3);
    }
}
