package web.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * Created by semihokan on 07/10/15.
 */
public class ApplicationStartListenerImp implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println(new Date(applicationEvent.getTimestamp()).toString());
    }

}
