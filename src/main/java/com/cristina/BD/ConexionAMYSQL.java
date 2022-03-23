/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristina.BD;
import java.sql.*;
import javax.swing.JOptionPane;
import Entidades.Estudiante;
/**
 *
 * @author cristina
 */
public class ConexionAMYSQL {
    
    
    private static Connection ConnectionBD = null;
    public Connection getConnection (){
    
  
    
    
        try {
            String url ="jdbc:mysql://localhost:3306/clases";
            String user="cris";
            String password="root";
            
            ConnectionBD=DriverManager.getConnection(url,user,password);
            System.out.println("conexion exitosa");
            
            
        } catch (Exception e) {
        
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        
        }
    
    
       return ConnectionBD;
    }
    
    }
    
    
    
    
    
    
    

