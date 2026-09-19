import java.util.*;

class Song {
    String title;
    String chorus;
    Song next;
    Song prev;

    public Song(String title, String chorus, Song prev) {
        this.title = title;
        this.chorus = chorus;
        this.prev = prev;

        if (prev != null) {
            prev.next = this;
        }
    }
}

public class Playlist {
    public static void main(String args[] ) {
        Scanner sc = new Scanner(System.in);

        Song song1 = new Song("About you", "Do you think I have forgotten? \nDo you think I have forgotten? \nDo you think I have forgotten about you?", null);
        Song song2 = new Song("Can I Have This Dance", "It's like catching lightning \nThe chances of finding someone like you \nIt's one in a million \nThe chances of feeling the way we do \nAnd with every step together \nWe just keep on getting better \nSo can I have this dance? ", song1);
        Song song3 = new Song("This Is Me", "This is real, this is me \nI'm exactly where I'm supposed to be, now \nGonna let the light shine on me \nNow I've found who I am \nThere's no way to hold it in \nNo more hiding who I wanna be \nThis is me", song2);
        Song song4 = new Song("Still Into You", "I should be over all the butterflies \nBut I'm into you (I'm into you) \nAnd baby even on our worst nights \nI'm into you (I'm into you)", song3);
        Song song5 = new Song("Iris", "And I don't want the world to see me \nCause I don't think that they'd understand \nWhen everything's made to be broken \nI just want you to know who I am", song4);
        Song song6 = new Song("Love Story", "Romeo, take me somewhere we can be alone \nI'll be waiting, all there's left to do is run \nYou'll be the prince and I'll be the princess \nIt's a love story, baby, just say, 'Yes", song5);

        Song current = song1;

        int choice;

        do {
            System.out.println("\nAngelica's Playlist");
            System.out.println(song1.title);
            System.out.println(song2.title);
            System.out.println(song3.title);
            System.out.println(song4.title);
            System.out.println(song5.title);
            System.out.println(song6.title);

            System.out.println("Now Playing: " + current.title);
            System.out.println("\nLyrics: \n" + current.chorus);

            System.out.println("1. Previous \n2. Next \n3. Exit \n");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    if (current.prev != null) {
                        if (current.prev != null) {
                            current = current.prev;
                        }
                    }
                    break;
                case 2:
                    if (current.next != null) {
                        if (current.next != null) {
                            current = current.next;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exit successfully");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 3);
    }
}
