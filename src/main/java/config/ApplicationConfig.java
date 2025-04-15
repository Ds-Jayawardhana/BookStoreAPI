/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import com.university.bookstore.bookstoreapi.resources.BookResource;
import com.university.bookstore.bookstoreapi.store.Storage;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;


/**
 *
 * @author user
 */
public class ApplicationConfig {
    


/**
 * Configures JAX-RS for the application.
 * @author Juneau
 */
    
@ApplicationPath("api")
    public class MyApplication extends ResourceConfig {
     private final Storage store=new Storage();
     
     
        public MyApplication() {
            register(BookResource.class);
        }
        public Storage getStorage(){
            return store;
        }
    }   
}

    
