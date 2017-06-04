import lab.model.Country;
import lab.model.UsualPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";

    private UsualPerson expectedPerson;

    private BeanFactory context;

    @BeforeEach
    void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
        expectedPerson = getExpectedPerson();
    }

    @Test
    void testInitPerson() {
        assertEquals(expectedPerson, context.getBean("person"));
    }

    private UsualPerson getExpectedPerson() {
        return new UsualPerson()
                .setAge(35)
                .setName("John Smith")
                .setCountry(new Country()
                        .setId(1)
                        .setName("Russia")
                        .setCodeName("RU"));
    }
}
