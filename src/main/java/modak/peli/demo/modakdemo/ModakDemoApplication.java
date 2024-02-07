package modak.peli.demo.modakdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class ModakDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ModakDemoApplication.class, args);
    }

}
