package sample.services;

import sample.entity.PrintEdition;

public interface ServiceForm {
    void takeBook(PrintEdition books);
    void returnBook(PrintEdition books);
}
