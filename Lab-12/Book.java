public class Book {
    private String ISBN, title, author;
    private boolean availabilityStatus;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        availabilityStatus = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return availabilityStatus;
    }

    public void setAvailable(boolean status) {
        availabilityStatus = status;
    }

    public String toString() {
        return ISBN + ": " + title + " by " + author;
    }
}