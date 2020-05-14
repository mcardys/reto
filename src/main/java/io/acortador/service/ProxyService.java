package io.acortador.service;

import io.acortador.model.IUrls;
import io.acortador.model.Urls;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
@Service
public class ProxyService implements IProxyService {
    /*
    * Este metodo genera el archivo de configuracion para un proxy http
    * con formato Redirect "/foo.html" "/bar.html"
    * para las urls anuldas responder 404
    * RewriteRule ^/?page\.html$ - [R=404]
    * */
    /* TODO
    * este sericio se conectara al api gateway, firewall ó similar para da de alta
    * las reglas de redireccion
    * */
    @Autowired
    private IUrls data;

    @Value("${app.longURL}")
    private String longURL;
    @Value("${app.shortURL}")
    private String shortURL;

    public final String URL_DIVIDER = "/";

    @Override
    public String toProxy() {
        String strREsponse = "";
       for (Urls s : data.findAll()){
           if(s.getStatus() == 0){
               strREsponse = strREsponse +
                       "redirect " +shortURL+URL_DIVIDER+s.getShortURL() + " "
                       + longURL+URL_DIVIDER+s.getUrl() + " \n";
           }else{
               strREsponse = strREsponse +
                       "RewriteRule ^/?"+shortURL+URL_DIVIDER+ s.getShortURL()+"$ - [R=404]\n";
           }
       }
       return strREsponse;
    }

    @Override
    public List<Urls> listar() {
        return (List<Urls>)  data.findAll();
    }
}
