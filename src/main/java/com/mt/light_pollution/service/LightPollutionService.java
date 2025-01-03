package com.mt.light_pollution.service;

import com.mt.light_pollution.model.ReportDTO;
import com.mt.light_pollution.model.ReportDoc;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LightPollutionService {

    @Qualifier("mtLightPollutionMongoTemplate")
    private final MongoTemplate mongoTemplate;
    ModelMapper modelMapper;
    @PostConstruct
    private void setUp(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }


    public String insertReports(List<ReportDTO> reportDTOs){
        List<ReportDoc> docs =new ArrayList<>();
        for (ReportDTO dto : reportDTOs) {
            ReportDoc doc = modelMapper.map(dto, ReportDoc.class);
            doc.setCreatedAt(Instant.now().toEpochMilli());
            doc.setFixedAt(null);
            if (doc.getSeverity() > 5 || doc.getSeverity() < 0) throw new IllegalArgumentException("Severity must be between 0 and 5");
            docs.add(doc);
        }

        mongoTemplate.insertAll(docs);

        return "Added " + reportDTOs.size() + " reports";
    }

    public List<ReportDTO> getReports(){
        List<ReportDoc> docs = mongoTemplate.findAll(ReportDoc.class);
        List<ReportDTO> dtos = new ArrayList<>();
        for (ReportDoc doc : docs) {
            ReportDTO dto = modelMapper.map(doc, ReportDTO.class);
            dto.setMongoId(doc.getId().toHexString());
            dtos.add(dto);
        }

        return dtos;
    }

}
