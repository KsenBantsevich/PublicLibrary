package sample.services;

import sample.entity.PrintEdition;
import sample.entity.Profile;

import java.util.List;


public interface BookBorrowingService {
    void takeBook(PrintEdition books);
    void money(PrintEdition books);
    void returnBook(PrintEdition books);
    void mail(List<Profile> listOfProfiles);
}
