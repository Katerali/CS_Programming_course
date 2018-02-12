package ua.ucu.edu.sparkcourse.udf.validator;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ua.ucu.edu.sparkcourse.Conf;
import ua.ucu.edu.sparkcourse.evaluate.Context;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Conf.class)
public class EventCodeValidatorUDFTest {

    @Autowired
    private EventCodeValidatorUDF validator;

    private Map<Integer, String> events;

    @Before
    public void setUp(){
        events = new HashMap<>();
        validator.setContext(createContext(events));
    }

    @Test
    public void testHasCode() {
        events.put(1, "event1");
        events.put(2, "event2");

        assertTrue(validator.hasCode(1));
        assertTrue(validator.hasCode(2));
        assertFalse(validator.hasCode(3));
        assertFalse(validator.hasCode(4));
    }

    @Test
    public void testIsMultiplePlayerRequires() {
        assertFalse(validator.isMultiplePlayerRequires(1));
        assertFalse(validator.isMultiplePlayerRequires(2));
        assertTrue(validator.isMultiplePlayerRequires(3));
        assertTrue(validator.isMultiplePlayerRequires(4));
    }

    @Test
    public void testErrorEventCode() throws Exception {
        events.put(1, "event1");
        events.put(4, "event2");

        assertTrue(validator.call(1));
        assertTrue(validator.call(2));
        assertTrue(validator.call(3));
        assertFalse(validator.call(4));
    }

    private Context createContext(Map<Integer, String> events) {
        Context context = new Context();
        context.setEvents(events);
        return context;
    }
}
