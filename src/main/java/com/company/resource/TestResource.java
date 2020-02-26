package com.company.resource;

import com.company.model.Alien;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("test")
public class TestResource {
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.openSession();

        /*Alien alien = new Alien();
        alien.setName("Dilruba");
        alien.setPoint(100);
        session.save(alien);*/

        session.close();
        return "Got it!";
    }
}