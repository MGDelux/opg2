/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;
import Entity.Book;
import model.bookNoDB;
import com.google.gson.Gson;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author mathi
 */
@Path("book")
public class BookResource {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");


    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookResource
     */
    public BookResource() {
    }

    /**
     * Retrieves representation of an instance of rest.BookResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "{\"msg\":\"BOOKS\"}";
    }
    
    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBook() {
        return new Gson().toJson("xd");
    }
    
    @GET
    @Path("/dbbooks")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDBBooks() {
          EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Book> query = em.createQuery("SELECT a FROM BOOK a", Book.class);
      List<Book> books = query.getResultList();
      return new Gson().toJson(books);
    }finally{
            emf.close();
        }
}
    /**
     * PUT method for updating or creating an instance of BookResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
         return "{\"msg\":\""+content+"\"}";
    }
}
