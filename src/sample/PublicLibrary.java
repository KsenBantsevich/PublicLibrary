package sample;
import sample.UI.UI;
import sample.entity.Profile;
import sample.entity.VisitorRole;
import sample.services.*;

import java.util.ArrayList;

public class PublicLibrary {

    private UI ui;

    public void start() {
        AuthorizationServiceImpl authorizationService = new AuthorizationServiceImpl();
        BookBorrowingServiceImpl bookBorrowingService = new BookBorrowingServiceImpl();
        BookServiceImpl bookService = new BookServiceImpl();
        ServiceFormImpl serviceForm = new ServiceFormImpl();

        Profile visitor = new Profile("Ксения","Банцевич", "111","111","ggg@gmail");
        Profile visitor1 = new Profile("Анна","Грицук","222","222","ааа@gmail.com");

        visitor.setRole(VisitorRole.ROLE_OWNER);
        visitor1.setRole(VisitorRole.ROLE_VISITOR);
        ArrayList<Profile> visitorArrayList = new ArrayList<>();
        visitorArrayList.add(visitor);
        visitorArrayList.add(visitor1);
        authorizationService.setListOfProfiles(visitorArrayList);
        ui = new UI();
        ui.setAuthorizationService(authorizationService);
        ui.setBookBorrowingService(bookBorrowingService);
        ui.setBookService(bookService);
        ui.setServiceForm(serviceForm);
        ui.entry();
    }
    public UI getUi() {
        return ui;
    }

}
