/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.*;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;


public class BeanReportes implements Serializable{
    private PieChartModel pieModel;
     private CartesianChartModel categoryModel;
     private ArrayList<Boleta> arregloPago = new ArrayList<Boleta>();
     private Boleta boleta_p = new Boleta();
     private Examen examen_p=new Examen();
     private Date fech_ini= new Date();
     private Date fech_fin= new Date();

    public BeanReportes() {
    }

    public ArrayList<Boleta> getArregloPago() {
        return arregloPago;
    }

    public void setArregloPago(ArrayList<Boleta> arregloPago) {
        this.arregloPago = arregloPago;
    }

    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CartesianChartModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public Boleta getBoleta_p() {
        return boleta_p;
    }

    public void setBoleta_p(Boleta boleta_p) {
        this.boleta_p = boleta_p;
    }

    public Date getFech_fin() {
        return fech_fin;
    }

    public void setFech_fin(Date fech_fin) {
        this.fech_fin = fech_fin;
    }

    public Date getFech_ini() {
        return fech_ini;
    }

    public void setFech_ini(Date fech_ini) {
        this.fech_ini = fech_ini;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public Examen getExamen_p() {
        return examen_p;
    }

    public void setExamen_p(Examen examen_p) {
        this.examen_p = examen_p;
    }
     
   //====================REPORTE 1 =============================================
    public PieChartModel createPieModelTotalIngresos() {
        ArrayList<Boleta> arr=getBuscarPagosFecha();
        
        pieModel = new PieChartModel(); 
        if (arr==null){       
             // this.getBuscarPagosFecha();
            pieModel.set("No hay Valores",0);
         }
        else{
            try{        
            for(int i=0; i<arr.size();i++){                                       
                    pieModel.set(arr.get(i).getSerie(), arr.get(i).getMonto());              
            }  
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());         
                }    
        }
     return this.pieModel;   
    } 
    
