import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        this.books.add(book);
    }

    // Remove a book from the library by title
    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    // Find all books published in a specific year
    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    // Find all books by a specific author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Find the book with the most pages
    public Book findBookWithMostPages() {
        return books.stream()
                .max((book1, book2) -> book1.getPages() - book2.getPages())
                .orElse(null);
    }

    // Find all books with more than n pages
    public List<Book> findBooksMoreThanPages(int n) {
        return books.stream()
                .filter(book -> book.getPages() > n)
                .collect(Collectors.toList());
    }

    // Print all book titles in the library, sorted alphabetically
    public void printAllBookTitles() {
        books.stream()
                .map(Book::getTitle)
                .sorted()
                .forEach(System.out::println);
    }

    // Find all books in a specific category
    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Loan out a book
    public boolean loanOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isOnLoan()) {
                book.setOnLoan(true);
                return true;
            }
        }
        return false;
    }

    // Return a book
    public void returnBook(String title) {
        books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresent(book -> book.setOnLoan(false));
    }
}
