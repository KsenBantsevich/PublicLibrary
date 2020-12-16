package sample.services;

import sample.entity.Profile;
import sample.entity.VisitorRole;

import java.util.ArrayList;
import java.util.List;

public interface AuthorizationService {
    Profile authorization(String login, String password);
    boolean checkLoginAndPassword(String login, String password,ArrayList<Profile> profile);
    void setListOfProfiles(List<Profile> listOfProfiles);
    void addProfile(String lastName, String name, String login, String password, String mail, String role);
    void deleteProfile(Profile profile);

    List<Profile> getListOfProfiles();
}

