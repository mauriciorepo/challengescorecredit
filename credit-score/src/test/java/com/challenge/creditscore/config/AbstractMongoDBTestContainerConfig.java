package com.challenge.creditscore.config;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;


public abstract class AbstractMongoDBTestContainerConfig {

    static Integer MONGO_PORT = 27017;




     static final MongoDBContainer MONGO_DB_CONTAINER ;

    static {
        MONGO_DB_CONTAINER = new MongoDBContainer("mongo:latest")
                .withExposedPorts(MONGO_PORT);
        MONGO_DB_CONTAINER.start();

    }

    @DynamicPropertySource
    public static void dynamicPropertySource(DynamicPropertyRegistry registry){
        registry.add("spring.data.mongodb.port", MONGO_DB_CONTAINER::getExposedPorts);
        registry.add("spring.data.mongodb.uri", MONGO_DB_CONTAINER::getReplicaSetUrl);

    }

}
