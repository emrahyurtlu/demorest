package com.company.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("secured")
public class SecuredResource {
    @GET
    public String message() {
        String message = "Hello world!";
        return message;
    }
}
