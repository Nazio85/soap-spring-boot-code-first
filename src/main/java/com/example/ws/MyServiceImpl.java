package com.example.ws;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;


@Service
@WebService(serviceName = "PayServer")
public class MyServiceImpl {
    @WebMethod(operationName = "PayServer")
    public String getServiceName() {
        return "This is MyService";
    }
}
