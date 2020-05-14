package io.acortador.model;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUrls extends CrudRepository<Urls,Long> {

    @Procedure(name = "proc_alta_url")
    String proc_alta_url(@Param("ancho") Integer ancho, @Param("url_larga") String urlLarga);


    @Query(
            value = "SELECT * FROM urls u WHERE u.shortUrl = ?1",
            nativeQuery = true)
    Urls findByShortURL(String someShortURL);


    @Query(value = "SELECT * FROM urls u where u.url = ?1 OR u.shortUrl = ?1",
            nativeQuery = true)
     Urls findByOtherKey(String someUrl);
}
