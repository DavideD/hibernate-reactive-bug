import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class TestEntity {
    @Id
    @GeneratedValue
    val id:Integer?=null
}
