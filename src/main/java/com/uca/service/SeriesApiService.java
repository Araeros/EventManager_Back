package com.uca.service;

import com.uca.api.impl.SeriesApiServiceImpl;
import com.uca.model.TimeSeries;
import com.uca.model.impl.TimeSeriesImpl;
import com.uca.model.impl.UserImpl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.net.URI;
import java.util.ArrayList;

public class SeriesApiService extends SeriesApiServiceImpl{

    private final ArrayList<UserImpl> userList = new ArrayList<>();

    public Response addSeries(String userId, TimeSeries timeSeries, SecurityContext securityContext) {
        for (UserImpl user : userList) {
            if ( user.getUserId() == userId) {
                TimeSeriesImpl newSeries = TimeSeriesImpl.addSeries(timeSeries, user);
                return Response.created(URI.create(newSeries.getSeriesId())).build();
            }
        }
        return Response.status(400, "Invalid Parameter").build();
    }

    public Response deleteSeries(String seriesId, SecurityContext securityContext) {
        return null;
    }

    public Response getSeries(String userId, SecurityContext securityContext) {
        return null;
    }

    public Response updateSeries(TimeSeries timeSeries, SecurityContext securityContext) {
        return null;
    }

}
