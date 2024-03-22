package org.ectimel.dietgenerator.infrastructure.persistance.mongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories")
public class MongoDBConfiguration {
}
