package web.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by Ufuk on 14-10-15.
 */
@Component
public class DateFormatter implements Formatter<Date> {

    @Autowired
    MessageSource messageSource;

    Logger logger = Logger.getLogger(DateFormatter.class.getName());

    public DateFormatter() {
        super();
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        logger.info("inside the DateFormatter.parse();");
        final SimpleDateFormat dateFormat = createDateFormat(locale);
        return dateFormat.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        final SimpleDateFormat dateFormat = createDateFormat(locale);
        return dateFormat.format(object);
    }

    private SimpleDateFormat createDateFormat(final Locale locale) {
        final String format = this.messageSource.getMessage("date.format", null, locale);
        final SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat;
    }

}
