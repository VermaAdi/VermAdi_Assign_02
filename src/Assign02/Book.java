package Assign02;

/**
 * Name: Aditya Verma
 * Date: Feb 11, 2022
 * Description: Lab 03 "Object-Oriented Programming" Submission for CS321.
 */
public class Book {
    //Private instance variables for the object Book
    private String title;
    private boolean borrowed;

    /**
     * Constructor Library initialising the private instance variables
     * @param bookTitle ; a String value ; the book title
     */
    public Book(String bookTitle) {
        this.title = bookTitle;
    }

    /**
     * Setter method for the borrowed instance variable, if the book is borrowed.
     */
    public void borrowed() {
        this.borrowed = true;
    }

    /**
     * Setter method for the borrowed instance variable, if the book is returned.
     */
    public void returned() {
       this.borrowed = false;
    }

    /**
     * Method checks if the book has currently been borrowed or not.
     * @param book ; a Book object ; checking this book's availability.
     * @return false ; a boolean value ; if the book has not been borrowed
     * @return true ; a boolean value ; if the book has been borrowed
     */
    public boolean isBorrowed(Book book) {
       return borrowed;
    }

    /**
     * Getter method for the book's title.
     * @return a String value ; the book's title.
     */
    public String getTitle() {
        return title;
    }
}
