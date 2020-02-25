package com.company.resource;

import com.company.model.MyDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;

@Path("date")
public class DateResource {

    @GET
    @Path("/shortdate")
    @Produces("text/shortdate")
    public Date shortDate() {
        return Calendar.getInstance().getTime();
    }

    @GET
    @Path("/now")
    @Produces(MediaType.TEXT_PLAIN)
    public Date getDate() {
        return Calendar.getInstance().getTime();
    }

    @GET()
    @Path("/{dateString}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDate(@PathParam("dateString") MyDate dateString) {
        return "I got date: " + dateString;
    }
}
