    package com.university.bookstore.bookstoreapi.store;




import com.university.bookstore.bookstoreapi.resources.AuthorResource;
import com.university.bookstore.bookstoreapi.resources.BookResource;
import com.university.bookstore.bookstoreapi.resources.CartResource;
import com.university.bookstore.bookstoreapi.resources.CustomerResource;
import com.university.bookstore.bookstoreapi.resources.OrderResource;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    private final Storage store = new Storage();

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(BookResource.class);
        classes.add(AuthorResource.class);
        classes.add(CustomerResource.class);
        classes.add(CartResource.class);
        classes.add(OrderResource.class);
        return classes;
    }

    public  Storage getStorage() {
        return store;
    }
}