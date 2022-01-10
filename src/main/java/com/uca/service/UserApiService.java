package com.uca.service;

import com.uca.api.impl.UserApiServiceImpl;
import com.uca.model.impl.UserImpl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class UserApiService extends UserApiServiceImpl {

    private final ArrayList<UserImpl> userList = new ArrayList<>();

    @Override
    public Response createUser(List<String> requestBody, SecurityContext securityContext) {
        UserImpl newUser = UserImpl.createUser(requestBody.get(0), requestBody.get(1));
        if (!newUser.getUserId().equals("Error")) {
            userList.add(newUser);
            return Response.created(URI.create(newUser.getUserId())).build();
        } else {
          return Response.status(400, "Invalid Parameter").build();
        }
    }

    @Override
    public Response deleteUser(String userId,SecurityContext securityContext) {
        try {
            userList.remove(UserImpl.getUserById(userId));
            return Response.status(204, "Successful Deletion").build();
        } catch (Exception e) {
            return Response.status(400, e.getMessage()).build();
        }
    }
}
