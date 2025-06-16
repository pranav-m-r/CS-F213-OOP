import java.util.*;

public class Library {
    private Map<String, Book> bookCatalog;
    private Map<String, Member> members;
    private Map<String, Queue<String>> reservationQueues;

    public Library() {
        bookCatalog = new HashMap<String, Book>();
        members = new HashMap<String, Member>();
        reservationQueues = new HashMap<String, Queue<String>>();
    }

    public void addBook(String ISBN, String title, String author) {
        Book book = new Book(ISBN, title, author);
        bookCatalog.put(ISBN, book);
        System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor());
    }

    public void registerMember(String ID, String name) {
        Member member = new Member(ID, name);
        members.put(ID, member);
        System.out.println("Member registered: " + name + " with ID: " + ID);
    }

    public void borrowBook(String ID, String ISBN) {
        Book book = bookCatalog.get(ISBN);
        Member member = members.get(ID);
        if (book.isAvailable()) {
            book.setAvailable(false);
            member.addBorrowedBook(book);
            System.out.println(member.getName() + " has borrowed: " + book.getTitle());
        }
        else {
            if (!reservationQueues.containsKey(ISBN)) {
                reservationQueues.put(ISBN, new LinkedList<String>());
            }
            reservationQueues.get(ISBN).add(ID);
            System.out.println(member.getName() + " has been added to the reservation queue for: " + book.getTitle());
        }
    }

    public void returnBook(String ID, String ISBN) {
        Book book = bookCatalog.get(ISBN);
        Member member = members.get(ID);
        book.setAvailable(true);
        System.out.println(book.getTitle() + " has been returned by " + member.getName());
        if (!reservationQueues.containsKey(ISBN)) {
            reservationQueues.put(ISBN, new LinkedList<String>());
        }
        Queue<String> queue = reservationQueues.get(ISBN);
        if (!queue.isEmpty()) {
            String id = queue.remove();
            borrowBook(id, ISBN);
        }
    }

    public void displayBookCatalog() {
        System.out.println("Library Catalog:");
        for (Book book : bookCatalog.values()) {
            System.out.println(book + " - " + ((book.isAvailable()) ? "available" : "unavailable"));
        }
    }

    public void displayMemberHistory(String ID) {
        Member member = members.get(ID);
        member.displayBorrowingHistory();
    }
}