    public CartesianChartModel createBarModelTotalIngresos() {  
       ArrayList<Boleta> arr=getBuscarPagosFecha();
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
                    series.set(arr.get(i).getSerie(), arr.get(i).getMonto());              
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
    
    int var=0;
     public ArrayList<Boleta> getBuscarPagosFecha(){
        ArrayList<Boleta> arr=null;       
        ResultSet rs=null;
        Boleta obj=null;
        Connection conexion = null;
        
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_listar_pagos_fecha(?,?)}");
            st.setDate(1,new java.sql.Date(fech_ini.getTime()));                   
            st.setDate(2,new java.sql.Date(fech_fin.getTime()));                               
            rs = st.executeQuery();
            System.out.println(new java.sql.Date(fech_ini.getTime())+" "+new java.sql.Date(fech_fin.getTime()));
            if (rs.next()){                              
               arr = new ArrayList<Boleta>();
                do{
                    obj =new Boleta();
                    obj.setSerie(rs.getString("cod_boleta"));
                    obj.setMonto(rs.getDouble("monto"));
                    var++;
                    arr.add(obj);
               } while (rs.next());
            }  
                 rs.close();
                 st.close();
                 conexion.close();
        }catch(Exception error){
                System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }
        System.out.println("numero de veces: "+var);
    return arr;                
    }
   //===========================================================================
     //=====================REPORTE 2 ==========================================
     public ArrayList<Boleta> getBuscarIngresosxMesxAñoActual(){
        ArrayList<Boleta> arr=null;       
        ResultSet rs=null;
        Boleta obj=null;
        Connection conexion = null;
        
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_listar_ingreso_xmes_año_actual()}");                              
            rs = st.executeQuery();
            
            if (rs.next()){                              
               arr = new ArrayList<Boleta>();
                do{
                    obj =new Boleta();
                    obj.setMes(rs.getString("mes"));
                    obj.setMonto(rs.getDouble("monto"));
                    var++;
                    arr.add(obj);
               } while (rs.next());
            }  
                 rs.close();
                 st.close();
                 conexion.close();
        }catch(Exception error){
                System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }
        System.out.println("numero de veces: "+var);
    return arr;                
    }
     
     public PieChartModel createPieModelIngresosxMesAñoActual() {
        ArrayList<Boleta> arr=getBuscarIngresosxMesxAñoActual();
        
        pieModel = new PieChartModel(); 
        if (arr==null){       
             // this.getBuscarPagosFecha();
            pieModel.set("No hay Valores",0);
         }
        else{
            try{        
            for(int i=0; i<arr.size();i++){                                       
                    pieModel.set(arr.get(i).getMes(), arr.get(i).getMonto());              
            }  
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());         
                }    
        }
     return this.pieModel;   
    } 
     
     public CartesianChartModel createBarModelIngresosxMesAñoActual() {  
       ArrayList<Boleta> arr=getBuscarIngresosxMesxAñoActual();
       categoryModel = new CartesianChartModel();   
        ChartSeries series = new ChartSeries();         
        Connection conexion = null; 
       if (arr==null){       
           series.setLabel("No hay valores");   
           series.set("No hay valores",0); 
         }
       else{
           try{
            series.setLabel("Total Ingresos"); 
            for(int i=0; i<arr.size();i++){                                       
                    series.set(arr.get(i).getMes(), arr.get(i).getMonto());              
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
     //=========================================================================
     //=====================REPORTE 3 ==========================================
     public ArrayList<Boleta> getBuscarIngresosxMesxAño(){
        ArrayList<Boleta> arr=null;       
        ResultSet rs=null;
        Boleta obj=null;
        Connection conexion = null;
        
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_listar_ingreso_xmes_año(?)}"); 
            st.setString(1,this.getBoleta_p().getAño());
            rs = st.executeQuery();
            
            if (rs.next()){                              
               arr = new ArrayList<Boleta>();
                do{
                    obj =new Boleta();
                    obj.setMes(rs.getString("mes"));
                    obj.setMonto(rs.getDouble("monto"));
                    var++;
                    arr.add(obj);
               } while (rs.next());
            }  
                 rs.close();
                 st.close();
                 conexion.close();
        }catch(Exception error){
                System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }
        System.out.println("numero de veces: "+var);
    return arr;                
    }
     public PieChartModel createPieModelIngresosxMesAño() {
        ArrayList<Boleta> arr=getBuscarIngresosxMesxAño();
        
        pieModel = new PieChartModel(); 
        if (arr==null){       
             // this.getBuscarPagosFecha();
            pieModel.set("No hay Valores",0);
         }
        else{
            try{        
            for(int i=0; i<arr.size();i++){                                       
                    pieModel.set(arr.get(i).getMes(), arr.get(i).getMonto());              
            }  
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());         
                }    
        }
     return this.pieModel;   
    } 
     
     public CartesianChartModel createBarModelIngresosxMesAño() {  
       ArrayList<Boleta> arr=getBuscarIngresosxMesxAño();
       categoryModel = new CartesianChartModel();   
        ChartSeries series = new ChartSeries();         
        Connection conexion = null; 
       if (arr==null){       
           series.setLabel("No hay valores");   
           series.set("No hay valores",0); 
         }
       else{
           try{
            series.setLabel("Total Ingresos"); 
            for(int i=0; i<arr.size();i++){                                       
                    series.set(arr.get(i).getMes(), arr.get(i).getMonto());              
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
     //=========================================================================
     //=====================REPORTE 4 ==========================================
     public ArrayList<Examen> getBuscarExamenesxMesAñoActual(){
        ArrayList<Examen> arr=null;       
        ResultSet rs=null;
        Examen obj=null;
        Connection conexion = null;
        
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_listar_examenes_xmes_año_actual()}");                              
            rs = st.executeQuery();
            
            if (rs.next()){                              
               arr = new ArrayList<Examen>();
                do{
                    obj =new Examen();
                    obj.setMes(rs.getString("mes"));
                    obj.setCantidad(rs.getInt("examenes"));
                    var++;
                    arr.add(obj);
               } while (rs.next());
            }  
                 rs.close();
                 st.close();
                 conexion.close();
        }catch(Exception error){
                System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }
        System.out.println("numero de veces: "+var);
    return arr;                
    }
     
     public PieChartModel createPieModelExamenesxMesAñoActual() {
        ArrayList<Examen> arr=getBuscarExamenesxMesAñoActual();
        
        pieModel = new PieChartModel(); 
        if (arr==null){       
             // this.getBuscarPagosFecha();
            pieModel.set("No hay Valores",0);
         }
        else{
            try{        
            for(int i=0; i<arr.size();i++){                                       
                    pieModel.set(arr.get(i).getMes(), arr.get(i).getCantidad());              
            }  
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());         
                }    
        }
     return this.pieModel;   
    } 
     
     public CartesianChartModel createBarModelExamenesxMesAñoActual() {  
       ArrayList<Examen> arr=getBuscarExamenesxMesAñoActual();
       categoryModel = new CartesianChartModel();   
        ChartSeries series = new ChartSeries();         
        Connection conexion = null; 
       if (arr==null){       
           series.setLabel("No hay valores");   
           series.set("No hay valores",0); 
         }
       else{
           try{
            series.setLabel("Total Examenes"); 
            for(int i=0; i<arr.size();i++){                                       
                    series.set(arr.get(i).getMes(), arr.get(i).getCantidad());              
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
     //=========================================================================
     //=====================REPORTE 5 ==========================================
     public ArrayList<Examen> getBuscarExamenesxMesAño(){
        ArrayList<Examen> arr=null;       
        ResultSet rs=null;
        Examen obj=null;
        Connection conexion = null;
        
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_listar_examenes_xmes_año(?)}"); 
            st.setString(1,this.getExamen_p().getAño());
            rs = st.executeQuery();
            
            if (rs.next()){                              
               arr = new ArrayList<Examen>();
                do{
                    obj =new Examen();
                    obj.setMes(rs.getString("mes"));
                    obj.setCantidad(rs.getInt("examenes"));
                    var++;
                    arr.add(obj);
               } while (rs.next());
            }  
                 rs.close();
                 st.close();
                 conexion.close();
        }catch(Exception error){
                System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }
        System.out.println("numero de veces: "+var);
    return arr;                
    }
      
     public PieChartModel createPieModelExamenesxMesAño() {
        ArrayList<Examen> arr=getBuscarExamenesxMesAño();
        
        pieModel = new PieChartModel(); 
        if (arr==null){       
             // this.getBuscarPagosFecha();
            pieModel.set("No hay Valores",0);
         }
        else{
            try{        
            for(int i=0; i<arr.size();i++){                                       
                    pieModel.set(arr.get(i).getMes(), arr.get(i).getCantidad());              
            }  
            }catch(Exception error){
                System.out.println("Error en el metodo por: " +
                        error.getMessage());         
                }    
        }
     return this.pieModel;   
    } 
     
     public CartesianChartModel createBarModelExamenesxMesAño() {  
       ArrayList<Examen> arr=getBuscarExamenesxMesAño();
       categoryModel = new CartesianChartModel();   
        ChartSeries series = new ChartSeries();         
        Connection conexion = null; 
       if (arr==null){       
           series.setLabel("No hay valores");   
           series.set("No hay valores",0); 
         }
       else{
           try{
            series.setLabel("Total Examenes"); 
            for(int i=0; i<arr.size();i++){                                       
                    series.set(arr.get(i).getMes(), arr.get(i).getCantidad());              
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
     //=========================================================================
}
