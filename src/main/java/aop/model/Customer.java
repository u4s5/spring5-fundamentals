package aop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import model.Country;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Customer implements Person {
    private int id;
    private String name;
    private boolean broke;
    private Country country;

    private int age;
    private float height;
    private boolean isProgrammer;

    private List<String> contacts;

    @Override
    public void sayHello(Person person) {
        throw new UnsupportedOperationException();
    }
}
