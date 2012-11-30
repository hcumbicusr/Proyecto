/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

public class ImagenGall {
    private String nombre_archivo;
    private String descripcion;

    public ImagenGall(String nombre_archivo, String descripcion) {
        this.nombre_archivo = nombre_archivo;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }
}    
