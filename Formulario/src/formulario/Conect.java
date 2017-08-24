/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import static java.lang.System.out;
import java.sql.*;

/**
 *
 * @author Alumno
 */
public class Conect {
    
    Connection c=null;
    Statement s=null;
    PreparedStatement p=null;
    
    public void Guardar(String nom,String app,String apm,String esc) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            c=DriverManager.getConnection("jdbc:mysql://localhost/JavaDatos","root","n0m3l0");
            s=c.createStatement();
        }
        catch(SQLException error){
            out.println(error);
        }
        
        try{
            p=c.prepareStatement("insert into datos (nombre,apellidopat,apellidomat,escuela) values (?,?,?,?);");
            p.setString(1, nom);
            p.setString(2, app);
            p.setString(3, apm);
            p.setString(4, esc);
            p.executeUpdate();
        }catch(SQLException error){
            out.println(error);
        }
    }
}
