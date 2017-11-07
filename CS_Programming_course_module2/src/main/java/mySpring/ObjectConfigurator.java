package mySpring;

import java.lang.reflect.Field;

public interface ObjectConfigurator {
    <T> void configureFields(T o);
}
