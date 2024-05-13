package com.survey_application.controllers;

import com.survey_application.services.interfaces.ViewSurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
@CrossOrigin
public class ViewSurveyResultsController {
    private final Logger logger = LoggerFactory.getLogger(FillOutSurveyController.class);
    private final ViewSurveyService viewSurveyService;

    @Autowired
    public ViewSurveyResultsController(ViewSurveyService viewSurveyService) {
        this.viewSurveyService = viewSurveyService;
    }

    @GetMapping("/viewSurvey")
    public String showSurveyForm() {
        logger.info("Displaying viewSurvey form");
        return "viewSurvey";
    }

    @GetMapping("/getTotalSurvey")
    public ResponseEntity<Integer> getTotalNumberOfSurveys() {
        try {
            int totalSurveys = viewSurveyService.getTotalNumberOfSurveys();
            return ResponseEntity.ok(totalSurveys);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/getAverageAge")
    public ResponseEntity<Double> getAverageAge() {
        try {
            double averageAge = viewSurveyService.getAverageAge();
            return ResponseEntity.ok(averageAge);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getOldPerson")
    public ResponseEntity<String> getOldPerson() {
        try {
            String oldPerson = viewSurveyService.getOldPerson();
            return ResponseEntity.ok(oldPerson);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getYoungPerson")
    public ResponseEntity<String> getYoungPerson() {
        try {
            String youngPerson = viewSurveyService.getYoungPerson();
            return ResponseEntity.ok(youngPerson);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getPizzaPercentage")
    public ResponseEntity<Double> getPizzaPercentage() {
        try {
            double pizzaPercentage = viewSurveyService.getPizzaPercentage();
            return ResponseEntity.ok(pizzaPercentage);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getPastaPercentage")
    public ResponseEntity<Double> getPastaPercentage() {
        try {
            double pastaPercentage = viewSurveyService.getPastaPercentage();
            return ResponseEntity.ok(pastaPercentage);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getPapAndWorsPercentage")
    public ResponseEntity<Double> getPapAndWorsPercentage() {
        try {
            double papAndWorsPercentage = viewSurveyService.getPapAndWorsPercentage();
            return ResponseEntity.ok(papAndWorsPercentage);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
