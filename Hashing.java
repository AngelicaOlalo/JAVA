import java.util.*;
// hashing
// 2 digits 10-99
// uses array
// uses linked list

public class Student {
    static class Node {
        int studid; // stores ID
        String studentname; // stores student name
        Node next; // points to the next student node

        public Node(int studid, String studentname) {
            this.studid = studid;
            this.studentname = studentname;
            this.next = null; // leads to nothing
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node[] studentTable = new Node[5]; //array 0-4
        int choice;
        int studentCount = 0; //tracks the total num of the students added

        do {
            System.out.println("Choices \n1. Add \n2. Show table \n3. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int id;
                    System.out.print("Enter student ID: "); //ensure the ID is 2 digits
                    id = sc.nextInt();

                    if (id < 10 || id > 99) {
                        System.out.println("Invalid input, must input 2 digits (10-99)");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    int mod = id % 5; //calculates using hash function
                    
                    Node newStudent = new Node(id, name); //new node with the student's data

                    newStudent.next = studentTable[mod]; //insert at the head, it links new node to the existing list in this index
                    studentTable[mod] = newStudent; //updates the array to point to the new node as the head
                    studentCount++;
                    break;

                case 2:
                    if (studentCount == 0) { //check if the table is empty
                        System.out.println("Theres no students");
                    } else {
                        for (int i = 0; i < 5; i++) {
                            System.out.print(i + " "); //print current indexes
                            
                            Node x = studentTable[i]; //temp pointer to traverse the linked list at index
                            
                            while (x != null) { //traverse until the end
                                System.out.print(x.studid + " " + x.studentname);
                                
                                if (x.next != null) { //adds an arrow if theres chaining
                                    System.out.print(" -> ");
                                }
                                
                                x = x.next; //move to the next student
                            }
                            System.out.println();
                        }
                    }

                    break;
                case 3:
                    System.out.println("Exit successfully");
                    break;
            }
        } while (choice != 3);
    }
}
