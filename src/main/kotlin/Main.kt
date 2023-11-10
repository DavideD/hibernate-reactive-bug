import jakarta.persistence.Persistence
import org.hibernate.reactive.stage.Stage

fun main(args : Array<String>) {
        Persistence.createEntityManagerFactory("reactiveTest")
                .use {
                    it.unwrap(Stage.SessionFactory::class.java)
                            .withTransaction { session -> session.persist(TestEntity()) }
                            .toCompletableFuture().join()
                }
}

