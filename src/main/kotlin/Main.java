import ch.vorburger.mariadb4j.DB;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.reactive.stage.Stage;

public class Main {

    public static void main(String[] args) throws Exception {
        DB.newEmbeddedDB(3307).start();
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("reactiveTest")) {
            Stage.SessionFactory factory = emf.unwrap(Stage.SessionFactory.class);
            factory.withTransaction((session, tx) -> session.persist(new TestEntity())).toCompletableFuture().join();
        }
    }

}


