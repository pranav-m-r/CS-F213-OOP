import java.util.*;

public class Member {
    private final String ID, name;
    private List<Book> borrowingHistory;

    public Member(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.borrowingHistory = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void addBorrowedBook(Book book) {
        borrowingHistory.add(book);
    }

    public void displayBorrowingHistory() {
        System.out.println("Borrowing history for " + name + ":");
        for (Book book : borrowingHistory) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}
