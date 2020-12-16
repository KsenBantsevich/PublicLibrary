package sample.services;

public interface BookService {
    void addToLibrary(String author, String bookName,  Integer publishingYear);
    void checkIfExists(String bookName);
}
