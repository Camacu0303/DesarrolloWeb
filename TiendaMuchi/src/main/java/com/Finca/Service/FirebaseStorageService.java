
package com.Finca.Service;

import org.springframework.web.multipart.MultipartFile;


public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    //El BuketName es el <id_del_proyecto> + ".appspot.com"F
    final String BucketName = "fincamuchi.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "fincamuchi";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "Firebase";

    //El nombre del archivo Json
    final String archivoJsonFile = "fincamuchi-firebase-adminsdk-c2ges-7ab06f8b4b.json";
}
