package web.configuration.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Controlling and generating CSRF token which is used in current <code>HttpSession</code> or
 * <code>HttpServletRequest</code>
 *
 * @author Semih Okan Pehlivan.
 * @since 0.1
 */
public class CsrfTokenManager {

    /**
     * Param name on request
     */
    public static String CSRF_TOKEN_NAME_FOR_REQUEST_PARAM = "csrf_token_for_request_param";

    /**
     * Attr name on session
     */
    public static String CSRF_TOKEN_NAME_FOR_SESSION_ATTR = "csrf_token_for_session_attr";

    /**
     * Generating the new token if there is no <code>HttpSession</code> or getting csrf token value
     * that is set in current <code>HttpSession</code> attribute.
     *
     * @param session current <code>HttpSession</code>
     * @return new or current token that set in current session
     * @see #getCsrfTokenFromRequest(HttpServletRequest)
     * */
    public static String getCsrfTokenFromSession(HttpSession session) {
        String token = (String)session.getAttribute(CSRF_TOKEN_NAME_FOR_SESSION_ATTR);

        if (token == null) {
            token = UUID.randomUUID().toString();
            synchronized (session) {
                session.setAttribute(CSRF_TOKEN_NAME_FOR_SESSION_ATTR, token);
            }
            return token;
        }
        return token;
    }

    /**
     * Getting csrf token from <code>HttpServletRequest</code> parameter is CSRF_TOKEN_NAME_FOR_REQUEST_PARAM
     *
     * @param request that sent from user and use the csrf token in body
     * @return csrf token from <code>HttpServletRequest</code>
     * @see #getCsrfTokenFromSession(HttpSession)
     * @see #CSRF_TOKEN_NAME_FOR_REQUEST_PARAM
     */
    public static String getCsrfTokenFromRequest(HttpServletRequest request) {
        return request.getParameter(CSRF_TOKEN_NAME_FOR_REQUEST_PARAM);
    }

    public CsrfTokenManager() {
    }
}
