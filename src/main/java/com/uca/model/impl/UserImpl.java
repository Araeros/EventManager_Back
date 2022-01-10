package com.uca.model.impl;

import com.uca.model.User;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class UserImpl extends User {

    private ArrayList<TimeSeriesImpl> timeSeriesList;
    private static final Logger Log = Logger.getLogger(UserImpl.class);

    public UserImpl(String firstName, String lastName) {
        this.setUserId(this.genUserId(firstName, lastName));
        this.setFirstname(firstName);
        this.setLastname(lastName);
        this.setSeriesList();
    }

    public UserImpl() {
        this.setFirstname("Hann");
        this.setLastname("Solo");
        this.setUserId("Error");
        this.setSeriesList();
    }

    public static UserImpl getUserById(String userId) {
        //TODO: GetUser for deletion method
        return new UserImpl();
    }

    public void setSeriesList(ArrayList<TimeSeriesImpl> newTimeSeriesList) {
        this.timeSeriesList = newTimeSeriesList;
    }
    public void setSeriesList() {
        this.timeSeriesList = new ArrayList<TimeSeriesImpl>();
    }


    public static UserImpl createUser(User newUser) {
        UserImpl newUserImpl = new UserImpl();
        if (newUser != null) {
            try {
                newUserImpl.setFirstname(newUser.getFirstname());
                newUser.setLastname((newUser.getLastname()));
                newUserImpl.setUserId(newUserImpl.genUserId(newUserImpl.getFirstname(), newUserImpl.getLastname()));
            } catch (Exception e){
                Log.error("Couldn't create user with null parameter");
                return new UserImpl();
            }
            Log.info("Successful User Creation");
            return newUserImpl;
        }
        return new UserImpl();
    }

    public static UserImpl createUser(String firstname, String lastname) {
        UserImpl newUserImpl = new UserImpl();
        try {
            newUserImpl.setFirstname(firstname);
            newUserImpl.setLastname(lastname);
            newUserImpl.setUserId(newUserImpl.genUserId(newUserImpl.getFirstname(), newUserImpl.getLastname()));
        } catch (Exception e){
            Log.error("Couldn't create user with null parameter");
            return new UserImpl();
        }
        Log.info("Successful User Creation");
        return newUserImpl;
    }

    private String genUserId(String firstName, String lastName) {
        StringBuilder builder = new StringBuilder()
                .append(firstName.toLowerCase(Locale.ROOT).substring(0,1))
                .append("-")
                .append(lastName.toLowerCase(Locale.ROOT).substring(0,1))
                .append("-")
                .append(new Date());
        return builder.toString();
    }
}
