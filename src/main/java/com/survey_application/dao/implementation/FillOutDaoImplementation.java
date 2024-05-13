package com.survey_application.dao.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.survey_application.dao.interfaces.FillOutDao;
import com.survey_application.db.connection.DbConnection;

import com.survey_application.entities.Survey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class FillOutDaoImplementation implements FillOutDao {
    private final Connection connection;
    Logger logger = LoggerFactory.getLogger(FillOutDaoImplementation.class);
    private boolean isDbVisited;
    private ResultSet rs;


    public FillOutDaoImplementation() throws SQLException {
        this.connection = DbConnection.getConnection();
        this.isDbVisited = false;
    }
    @Override
    public void createSurvey(Survey survey) {

        ObjectMapper objectMapper = new ObjectMapper();
        String ratingsJson = null;
        try {
            ratingsJson = objectMapper.writeValueAsString(survey.getRatings());
        } catch (JsonProcessingException e) {
            logger.error("Error converting ratings to JSON: ", e);
            // Handle or rethrow the exception
        }

        String sql = "INSERT INTO public.survey(fullname, email, dateofbirth, contactnumber, favoritefood, ratings) " +
                "VALUES (?, ?, ?, ?, ?, ?::jsonb);";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, survey.getFullName());
            ps.setString(2, survey.getEmail());
            ps.setDate(3, Date.valueOf(survey.getDateOfBirth()));
            ps.setString(4, survey.getContactNumber());
            ps.setString(5, survey.getFavoriteFood());
            ps.setString(6, ratingsJson); // Insert ratings as JSON string
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("An error occurred while saving survey: ", e);
            // Handle or rethrow the exception
        }
    }
}



