package com.company.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {
    /*
    * Bu kod, response'a yeni header eklememizi sağladı.
    * */
    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {
        //responseContext.getHeaders().add("X-Powered-By", "Java Jax-Rs Framework");
    }
}
