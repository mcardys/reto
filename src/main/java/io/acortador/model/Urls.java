package io.acortador.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name= "urls")
        @NamedStoredProcedureQuery(name = "proc_alta_url",
                procedureName = "proc_alta_url",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ancho", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "url_larga", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "id_corto", type = String.class)
                })


public class Urls implements Serializable {

    /*
    * id, url, shortURL,status
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "url", nullable = false, unique = true)
    private String url;
    private String ShortURL;
    private int status;



    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getShortURL() {
        return ShortURL;
    }

    public int getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setShortURL(String shortURL) {
        ShortURL = shortURL;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
