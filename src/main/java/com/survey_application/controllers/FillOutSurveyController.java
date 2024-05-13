package com.survey_application.controllers;

import com.survey_application.entities.Survey;
import com.survey_application.services.interfaces.FillOutSurveyService;
import com.survey_application.services.interfaces.ViewSurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@CrossOrigin
public class FillOutSurveyController {
    private final Logger logger = LoggerFactory.getLogger(FillOutSurveyController.class);
    private final FillOutSurveyService fillOutSurveyService;
    private final ViewSurveyService viewSurveyService;

    @Autowired
    public FillOutSurveyController(FillOutSurveyService fillOutSurveyService, ViewSurveyService viewSurveyService) {
        this.fillOutSurveyService = fillOutSurveyService;
        this.viewSurveyService = viewSurveyService;
    }

    @GetMapping("/fillOutSurvey")
    public String showSurveyForm() {
        logger.info("Displaying fillOutSurvey form");
        return "fillOutSurvey";
    }

    @PostMapping("/submitSurvey")
    public ResponseEntity<String> submitSurveyForm(@RequestBody Survey survey) {
        logger.info("Saving survey: " + survey);
        try {
            fillOutSurveyService.createSurvey(survey);
        } catch (Exception e) {
            logger.error("Error saving survey: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error saving survey: " + e.getMessage());
        }
        return ResponseEntity.ok("Thank you for your feedback!");
    }



}

