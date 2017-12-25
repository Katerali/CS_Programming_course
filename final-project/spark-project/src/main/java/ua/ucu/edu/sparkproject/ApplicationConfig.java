package ua.ucu.edu.sparkproject;


import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ApplicationConfig {

    @Bean
    public JavaSparkContext javaSparkContext() {
        return new JavaSparkContext(sparkSession().sparkContext());
    }

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
                .builder()
                .appName("Spark-basics")
                .master("local[*]")
                .getOrCreate();
    }

    @Bean(name = "codesProperties")
    public PropertiesFactoryBean codesProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("data/codes.properties"));
        return bean;
    }

    @Bean(name = "footballColumnsProperties")
    public PropertiesFactoryBean footballColumnsProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("data/football_columns.properties"));
        return bean;
    }

    @Bean(name = "teamsProperties")
    public PropertiesFactoryBean teamsProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("data/teams.properties"));
        return bean;
    }
}
