package web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.standard.fragment.StandardDOMSelectorFragmentSpec;

/**
 * @author Semih Okan Pehlivan.
 */
@Configuration
public class ThymeleafViewDOMConfiguration extends ThymeleafView{

//    @Bean(name = "content-frag")
//    public ThymeleafView thymeleafView() {
//        ThymeleafView thymeleafView = new ThymeleafView();
//        thymeleafView.setTemplateName("content");
//        thymeleafView.setFragmentSpec(standardDOMSelectorFragmentSpec());
//        return thymeleafView;
//    }

    @Bean
    public StandardDOMSelectorFragmentSpec standardDOMSelectorFragmentSpec() {
        StandardDOMSelectorFragmentSpec standardDOMSelectorFragmentSpec =
                new StandardDOMSelectorFragmentSpec("content");
        return standardDOMSelectorFragmentSpec;
    }

}
