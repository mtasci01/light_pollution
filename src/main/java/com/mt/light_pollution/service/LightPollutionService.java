package com.mt.light_pollution.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LightPollutionService {

    @Autowired
    @Qualifier("mtLightPollutionMongoTemplate")
    private MongoTemplate mongoTemplate;
    public String run(){
        return "HELLLLLLPPP";
    }
}
