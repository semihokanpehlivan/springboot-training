package web.configuration;

/**
 * @author Semih Okan Pehlivan.
 */

    // did not instantiate the org.thymeleaf.spring4.view.ThymeleafView bean because its constructor is protected
    // but not work bean fragment again
public class ThymeleafView extends org.thymeleaf.spring4.view.ThymeleafView {
}
