package sample.services;

import sample.entity.PrintEdition;
import sample.entity.Profile;
import sample.entity.VisitorRole;

import java.util.ArrayList;
import java.util.List;

public class AuthorizationServiceImpl implements AuthorizationService {
    List<Profile> listOfProfiles;
    Profile visitor;

    @Override
    public void addProfile(String lastName, String name, String login, String password, String mail, String role) {
        Profile visitor = new Profile(lastName,name,login,password,mail);
        if (VisitorRole.VISITOR.toString().equals(role))
        {
            visitor.setRole(VisitorRole.OWNER);
        }
        else
        {
            visitor.setRole(VisitorRole.OWNER);
        }
        listOfProfiles.add(visitor);
    }

    public void deleteProfile(Profile profile){
        listOfProfiles.remove(profile);
    }

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
