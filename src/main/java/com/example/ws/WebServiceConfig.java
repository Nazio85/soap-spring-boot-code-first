package com.example.ws;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import javax.xml.ws.Endpoint;


@Configuration
public class WebServiceConfig {
    @Bean
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new CXFServlet(), "/PayServ/*");
    }

    @DependsOn("servletRegistrationBean")
    @Bean
    public Endpoint jaxwsEndpoint(MyServiceImpl subscriberApi){
        javax.xml.ws.Endpoint jaxwsEndpoint =
                javax.xml.ws.Endpoint.publish("/PayServer", subscriberApi);
        return jaxwsEndpoint;
    }

//    @Bean
//    public MyServiceImpl subscriberApi() {
//        return new MyServiceImpl();
//    }
//
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        CXFServlet cxfServlet = new CXFServlet();
//
//        ServletRegistrationBean servletRegistrationBean =
//                new ServletRegistrationBean(cxfServlet, "/api/*");
//        servletRegistrationBean.setLoadOnStartup(1);
//        return servletRegistrationBean;
//    }
//
//    @DependsOn("servletRegistrationBean")
//    @Bean
//    public Endpoint jaxwsEndpoint(MyServiceImpl subscriberApi){
//        javax.xml.ws.Endpoint jaxwsEndpoint =
//                javax.xml.ws.Endpoint.publish("/SubscriberApi", subscriberApi);
//        return jaxwsEndpoint;
//    }
}
