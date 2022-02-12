package Assign02;
import java.util.ArrayList;

/**
 * Name: Aditya Verma
 * Date: Feb 11, 2022
 * Description: Lab 03 "Object-Oriented Programming" Submission for CS321.
 */
public class Library {
    //Private instance variables for the object Library
    private ArrayList<Book> bookCollection;
    private String address;
    private final String hours = "9AM-5PM";

    /**
     * Constructor Library initialising the private instance variables
     * @param bookCollection ; an ArrayList ; an ArrayList of Books
     * @param libAddress ; a String variable ; the address of the library
     */
    public Library(ArrayList<Book> bookCollection, String libAddress) {
        this.bookCollection = bookCollection;
        this.address = libAddress;
    }

    /**
     * Prints the operation hours of the library
     */
    public void printHours() {
        System.out.println("Opening hours are " + hours);
    }

    /**
     * Prints the address of the library
     */
    public void printAddress() {
        System.out.println(address);
    }

    /**
     * Borrows an existing book in the library
     * @param bookTitle ; a String value ; the book title
     * @return false ; a boolean value ; if the book has already been borrowed or if there are no books in the library
     * @return true ; a boolean value ; when the book is successfully borrowed
     */
    public boolean borrowBook(String bookTitle) {
        for(int i = 0; i < bookCollection.size(); i++) {
            if ((bookCollection.get(i).getTitle()) == bookTitle) {

                //Checking if the book has already been borrowed, if so, printing an error message.
                //Not allowing to borrow in such a case by returning false.
                if(bookCollection.get(i).isBorrowed(bookCollection.get(i))){
                    System.out.println("\nCannot borrow the book \"" + bookCollection.get(i).getTitle()
                                        + "\". The book has already been borrowed.");
                    return false;
                }
                bookCollection.get(i).borrowed();
                return true;
            }
        }
        //Printing error message, if the book is not found in the library's book collection.
        System.out.println("\nSorry! This library does not have the book \"" + bookTitle + "\".");
        return false;
    }

    /**
     * Returns a book to the library
     * @param bookTitle ; a String value ; the book title
     * @return false ; a boolean value ; if the book return was unsuccessful
     * @return true ; a boolean value ; when the book was returned successfully
     */
    public boolean returnBook(String bookTitle) {
        for(int i = 0; i < bookCollection.size(); i++) {
            if ((bookCollection.get(i).getTitle()) == bookTitle) {
                bookCollection.get(i).returned();
                return true;
            }
        }
        return false;
    }

    /**
     * Prints the available books at the library
     */
    public int printAvailBooks() {
        if (bookCollection.size() == 0) {
            System.out.println("\nThere are no books in the library at \"" + address + "\"!");
            return -1;
        }
        System.out.println("\nThe library at \"" + address + "\" has the following books available:");
        for(int i = 0; i < bookCollection.size(); i++) {
            if (!(bookCollection.get(i).isBorrowed(bookCollection.get(i)))) {
                System.out.println(bookCollection.get(i).getTitle());
            }
        }
        return 1;
    }

    /**
     * Tests all the functions listed above.
     * @param args A string array containing the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Book> bookCollection1 = new ArrayList<Book>();
        ArrayList<Book> bookCollection2 = new ArrayList<Book>();

        //Entering the 2 libraries
        Library newLibrary = new Library(bookCollection1, "120 Queen St.");
        Library otherLibrary = new Library(bookCollection2, "228 College St.");

        //Adding the 4 books in the book collection at the library on 1290 Queen St.
        bookCollection1.add(new Book("The DaVinci Code"));
        bookCollection1.add(new Book("Le Petit Prince"));
        bookCollection1.add(new Book("A Tale of Two Cities"));
        bookCollection1.add(new Book("The Lord of The Rings"));

        //Printing the opening hours for both the libraries.
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println();

        newLibrary.printHours();
        otherLibrary.printHours();

        //Printing the addresses for both the libraries.
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println();
        newLibrary.printAddress();
        otherLibrary.printAddress();

        /** Borrowing The Lord of The Rings at the library on Queen St.,
         *  and without returning it, trying to borrow it again.
         */
        System.out.println("\n--------------------------------------------------------------------");
        newLibrary.borrowBook("The Lord of The Rings");
        newLibrary.borrowBook("The Lord of The Rings");

        //Trying to borrow the same book from the library on College st.
        System.out.println("\n--------------------------------------------------------------------");
        otherLibrary.borrowBook("The Lord of The Rings");

        //Printing the books you have available at each library.
        System.out.println("\n--------------------------------------------------------------------");
        newLibrary.printAvailBooks();
        System.out.println("\n--------------------------------------------------------------------");
        otherLibrary.printAvailBooks();

        //Returning the book "The Lord of The Rings"
        newLibrary.returnBook("The Lord of The Rings");

        //Re-printing the books available
        System.out.println("\n--------------------------------------------------------------------");
        newLibrary.printAvailBooks();
        System.out.println("\n--------------------------------------------------------------------");
    }
}


