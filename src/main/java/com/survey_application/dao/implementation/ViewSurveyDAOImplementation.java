package com.survey_application.dao.implementation;

import com.survey_application.dao.interfaces.ViewSurveyDAO;
import com.survey_application.db.connection.DbConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ViewSurveyDAOImplementation implements ViewSurveyDAO {
    private final Connection connection;
    Logger logger = LoggerFactory.getLogger(FillOutDaoImplementation.class);
    private boolean isDbVisited;
    private ResultSet rs;

    public ViewSurveyDAOImplementation() throws SQLException {
        this.connection = DbConnection.getConnection();
        this.isDbVisited = false;
    }

    @Override
    public int getTotalNumberOfSurveys() throws SQLException {
        logger.info("Getting total number of surveys");
        String sql = "SELECT COUNT(*) FROM public.survey";
        PreparedStatement ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        int totalSurveys = 0;
        while (rs.next()) {
            totalSurveys = rs.getInt(1);
        }
        logger.info("Total number of surveys: " + totalSurveys);
        return totalSurveys;
    }

    @Override
    public double getAverageAge() throws SQLException {
        logger.info("Getting average age");
        String query = "SELECT AVG(EXTRACT(YEAR FROM AGE(NOW(), dateofbirth))) FROM public.survey";
        PreparedStatement statement = connection.prepareStatement(query);
        rs = statement.executeQuery();
        double avgAge = 0;
        while (rs.next()) {
            avgAge = rs.getDouble(1);
        }
        logger.info("Average age: " + avgAge);
        return avgAge;
    }



    @Override
    public String getOldPerson() throws SQLException {
        logger.info("Getting old person");
        String query = "SELECT fullname FROM survey ORDER BY dateofbirth ASC LIMIT 1";
     PreparedStatement statement = connection.prepareStatement(query);
        rs = statement.executeQuery();
        String oldPerson = "";
        while (rs.next()) {
            oldPerson = rs.getString(1);
        }
        logger.info("Old person: " + oldPerson);
        return oldPerson;
    }

    @Override
    public String getYoungPerson() throws SQLException {
        logger.info("Getting young person");
        String query = "SELECT fullname FROM survey ORDER BY dateofbirth DESC LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(query);
        rs = statement.executeQuery();
        String youngPerson = "";
        while (rs.next()) {
            youngPerson = rs.getString(1);
        }
        logger.info("Young person: " + youngPerson);
        return youngPerson;
    }

    @Override
    public double getPizzaPercentage() throws SQLException {
        String sql = "SELECT COUNT(favoritefood) FROM public.survey WHERE favoritefood LIKE '%pizza%'";
        PreparedStatement ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();

        double pizzaCount = 0;
        double totalSurveys = getTotalNumberOfSurveys();

        while (rs.next()) {
            pizzaCount = rs.getDouble(1);
        }

        double pizzaPercentage = pizzaCount * 100.0 / totalSurveys;
        logger.info("Pizza percentage: " + pizzaPercentage);
        return pizzaPercentage;
    }


    @Override
    public double getPastaPercentage() throws SQLException {
        logger.info("Getting pasta percentage");
        String sql = "SELECT COUNT(favoritefood) FROM public.survey WHERE favoritefood LIKE '%pasta%'";
        PreparedStatement ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();

        double pastaCount = 0;
        double totalSurveys = getTotalNumberOfSurveys();

        while (rs.next()) {
            pastaCount = rs.getDouble(1);
        }
        double pastaPercentage = pastaCount * 100.0 / totalSurveys;
        logger.info("Pasta percentage: " + pastaPercentage);
        return pastaPercentage;
    }

    @Override
    public double getPapAndWorsPercentage() throws SQLException {
        String sql = "SELECT COUNT(favoritefood) FROM public.survey WHERE favoritefood LIKE '%papandwors%'";
        PreparedStatement ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        double papAndWorsPercentage = 0;
        while (rs.next()) {
            papAndWorsPercentage = rs.getDouble(1);
        }
        logger.info("Pap and wors percentage: " + papAndWorsPercentage);
        return papAndWorsPercentage;
    }



}
