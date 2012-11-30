/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Usuario {
    
    private int num_user;
    private String nombre_usuario;
    private String clave;
    private String clave2;
    private Tipo obj_tip=new Tipo();
    private int tipo_user;
    private int cod_tipo_personal;
    private String descripcion;
    private String personal;

    public Usuario() {
    }

    public int getNum_user() {
        return num_user;
    }

    public void setNum_user(int num_user) {
        this.num_user = num_user;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


    public Tipo getObj_tip() {
        return obj_tip;
    }

    public void setObj_tip(Tipo obj_tip) {
        this.obj_tip = obj_tip;
    }
    

    public int getCod_tipo_personal() {
        return cod_tipo_personal;
    }

    public void setCod_tipo_personal(int cod_tipo_personal) {
        this.cod_tipo_personal = cod_tipo_personal;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public int getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(int tipo_user) {
        this.tipo_user = tipo_user;
    }

    public String getClave2() {
        return clave2;
    }

    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

   
    
}
