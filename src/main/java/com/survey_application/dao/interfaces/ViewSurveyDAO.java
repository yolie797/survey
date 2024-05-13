package com.survey_application.dao.interfaces;

import java.sql.SQLException;

public interface ViewSurveyDAO {
    int getTotalNumberOfSurveys() throws SQLException;
    double getAverageAge() throws SQLException;
    String getOldPerson() throws SQLException;
    String getYoungPerson() throws SQLException;

    double getPizzaPercentage() throws SQLException;
    double getPastaPercentage() throws SQLException;
    double getPapAndWorsPercentage() throws SQLException;
}
