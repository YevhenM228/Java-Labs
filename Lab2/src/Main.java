
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        String[] authorsBook1 = {"Stephen Hawking"};
        Book book1 = new Book("The Grand Design", authorsBook1, "Transworld Digital", 2015, 256, 406);

        String[] authorBook2 = {"Robert Winston"};
        Book book2 = new Book("SuperHuman Encyclopedia", authorBook2, "Dorling Kindersley", 2014, 208, 432);

        String[] authorBook3 = {"Johnny Ball", "Richard Hammond", "Robert Winston"};
        Book book3 = new Book("Think of Number. Can You Feel the Force? What Makes Me Me?", authorBook3, "Reader's Digest", 2008, 288, 198);

        Book[] books = {book1, book2, book3};

        System.out.println("Book by Robert Winston: " + booksByAuthor("Robert Winston", books));
        System.out.println("Book by Transworld Digital: " + booksByPublisher("Transworld Digital", books));
        System.out.println("Book after 2009 : " + booksAfterYear(2009, books));

    }

    public static List<Book> booksByAuthor(String author, Book[] books) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            for (String authorBook : book.getAuthors()) {
                if (author.equals(authorBook)) {
                    result.add(book);
                }
            }
        }

        return result;
    }

    public static List<Book> booksByPublisher(String publisher, Book[] books) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (publisher.equals(book.getPublisher())) {
                result.add(book);
            }
        }

        return result;
    }

    public static List<Book> booksAfterYear(int year, Book[] books) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (year < book.getYear()) {
                result.add(book);
            }
        }

        return result;
    }
}
