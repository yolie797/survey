package com.survey_application.services.implementation;

import com.survey_application.dao.interfaces.FillOutDao;
import com.survey_application.entities.Survey;
import com.survey_application.services.interfaces.FillOutSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FillOutSurveyServiceImpl implements FillOutSurveyService {

    private final FillOutDao fillOutDao;

    @Autowired
    public FillOutSurveyServiceImpl(final FillOutDao fillOutDao) {
        this.fillOutDao = fillOutDao;
    }


    @Override
    public void createSurvey(Survey survey) {
        fillOutDao.createSurvey(survey);
    }

}
