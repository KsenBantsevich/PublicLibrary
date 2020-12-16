package sample.services;

import sample.entity.Profile;

import java.util.ArrayList;
import java.util.List;

public interface AuthorizationService {
    Profile authorization(String login, String password);
    boolean checkLoginAndPassword(String login, String password,ArrayList<Profile> profile);
    void setListOfProfiles(List<Profile> listOfProfiles);

    List<Profile> getListOfProfiles();
    }

