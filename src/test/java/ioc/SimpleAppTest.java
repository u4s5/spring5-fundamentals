package ioc;

import model.simple.SimpleCountry;
import model.simple.SimplePerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleAppTest {

    private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:ioc.xml";

    private AbstractApplicationContext context;

    private SimplePerson expectedPerson;

    @BeforeEach
    void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
        expectedPerson = getExpectedPerson();
    }

    @Test
    void testInitPerson() {
        SimplePerson person = context.getBean("person", SimplePerson.class);
        assertEquals(expectedPerson, person);
    }

    private SimplePerson getExpectedPerson() {
        return new SimplePerson(
                0,
                "John Smith",
                new SimpleCountry(1, "Russia", "RU"),
                35,
                1.78F,
                true,
                Arrays.asList("asd@asd.ru", "+7-234-456-67-89"));
    }
}
