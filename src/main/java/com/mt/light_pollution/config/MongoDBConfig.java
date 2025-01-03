package com.mt.light_pollution.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
@EnableConfigurationProperties
public class MongoDBConfig {



    //String connString = "mongodb://localhost:27017/mt_light_pollution?authSource=admin";
    @Value("${spring.data.mongodb.uri}")
    String connString;


    @Bean(name = "mtLightPollutionMongoDatabaseFactory")
    @Primary
    public MongoDatabaseFactory mtLightPollutionMongoDatabaseFactory() throws Exception {
        return new SimpleMongoClientDatabaseFactory(connString);
    }

    @Bean(name = "mtLightPollutionMongoConverter")
    public MappingMongoConverter mtLightPollutionMongoConverter(@Qualifier("mtLightPollutionMongoDatabaseFactory") MongoDatabaseFactory mongoDatabaseFactory) throws Exception {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDatabaseFactory);
        MongoMappingContext mongoMappingContext = new MongoMappingContext();
        MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
        mongoConverter.setMapKeyDotReplacement(".");
        return mongoConverter;
    }


    @Bean(name = "mtLightPollutionMongoTemplate")
    public MongoTemplate mtLightPollutionMongoTemplate(@Qualifier("mtLightPollutionMongoDatabaseFactory") MongoDatabaseFactory mongoDatabaseFactory,
                                                 @Qualifier("mtLightPollutionMongoConverter" ) MappingMongoConverter mongoConverter) throws Exception {
        return new MongoTemplate(mongoDatabaseFactory,mongoConverter);
    }


}
