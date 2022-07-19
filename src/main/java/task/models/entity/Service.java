package task.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;

//    @ManyToMany(targetEntity = MasterService.class, cascade = { CascadeType.ALL })
//    @JoinTable(name = "master_service",
//            joinColumns = { @JoinColumn(name = "id") },
//            inverseJoinColumns = { @JoinColumn(name = "service_id") })
//    private Set<MasterService> items;

    public static class ServiceBuilder {
        private Service newService;

        public ServiceBuilder() {
            newService = new Service();
        }

        public ServiceBuilder withId(int id) {
            newService.id = id;
            return this;
        }

        public ServiceBuilder withName(String name) {
            newService.name = name;
            return this;
        }

        public ServiceBuilder withPrice(int price) {
            newService.price = price;
            return this;
        }

        public Service build() {
            return newService;
        }
    }
}
