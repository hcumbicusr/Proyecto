/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensaje {
    public Mensaje() {
        super();
    }
    public static void manejarError( Exception e )
    {
     String msg = "La operación no se puedo realizar, Motivo" + e.getMessage();
    FacesContext context = FacesContext.getCurrentInstance( );
    context.addMessage( null, new FacesMessage( msg ) );
    }
    public static void manejarError(String metodo )
    {
        String msg = "La operación: " + metodo + " No se puedo realizar";
    FacesContext context = FacesContext.getCurrentInstance( );
    context.addMessage( null, new FacesMessage( msg ) );
    }
    public static void guardarMensajeExito( String metodo )
    {
    String msg = "La operación: " + metodo + " se ha realizado con éxito";
    FacesContext context = FacesContext.getCurrentInstance( );
    context.addMessage( null, new FacesMessage( msg ) );
    }
    public static void addMensajeInfo(String mensaje){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(mensaje);
    //    message.setSeverity(FacesMessage.SEVERITY_INFO);        
      //  message.setDetail(mensaje);
        context.addMessage(null,message);

}
    public static void addMensajeFatal(String mensaje){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_FATAL);
        //message.setSummary("Name Field is Blank");
        message.setDetail(mensaje);
        context.addMessage(null,message);
    }
    public static void addMensajeWarn(String mensaje){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_WARN);
        //message.setSummary("Name Field is Blank");
        message.setDetail(mensaje);
        context.addMessage(null,message);
    }
public static void addMensajeError(String mensaje){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        //message.setSummary("Name Field is Blank");
        message.setDetail(mensaje);
        context.addMessage(null,message);

    }

}
