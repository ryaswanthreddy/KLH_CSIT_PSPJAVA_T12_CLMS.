
import java.util.Scanner;git 

public class SimpleLibrary {
    static int[] bookIds = new int[50];       
    static String[] bookTitles = new String[50];
    static boolean[] issued = new boolean[50];   
    static int bookCount = 0;

    
    public static void addBook(int id, String title) {
        bookIds[bookCount] = id;
        bookTitles[bookCount] = title;
        issued[bookCount] = false;
        bookCount++;
        System.out.println("Book added: " + title);
    }

    
    public static void issueBook(int id) {
        for (int i = 0; i < bookCount; i++) {
            if (bookIds[i] == id && !issued[i]) {
                issued[i] = true;
                System.out.println("Book issued: " + bookTitles[i]);
                return;
            }
        }
        System.out.println("Book not available!");
    }


    public static void returnBook(int id) {
        for (int i = 0; i < bookCount; i++) {
            if (bookIds[i] == id && issued[i]) {
                issued[i] = false;
                System.out.println("Book returned: " + bookTitles[i]);
                return;
            }
        }
        System.out.println("Invalid return request!");
    }

    
    public static void searchBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (bookTitles[i].equalsIgnoreCase(title)) {
                System.out.println("Found: " + bookTitles[i] + " (Issued: " + issued[i] + ")");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    
    public static void displayBooks() {
        System.out.println("\n--- Library Books ---");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("ID: " + bookIds[i] + ", Title: " + bookTitles[i] + ", Issued: " + issued[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();
                addBook(id, title);
            } else if (choice == 2) {
                System.out.print("Enter Book ID to issue: ");
                issueBook(sc.nextInt());
            } else if (choice == 3) {
                System.out.print("Enter Book ID to return: ");
                returnBook(sc.nextInt());
            } else if (choice == 4) {
                System.out.print("Enter Book Title to search: ");
                searchBook(sc.nextLine());
            } else if (choice == 5) {
                displayBooks();
            } else if (choice == 6) {
                System.out.println("Exiting Library System...");
            } else {
                System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}