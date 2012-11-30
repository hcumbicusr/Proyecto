/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import java.util.List;

public class GalleriaBean {
     private List<ImagenGall> imagenes;

    public GalleriaBean() {
    imagenes = new ArrayList<ImagenGall>();  
  
        imagenes.add(new ImagenGall("med1.jpg", "Clinica San Migel"));  
        imagenes.add(new ImagenGall("med2.jpg", "Clinica San Migel"));  
        imagenes.add(new ImagenGall("med3.jpg", "Clinica San Migel"));  
        imagenes.add(new ImagenGall("med4.jpg", "Clinica San Migel"));  
        imagenes.add(new ImagenGall("med5.jpg", "Clinica San Migel"));  
        imagenes.add(new ImagenGall("med6.jpg", "Clinica San Migel"));  
        imagenes.add(new ImagenGall("med7.jpg", "Clinica San Migel"));  
        imagenes.add(new ImagenGall("med8.jpg", "Clinica San Migel")); 
        imagenes.add(new ImagenGall("logoclinica.png", "Clinica San Migel")); 
    }

    public List<ImagenGall> getImagenes() {
        return imagenes;
    }
   
}
