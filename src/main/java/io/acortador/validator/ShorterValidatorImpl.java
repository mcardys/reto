package io.acortador.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShorterValidatorImpl implements IShorterValidator {
    /*
    * Esta clase aplica ciertas regllas para determinar si la url es valida
    * previo a la interaccion con la base de datos.
    * near estructurado
    * */
    private static final Logger log = LoggerFactory.getLogger(ShorterValidatorImpl.class);
    @Value("${app.longURL}")
    private String longURL;
    @Value("${app.shortURL}")
    private String shortURL;

    @Override
    public Boolean isURLValid(String someURL) {
        log.info("validao los basepaths permitidos " +longURL+ " y " +shortURL);
        Boolean res = false;
       if( someURL.contains(longURL) || someURL.contains(shortURL) ) {
           chequeoLongitud(someURL);
           res = chequeoLongitud(someURL);
        }

        return res;
    }

    private Boolean  chequeoLongitud (String someURL){
            log.info("valido los caracteres ");
            someURL= someURL.replace("http://","");
            someURL = someURL.replace("https://","");
            List<String> strings = Arrays.asList(someURL.split("/"));
            if(strings.size() == 2 && strings.get(1).length()<=128){
                log.info( "ok");
                return true;
            }else{
                log.info( "eror");
                return false;
            }
    }

    public String toWorkerURL(String someUrl){
        someUrl= someUrl.replace("http://","");
        someUrl = someUrl.replace("https://","");
        List<String> strings = Arrays.asList(someUrl.split("/"));
        return  strings.get(1);
    }
}
