package sample.entity;


public class PrintEdition {
    private String bookName;
    private String author;
    private Integer publishingYear;

    public PrintEdition(String bookName, String author,Integer  publishingYear)
    {
        this.bookName = bookName;
        this.author = author;
        this.publishingYear = publishingYear;

    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }


    public void setPublishingYear(Integer publishingYear) {
        this.publishingYear = publishingYear;
    }

    public Integer getPublishingYear() {
        return publishingYear;
    }
}
