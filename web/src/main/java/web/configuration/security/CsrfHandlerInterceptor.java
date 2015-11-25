package web.configuration.security;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Semih Okan Pehlivan.
 */
@Component
public class CsrfHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getMethod().equalsIgnoreCase("POST")) {
            return true;
        } else {
//            This method is POST and need to control the csrf token in session and request
            String sessionToken = CsrfTokenManager.getCsrfTokenFromSession(request.getSession());
            String requestToken = CsrfTokenManager.getCsrfTokenFromRequest(request);
            System.out.println("request token:" + requestToken);
            if (requestToken.equals(sessionToken)) {
                return true;
            } else {
                response.sendError(403,"bad or missing csrf token");
                return false;
            }
        }
    }

}
