package com.cloud.endUser.config;

import com.cloud.endUser.constants.Appconstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    private Logger logger = LoggerFactory.getLogger(KafkaConfig.class);

    @KafkaListener(topics = Appconstants.LOCATION_UPDATE_TOPIC, groupId = Appconstants.GROUP_ID)
    public boolean updatedLocation(String location){
    logger.info("----------------"+location+"----------------");
    return true;
    }
}
