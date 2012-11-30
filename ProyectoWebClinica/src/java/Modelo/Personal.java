
package Modelo;

import java.util.Date;

public class Personal {
    
    private String cod_personal;
    private String nombres;
    private String apellidos;
    private String sexo;
    private Date fecha_nacimiento;
    private String fecha_nacimiento2;
    private TipoPersonal obj_tpe=new TipoPersonal();
    private String dni_personal;
    private Usuario obj_use=new Usuario();
    private int estado;

    public Personal() {
    }

    public String getFecha_nacimiento2() {
        return fecha_nacimiento2;
    }

    public void setFecha_nacimiento2(String fecha_nacimiento2) {
        this.fecha_nacimiento2 = fecha_nacimiento2;
    }

    public String getCod_personal() {
        return cod_personal;
    }

    public void setCod_personal(String cod_personal) {
        this.cod_personal = cod_personal;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public TipoPersonal getObj_tpe() {
        return obj_tpe;
    }

    public void setObj_tpe(TipoPersonal obj_tpe) {
        this.obj_tpe = obj_tpe;
    }

    public String getDni_personal() {
        return dni_personal;
    }

    public void setDni_personal(String dni_personal) {
        this.dni_personal = dni_personal;
    }

    public Usuario getObj_use() {
        return obj_use;
    }

    public void setObj_use(Usuario obj_use) {
        this.obj_use = obj_use;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
