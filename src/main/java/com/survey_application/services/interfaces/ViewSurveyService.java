package com.survey_application.services.interfaces;

import java.sql.SQLException;

public interface ViewSurveyService {
    int getTotalNumberOfSurveys() throws SQLException;
    double getAverageAge() throws SQLException;
    String getOldPerson() throws SQLException;
    String getYoungPerson() throws SQLException;

    double getPizzaPercentage() throws SQLException;
    double getPastaPercentage() throws SQLException;
    double getPapAndWorsPercentage() throws SQLException;
}
