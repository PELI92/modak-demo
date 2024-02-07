package modak.peli.demo.modakdemo.notifications.data.access.config;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "modak.peli.demo.*")
public class DataAccessConfiguration extends MongoAutoConfiguration {

}
