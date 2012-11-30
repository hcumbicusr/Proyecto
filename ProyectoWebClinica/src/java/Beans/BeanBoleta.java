/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Modelo.Boleta;
import Modelo.ControladorBD;
import Modelo.Paciente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;


/**
 *
 * @author JOSEF
 */
public class BeanBoleta {
    
   Boleta boleta_a = new Boleta();
   private PieChartModel pieModel;
   private CartesianChartModel categoryModel;
   private PieChartModel pieModel2;
   private CartesianChartModel categoryModel2;
   private ArrayList<Boleta> arreglo=new ArrayList<Boleta>();
   private ArrayList<Boleta> arreglo2=new ArrayList<Boleta>();
   private ArrayList<Boleta> arreglo3=new ArrayList<Boleta>();
   private ArrayList<Boleta> arreglo4=new ArrayList<Boleta>();
   private String parametro;
   private String tipo;

    public BeanBoleta() {
    }

    public ArrayList<Boleta> getArreglo2() {
        return arreglo2;
    }

    public void setArreglo2(ArrayList<Boleta> arreglo2) {
        this.arreglo2 = arreglo2;
    }

    public ArrayList<Boleta> getArreglo3() {
        return arreglo3;
    }

    public void setArreglo3(ArrayList<Boleta> arreglo3) {
        this.arreglo3 = arreglo3;
    }

    public ArrayList<Boleta> getArreglo4() {
        return arreglo4;
    }

    public void setArreglo4(ArrayList<Boleta> arreglo4) {
        this.arreglo4 = arreglo4;
    }

    
    
    public Boleta getBoleta_a() {
        return boleta_a;
    }

    public void setBoleta_a(Boleta boleta_a) {
        this.boleta_a = boleta_a;
    }

