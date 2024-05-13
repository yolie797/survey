package com.survey_application.services.implementation;

import com.survey_application.dao.interfaces.ViewSurveyDAO;
import com.survey_application.services.interfaces.ViewSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ViewSurveyServiceImpl implements ViewSurveyService {
    private final ViewSurveyDAO viewSurveyDAO;

    @Autowired
    public ViewSurveyServiceImpl(ViewSurveyDAO viewSurveyDAO) {
        this.viewSurveyDAO = viewSurveyDAO;
    }

    @Override
    public int getTotalNumberOfSurveys() throws SQLException {
        return viewSurveyDAO.getTotalNumberOfSurveys();
    }

    @Override
    public double getAverageAge() throws SQLException {
        return viewSurveyDAO.getAverageAge();
    }

    @Override
    public String getOldPerson() throws SQLException {
        return viewSurveyDAO.getOldPerson();
    }

    @Override
    public String getYoungPerson() throws SQLException {
        return viewSurveyDAO.getYoungPerson();
    }

    @Override
    public double getPizzaPercentage() throws SQLException {

        return viewSurveyDAO.getPizzaPercentage();

    }

    @Override
    public double getPastaPercentage() throws SQLException {
        return viewSurveyDAO.getPastaPercentage();
    }

    @Override
    public double getPapAndWorsPercentage() throws SQLException {
        return viewSurveyDAO.getPapAndWorsPercentage();
    }


}
