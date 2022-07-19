package task.models.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
@Entity
@Table(name = "master_service")
@Setter
@Getter
@ToString
public class MasterService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int master_id;
    private int service_id;
}