    public ArrayList<Boleta> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Boleta> arreglo) {
        this.arreglo = arreglo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    
     public boolean RegistrarPago(){
        boolean a=false;  
        Connection conexion=null;
        try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st=  conexion.prepareCall("{call sp_registrarpago" + "(?,?,?)}");
            st.setString(1,boleta_a.getCod_boleta());
            if(boleta_a.getFecha() != null)                 
                st.setDate(2,new java.sql.Date(boleta_a.getFecha().getTime()));                   
            else
                 st.setDate(2,null);
            st.setDouble(3,boleta_a.getMonto());
            st.execute();
            if(boleta_a.getCod_boleta()!= null)
                a= true;
            st.close();
            conexion.close();
        }catch(Exception error){
        System.out.println("Error en el metodo por: " + error.getMessage());
        error.printStackTrace();
        }    
        return a;
    }
    
    
     public ArrayList<Boleta> getCargarPagos(){         
        if (arreglo.size()==0){         
           Boleta obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_listarpagos()}");    
            rs = st.executeQuery();        
            if (rs.next()){        
       
            do{
                obj =new Boleta();
                obj.setCod_boleta(rs.getString("cod_boleta"));
                obj.setFecha(rs.getDate("fecha"));
                obj.setMonto(rs.getDouble("monto"));
                arreglo.add(obj);
           } while (rs.next());
         }  
         rs.close();
         st.close();
         conexion.close();

        }catch(Exception error){
        System.out.println("Error en el metodo por: " +error.getMessage());
                error.printStackTrace();
        }    
      }  
    return this.arreglo;
    }

     
     public ArrayList<Boleta> getCargarPagos_Consultas(){         
        if (arreglo.size()==0){         
           Boleta obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_listarpagos_consultas()}");    
            rs = st.executeQuery();        
            if (rs.next()){        
       
            do{
                Paciente p1=new Paciente();
                p1.setNombres(rs.getString("nombres"));
                p1.setApellidos(rs.getString("apellidos"));
                obj =new Boleta();
                obj.setCod_boleta(rs.getString("cod_boleta"));
                obj.setFecha(rs.getDate("fecha"));
                obj.setMonto(rs.getDouble("monto"));
                arreglo.add(obj);
           } while (rs.next());
         }  
         rs.close();
         st.close();
         conexion.close();

        }catch(Exception error){
        System.out.println("Error en el metodo por: " +error.getMessage());
                error.printStackTrace();
        }    
      }  
    return this.arreglo;
    }
     
     
       public ArrayList<Boleta> getCargarPagos_Examenes(){         
        if (arreglo.size()==0){         
           Boleta obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_listarpagos_examenes()}");    
            rs = st.executeQuery();        
            if (rs.next()){        
       
            do{
                Paciente p1=new Paciente();
                p1.setNombres(rs.getString("nombres"));
                p1.setApellidos(rs.getString("apellidos"));
                obj =new Boleta();
                obj.setCod_boleta(rs.getString("cod_boleta"));
                obj.setFecha(rs.getDate("fecha"));
                obj.setMonto(rs.getDouble("monto"));
                arreglo.add(obj);
           } while (rs.next());
         }  
         rs.close();
         st.close();
         conexion.close();

        }catch(Exception error){
        System.out.println("Error en el metodo por: " +error.getMessage());
                error.printStackTrace();
        }    
      }  
    return this.arreglo;
    }
   //-----------------------REPORTE PAGO 1-----------------------------
   //------------------------------------------------------------------
        public ArrayList<Boleta>getCargarPagoExamenDia(){         
        if (arreglo.size()==0){         
           Boleta obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_pago_dia()}");    
            rs = st.executeQuery();        
            if (rs.next()){ 
            do{
                obj =new Boleta();
                obj.setCodigo(rs.getString("h1"));
                if(obj.getCodigo().equals("0001")){
                    obj.setTipo("Boleta Vallejo");
                }else{
                    obj.setTipo("Boleta San Antonio");
                }
                obj.setBoleta(rs.getInt("cant"));
                obj.setExamen(rs.getInt("n"));
                obj.setMonto(rs.getDouble("monto"));
                arreglo.add(obj);
           } while (rs.next());
         }  
         rs.close();
         st.close();
         conexion.close();

        }catch(Exception error){
        System.out.println("Error en el metodo por: " +error.getMessage());
                error.printStackTrace();
        }    
      }  
    return this.arreglo;
    }
        public PieChartModel createPieModelPagoExamenDia() {
        ArrayList<Boleta> arr=getCargarPagoExamenDia();
        
        pieModel = new PieChartModel(); 
        if (arr==null){       
             // this.getBuscarPagosFecha();
            pieModel.set("No hay Valores",0);
         }
        else{
            try{        
            for(int i=0; i<arr.size();i++){  
                    
                    pieModel.set(arr.get(i).getTipo(), arr.get(i).getMonto());              
            }  
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());         
                }    
        }
     return this.pieModel;   
    } 
        
      public CartesianChartModel createBarModelPagoExamenDia() {  
       ArrayList<Boleta> arr=getCargarPagoExamenDia();
       categoryModel = new CartesianChartModel();   
        ChartSeries series = new ChartSeries();         
        Connection conexion = null; 
       if (arr==null){       
           series.setLabel("No hay valores");   
           series.set("No hay valores",0); 
         }
       else{
           try{
            series.setLabel("Series de Boletas"); 
            for(int i=0; i<arr.size();i++){                                       
                    series.set(arr.get(i).getTipo(), arr.get(i).getMonto());              
            }
 
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());
                        error.printStackTrace();
                }
        }
        categoryModel.addSeries(series);
     return categoryModel;   
    } 
        //------------------------FIN-REPORTE PAGO1-----------------------------
        //----------------------------------------------------------------------------
      
      
        //------------------------REPORTE PAGO 2--------------------------
      //--------------------------------------------------------------------
        public ArrayList<Boleta> getCargarPagoConsultaDia(){         
        if (arreglo2.size()==0){         
           Boleta obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_pago_diacons()}");    
            rs = st.executeQuery();        
            if (rs.next()){ 
            do{
                obj =new Boleta();
                obj.setCodigo(rs.getString("h1"));
                if(obj.getCodigo().equals("0001")){
                    obj.setTipo("Boleta Vallejo");
                }else{
                    obj.setTipo("Boleta San Antonio");
                }
                obj.setBoleta(rs.getInt("cant"));
                obj.setExamen(rs.getInt("n"));
                obj.setMonto(rs.getDouble("monto"));
                arreglo2.add(obj);
           } while (rs.next());
         }  
         rs.close();
         st.close();
         conexion.close();

        }catch(Exception error){
        System.out.println("Error en el metodo por: " +error.getMessage());
                error.printStackTrace();
        }    
      }  
    return this.arreglo2;
    }
        
        
       public PieChartModel createPieModelPagoConsultaDia() {
        ArrayList<Boleta> arre2=getCargarPagoConsultaDia();
        
        pieModel2 = new PieChartModel(); 
        if (arre2==null){       
             // this.getBuscarPagosFecha();
            pieModel2.set("No hay Valores",0);
         }
        else{
            try{        
            for(int i=0; i<arre2.size();i++){  
                    
                    pieModel2.set(arre2.get(i).getTipo(), arre2.get(i).getMonto());              
            }  
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());         
                }    
        }
     return this.pieModel2;   
    } 
        
      public CartesianChartModel createBarModelPagoConsultaDia() {  
       ArrayList<Boleta> arre=getCargarPagoConsultaDia();
       categoryModel2 = new CartesianChartModel();   
        ChartSeries series = new ChartSeries();         
        Connection conexion = null; 
       if (arre==null){       
           series.setLabel("No hay valores");   
           series.set("No hay valores",0); 
         }
       else{
           try{
            series.setLabel("Series de Boletas"); 
            for(int i=0; i<arre.size();i++){                                       
                    series.set(arre.get(i).getTipo(), arre.get(i).getMonto());              
            }
 
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());
                        error.printStackTrace();
                }
        }
        categoryModel2.addSeries(series);
     return categoryModel2;   
    } 
      //------------------------FIN-REPORTE PAGO2-----------------------------
       //-------------------------------------------------------------------------
      
      
      //------------------------------REPORTE PAGO 3----------------------------------------
      //---------------------------------------------------------------------------
        
      public ArrayList<Boleta>getCargarPagoExamenFecha(){         
        if (arreglo3.size()==0){         
           Boleta obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_pagos_fechas()}");    
            rs = st.executeQuery();        
            if (rs.next()){ 
            do{
                obj =new Boleta();
                obj.setCodigo(rs.getString("h1"));
                if(obj.getCodigo().equals("0001")){
                    obj.setTipo("Boleta Vallejo");
                }else{
                    obj.setTipo("Boleta San Antonio");
                }
                obj.setBoleta(rs.getInt("cant"));
                obj.setExamen(rs.getInt("n"));
                obj.setMonto(rs.getDouble("monto"));
                obj.setFecha(rs.getDate("fecha"));
                arreglo3.add(obj);
           } while (rs.next());
         }  
         rs.close();
         st.close();
         conexion.close();

        }catch(Exception error){
        System.out.println("Error en el metodo por: " +error.getMessage());
                error.printStackTrace();
        }    
      }  
    return this.arreglo3;
    }
      
      
     public PieChartModel createPieModelPagoExamenFecha() {
        ArrayList<Boleta> arr=getCargarPagoExamenFecha();
        
        pieModel = new PieChartModel(); 
        if (arr==null){       
             // this.getBuscarPagosFecha();
            pieModel.set("No hay Valores",0);
         }
        else{
            try{        
            for(int i=0; i<arr.size();i++){  
                    
                    pieModel.set(arr.get(i).getTipo(), arr.get(i).getMonto());              
            }  
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());         
                }    
        }
     return this.pieModel;   
    } 
        
      public CartesianChartModel createBarModelPagoExamenFecha() {  
       ArrayList<Boleta> arr=getCargarPagoExamenFecha();
       categoryModel = new CartesianChartModel();   
        ChartSeries series = new ChartSeries();         
        Connection conexion = null; 
       if (arr==null){       
           series.setLabel("No hay valores");   
           series.set("No hay valores",0); 
         }
       else{
           try{
            series.setLabel("Series de Boletas"); 
            for(int i=0; i<arr.size();i++){                                       
                    series.set(arr.get(i).getFecha(), arr.get(i).getMonto());              
            }
 
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());
                        error.printStackTrace();
                }
        }
        categoryModel.addSeries(series);
     return categoryModel;   
    }   
      //------------------------FIN-REPORTE PAGO3-----------------------------
  //--------------------------------------------------------------------------    
      
      
      
   //------------------------REPORTE PAGO 4-------------------------------
   //--------------------------------------------------------------------
     
        public ArrayList<Boleta>getCargarPagoConsultaFecha(){         
        if (arreglo4.size()==0){         
           Boleta obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_pagos_fechascon()}");    
            rs = st.executeQuery();        
            if (rs.next()){ 
            do{
                obj =new Boleta();
                obj.setCodigo(rs.getString("h1"));
                if(obj.getCodigo().equals("0001")){
                    obj.setTipo("Boleta Vallejo");
                }else{
                    obj.setTipo("Boleta San Antonio");
                }
                obj.setBoleta(rs.getInt("cant"));
                obj.setExamen(rs.getInt("n"));
                obj.setMonto(rs.getDouble("monto"));
                obj.setFecha(rs.getDate("fecha"));
                arreglo4.add(obj);
           } while (rs.next());
         }  
         rs.close();
         st.close();
         conexion.close();

        }catch(Exception error){
        System.out.println("Error en el metodo por: " +error.getMessage());
                error.printStackTrace();
        }    
      }  
    return this.arreglo4;
    }
        
    public PieChartModel createPieModelPagoConsultaFecha() {
        ArrayList<Boleta> arr=getCargarPagoConsultaFecha();
        
        pieModel = new PieChartModel(); 
        if (arr==null){       
             // this.getBuscarPagosFecha();
            pieModel.set("No hay Valores",0);
         }
        else{
            try{        
            for(int i=0; i<arr.size();i++){  
                    
                    pieModel.set(arr.get(i).getTipo(), arr.get(i).getMonto());              
            }  
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());         
                }    
        }
     return this.pieModel;   
    } 
        
      public CartesianChartModel createBarModelPagoConsultaFecha() {  
       ArrayList<Boleta> arr=getCargarPagoConsultaFecha();
       categoryModel = new CartesianChartModel();   
        ChartSeries series = new ChartSeries();         
        Connection conexion = null; 
       if (arr==null){       
           series.setLabel("No hay valores");   
           series.set("No hay valores",0); 
         }
       else{
           try{
            series.setLabel("Series de Boletas"); 
            for(int i=0; i<arr.size();i++){                                       
                    series.set(arr.get(i).getFecha(), arr.get(i).getMonto());              
            }
 
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());
                        error.printStackTrace();
                }
        }
        categoryModel.addSeries(series);
     return categoryModel;   
    }       
        //------------------------FIN-REPORTE PAGO4-----------------------------
   //----------------------------------------------------------------------------------     
}
