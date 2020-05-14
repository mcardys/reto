package io.acortador.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.acortador.model.Urls;
import io.acortador.service.IProxyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-06T17:21:42.001Z")

@Controller
public class ProxyApiController<res> implements ProxyApi {

    private static final Logger log = LoggerFactory.getLogger(ProxyApiController.class);

   // private final ObjectMapper objectMapper;

   // private final HttpServletRequest request;

    @Autowired
    private IProxyService service;

    /*@org.springframework.beans.factory.annotation.Autowired
    public ProxyApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }*/

    public ResponseEntity<?> proxy() {


          return ResponseEntity.ok().body(service.toProxy());

    }

}
