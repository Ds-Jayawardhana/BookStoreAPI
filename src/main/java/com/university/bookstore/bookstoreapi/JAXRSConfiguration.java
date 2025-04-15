package com.university.bookstore.bookstoreapi;

import com.university.bookstore.bookstoreapi.store.Storage;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application.
 * @author Juneau
 */
@ApplicationPath("api")
public class JAXRSConfiguration extends Application {
    private final Storage store=new Storage();
    
    public Storage getStorage(){
        return store;
    }
    
}
