package web.configuration;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import web.configuration.security.CsrfTokenManager;

/**
 * If we use the thymeleaf action dialect on any template pages, this RequestDataValueProcessor implementation works
 * and perform its <b>vital</b> goal as adding extra hidden field end of the <code>HttpServletRequest</code> body
 * before rendering or redirect. <br>
 *
 * <b>Important note:</b> if you use the thymeleaf, you need to set name of bean name as requestDataValueProcessor
 *
 * @author Semih Okan Pehlivan.
 * @since 0.1
 *
 * @see org.springframework.web.servlet.support.RequestDataValueProcessor
 * @see org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor
 */
@Component(value = "requestDataValueProcessor")
public class CsrfRequestDataValueProcessor implements RequestDataValueProcessor {

    private static Logger logger = LoggerFactory.getLogger(CsrfRequestDataValueProcessor.class.getName());


    @Override
    public String processAction(HttpServletRequest request, String action, String httpMethod) {
        //System.out.println(action);
        //System.out.println(httpMethod);
        return action;
    }

    @Override
    public String processFormFieldValue(HttpServletRequest request, String name, String value, String type) {
        return null;
    }

    @Override
    public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        String csrfTokenValue = CsrfTokenManager.getCsrfTokenFromSession(request.getSession());
//        Generate a csrf token and adding to request body as hidden field
        map.put(CsrfTokenManager.CSRF_TOKEN_NAME_FOR_REQUEST_PARAM, csrfTokenValue);
        logger.info("csrf:" + csrfTokenValue);
        return map;
    }

    @Override
    public String processUrl(HttpServletRequest request, String url) {
        //System.out.println(request.getMethod());
        //System.out.println(request.getContextPath());
        return url;
    }
}
