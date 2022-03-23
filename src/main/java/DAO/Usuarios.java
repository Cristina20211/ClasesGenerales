/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Usuario;
import com.cristina.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MINEDUCYT
 */
public class Usuarios {
      ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConnection();

    public ArrayList<Usuario> ListadoUser(){
        ArrayList<Usuario> listado = null;
        try {
            listado = new ArrayList<Usuario>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_USUARIO()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                
                Usuario usu = new Usuario();
                usu.setUser(resultado.getString("usuario"));
                usu.setPassword(resultado.getString("Password"));
          

                listado.add(usu);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
    
       public int ComprobarUser(Usuario u){
         int validar = 0;
  
         
       try{
          
            CallableStatement cb = conexion.prepareCall("{call SP_COMPROBAR(?,?)}");
            cb.setString("PUsuario",u.getUser());
            cb.setString("PPassword",u.getPassword());
            ResultSet resultado = cb.executeQuery();

            while(resultado.next()) {
              
              validar = resultado.getInt("IdUsuario");
             
            }

       
       }catch(Exception ex){
           
           JOptionPane.showMessageDialog(null, ex.toString());
       }
       
              return validar;

    }
}
