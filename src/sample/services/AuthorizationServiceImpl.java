package sample.services;

import sample.entity.Profile;

import java.util.ArrayList;
import java.util.List;

public class AuthorizationServiceImpl implements AuthorizationService {
    List<Profile> listOfProfiles;
    Profile visitor;

    public Profile authorization(String login, String password)
    {
        for(Profile profile1:listOfProfiles)
        {
            if(profile1.getLogin().equals(login) && profile1.getPassword().equals(password))
            {
                visitor = profile1;
                return profile1;
            }
        }
        return null;
    }

    @Override
    public boolean checkLoginAndPassword(String login, String password,ArrayList<Profile> staff) {
        return false;
    }

    public void setListOfProfiles(List<Profile> listOfProfiles) {
        this.listOfProfiles = listOfProfiles;
    }

    public List<Profile> getListOfProfiles() {
        return listOfProfiles;
    }

    public Profile getVisitor() {
        return visitor;
    }

    public void setVisitor(Profile visitor) {
        this.visitor = visitor;
    }
}
