package com.qbloomy.repository.implementation;

import com.qbloomy.model.Question;
import com.qbloomy.repository.QuestionRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author Semih Okan Pehlivan.
 */
@Repository("rrr")
@Transactional
public class QuestionRepositoryImp implements QuestionRepository{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addQuestion(Question question) {
        sessionFactory.getCurrentSession().save(question);
    }
}
