package web.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author Semih Okan Pehlivan.
 */
@Component
public class RequestListener implements ServletRequestListener {

    /**
     * The request is about to go out of scope of the web application.
     *
     * @param sre Information about the request
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    /**
     * The request is about to come into scope of the web application.
     *
     * @param sre Information about the request
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println(sre.getServletRequest().getServerName());
    }
}
