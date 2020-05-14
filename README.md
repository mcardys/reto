# Reto

_Reto para los interesados de meli_

## Comenzando 🚀

_Simple proyecto springboot_

ejecuta **mvn install** para tener el pryecto funcionando recuerda que el puerto por defecto es el 8080.


### Pre-requisitos 📋

_Java8 y mysql _

```
mvn install
```


_localhost:8080/_

## Ejecutando las pruebas ⚙️

_Queda pendiente la implemnetacion de cucumber para los servicios_

### Analice las pruebas end-to-end 🔩

_los contratos cumplen con los requerimientos_


### Y las pruebas de estilo de codificación ⌨️

_No pasa chequeo de codigo estatico ya que en determinados controllers se utilizan mas de 2 if consecutivos _

```
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
```

## Despliegue 📦

_queda a futuro la creacion del countainer_

## Construido con 🛠️

_Swaggerui_

* [Dropwizard](http://www.editor.swagger.io/) - Para las definiciones de los servicios
* [Maven](https://maven.apache.org/) - Manejador de dependencias


