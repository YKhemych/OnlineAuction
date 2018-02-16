package OnlineAuction.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

/**
 * Created by user on 16.02.2018.
 */

public class WebInit implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

//        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
//        servletContext.addFilter("springSecurityFilterChain" , delegatingFilterProxy).addMappingForUrlPatterns(null,false , "/*");

        FilterRegistration charEncodingFilterReg =
                servletContext.
                        addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
        charEncodingFilterReg.setInitParameter("forceEncoding", "true");
        charEncodingFilterReg.addMappingForUrlPatterns(null, false, "/*");

        ServletRegistration.Dynamic registration =
                servletContext
                        .addServlet("dispatcherServlet", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        registration.setMultipartConfig(
                new MultipartConfigElement("", 1000000, 1000000, 1000000)
        );


    }
}
