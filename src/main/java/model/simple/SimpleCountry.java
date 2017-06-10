package model.simple;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

@Value
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SimpleCountry implements model.Country {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String codeName;
}
