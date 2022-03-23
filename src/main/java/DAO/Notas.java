/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entidades.Estudiante;
import Entidades.Nota;
import ViewModel.NotaVM;
import com.cristina.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MINEDUCYT
 */
 public class Notas {
      //Select para inner join
    ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConnection(); //varible que retorne el metodo getConnection

    //EJEMPLO DE SELECT
  
    public ArrayList<Nota> ListadoNotas() {
        ArrayList<Nota> listado = null;

        try {
            listado = new ArrayList<Nota>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MOSTRARNOTA()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Nota n = new Nota();
                n.setNota(resultado.getString("Nota"));
                n.setNombreMateria(resultado.getString("NombreMateria"));
                n.setNombre(resultado.getString("Nombre"));
          
                listado.add(n);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
    
    
    
//    public void ex (){
//    
//    String inicio = null;
//    String fin = null;
//    
//    inicio="";
//    if (inicio.isEmpty()&& inicio.equals("")){
//    
//    
//    }
    
    
    
//    }
     
}
