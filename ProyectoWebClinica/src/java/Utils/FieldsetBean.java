/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.ToggleEvent;


@ManagedBean
@RequestScoped
public class FieldsetBean {

     public void handleToggle(ToggleEvent event) {  
        /*FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Vavula", "Visibility:" + event.getVisibility());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  */
    }  
    public FieldsetBean() {
    }
}
