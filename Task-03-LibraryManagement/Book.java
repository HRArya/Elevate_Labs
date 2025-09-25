


public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title.trim();
        this.author = author.trim();
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issue() { this.isIssued = true; }
    public void returned() { this.isIssued = false; }

    @Override
    public String toString() {
        return String.format("ID: %d | Title: %s | Author: %s | Status: %s",
                             id, title, author, (isIssued ? "Issued" : "Available"));
    }
}
