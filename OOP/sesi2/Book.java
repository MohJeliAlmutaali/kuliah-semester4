public class Book {
    private String author;
    private String title;
    private double price;
    private int publisherNumber;

    public Book(String author, String title, double price, int publisherNumber) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.publisherNumber = publisherNumber;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublisherNumber() {
        return publisherNumber;
    }

}
