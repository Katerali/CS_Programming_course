package ua.ucu.edu.sparkcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ucu.edu.sparkcourse.evaluate.DataEvaluatorImpl;

public class SparkApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ua.ucu.edu.sparkcourse.Conf.class);

        DataEvaluatorImpl dataEvaluator = context.getBean(DataEvaluatorImpl.class);
        dataEvaluator.evaluate();
    }
}

