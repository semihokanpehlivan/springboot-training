package web.propertyconf;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import otherpackage.OtherBean;

/**
 * @author Semih Okan Pehlivan.
 */
@Component("cs")
@ConfigurationProperties(prefix = "person")
@Profile("db")
public class ConnectionSetting {

    @NotEmpty
    String first;
    String last;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
