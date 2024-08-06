import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // Creating the library instance
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("1984", "George Orwell", 1949, 328, "Fiction"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 310, "Fiction"));
        library.addBook(new Book("A Brief History of Time", "Stephen Hawking", 1988, 212, "Science"));
        library.addBook(new Book("Java Fundamentals", "Oracle", 2014, 534, "Education"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 218, "Fiction"));

        // Print all book titles, sorted alphabetically
        System.out.println("All book titles in the library:");
        library.printAllBookTitles();

        // Find all books by George Orwell
        List<Book> orwellBooks = library.findBooksByAuthor("George Orwell");
        System.out.println("\nBooks by George Orwell:");
        orwellBooks.forEach(book -> System.out.println(book));

        // Find all books published in 1988
        List<Book> booksFrom1988 = library.findBooksByYear(1988);
        System.out.println("\nBooks published in 1988:");
        booksFrom1988.forEach(book -> System.out.println(book));

        // Find the book with the most pages
        Book mostPagesBook = library.findBookWithMostPages();
        System.out.println("\nBook with the most pages:");
        System.out.println(mostPagesBook);

        // Find all Fiction books
        List<Book> fictionBooks = library.findBooksByCategory("Fiction");
        System.out.println("\nFiction books:");
        fictionBooks.forEach(book -> System.out.println(book.getTitle()));

        // Attempt to loan out "1984"
        if (library.loanOutBook("1984")) {
            System.out.println("\n\"1984\" has been loaned out.");
        } else {
            System.out.println("\n\"1984\" could not be loaned out.");
        }

        // Attempt to return "1984"
        library.returnBook("1984");
        System.out.println("\"1984\" has been returned.");
    }
}
