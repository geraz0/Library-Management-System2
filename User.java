import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int libraryCardNumber;
    private List<Book> booksOnLoan;

    public User(String name, int libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.booksOnLoan = new ArrayList<>();
    }

    // Method to add a book to the user's list of books on loan
    public void borrowBook(Book book) {
        booksOnLoan.add(book);
    }

    // Method to return a book
    public void returnBook(Book book) {
        booksOnLoan.remove(book);
    }

    // Additional methods for calculating late fees, etc., can be added here
}
