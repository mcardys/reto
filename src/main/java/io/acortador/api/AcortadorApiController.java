package io.acortador.api;

import io.acortador.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.acortador.validator.IShorterValidator;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-06T17:21:42.001Z")

@Controller
public class AcortadorApiController implements AcortadorApi {

    private static final Logger log = LoggerFactory.getLogger(AcortadorApiController.class);

    @Autowired
    private IShorterValidator validator;
    @Autowired
    private IUrls urls;

    @Value("${app.length}")
    private Integer ancho;

    @Value("${app.longURL}")
    private String appLongURL;
    @Value("${app.shortURL}")
    private String appShortURL;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AcortadorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<InlineResponse200> alargador(@Size(max=128) @ApiParam(value = "develve full url",required=true)  @Valid @RequestBody Body body) { //@PathVariable("someurl") String someurl) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                 if(validator.isURLValid(body.getUrl())){
                    String someurl = validator.toWorkerURL(body.getUrl());
                     Urls someUrls =  urls.findByShortURL(someurl);
                     if(!someurl.isEmpty()){
                         return new ResponseEntity<InlineResponse200>(objectMapper.readValue("{  \"longUrl\" : \""+appLongURL+"/"+someUrls.getUrl()+"\"}", InlineResponse200.class), HttpStatus.OK);
                     }else{
                         return new ResponseEntity<InlineResponse200>(objectMapper.readValue("{  \"longUrl\" : \"error\"}", InlineResponse200.class), HttpStatus.BAD_REQUEST);
                     }
                 }else{
                     return new ResponseEntity<InlineResponse200>(objectMapper.readValue("{  \"longUrl\" : \"error\"}", InlineResponse200.class), HttpStatus.BAD_REQUEST);
                 }


            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse200>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse200>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse201> ejemplo(@ApiParam(value = "Genera unaurl acortada" ,required=true )  @Valid @RequestBody Body body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                //return new ResponseEntity<InlineResponse201>(objectMapper.readValue("{  \"shortUrl\" : \"me.li/123456\"}", InlineResponse201.class), HttpStatus.OK);
                if(validator.isURLValid(body.getUrl())){
                    String ShortURLResponse = urls.proc_alta_url(ancho,validator.toWorkerURL(body.getUrl()));
                    log.info("resultado:"  +ShortURLResponse);
                     return new ResponseEntity<InlineResponse201>(objectMapper.readValue("{  \"shortUrl\" : \""+appShortURL+"/"+ShortURLResponse+"\"}", InlineResponse201.class), HttpStatus.OK);
                }else{
                    return new ResponseEntity<InlineResponse201>(objectMapper.readValue("{  \"shortUrl\" : \"error\"}", InlineResponse201.class), HttpStatus.BAD_REQUEST);
                }
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse201>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse201>(HttpStatus.NOT_IMPLEMENTED);
    }

    public  ResponseEntity<String> locked (@Valid @RequestBody Body body) {
        String accept = request.getHeader("Accept");
        ResponseEntity<String> defaultBadRequest =new  ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        if (accept != null && accept.contains("application/json")) {
            try {
                if (validator.isURLValid(body.getUrl())) {
                    String someurl = validator.toWorkerURL(body.getUrl());
                    if (!someurl.isEmpty() ) {
                        Urls someUrlsObj =  urls.findByOtherKey(someurl);
                        if(!someUrlsObj.equals(null)){
                            someUrlsObj.setStatus(1);
                            urls.save(someUrlsObj);
                            return new ResponseEntity<>("", HttpStatus.OK);
                        }else{
                            return defaultBadRequest;
                        }

                    } else {
                        return defaultBadRequest;
                    }
                } else {
                    return defaultBadRequest;
                }


            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);

            }
        }
        return new ResponseEntity<>("",HttpStatus.NOT_IMPLEMENTED);
    }

}
