import com.qbloomy.configuration.HibernateConfiguration;
import com.qbloomy.model.Question;
import com.qbloomy.repository.implementation.QuestionRepositoryImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Semih Okan Pehlivan.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {QuestionRepositoryImp.class, HibernateConfiguration.class})
public class test {

    @Autowired
    QuestionRepositoryImp imp;

    @Test
    public void getAllQuestion() {
            imp.addQuestion(new Question("header","body"));
    }

}
