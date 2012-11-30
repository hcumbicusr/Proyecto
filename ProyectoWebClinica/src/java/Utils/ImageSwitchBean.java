package Utils;

import java.util.ArrayList;  
import java.util.List;  
  
public class ImageSwitchBean {  
  
    private List<String> images;  
  
    public ImageSwitchBean() {  
            }  
    public List<String> getImagesEmpresa() {  
        images = new ArrayList<String>();  
        images.add("entidades-financieras01.jpg");  
        images.add("entidades-financieras02.jpg");  
        images.add("entidades-financieras03.jpg");  
        images.add("entidades-financieras04.jpg");  
        images.add("entidades-financieras05.jpg");  
        return images;  
    }  
}  