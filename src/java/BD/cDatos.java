/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CECyT9
 */
public class cDatos {
    private String usrBD;
    private String passBD;
    private String urlBD;
    private String driverClassName;
    private Connection conn=null;
    private Statement instruccion;

    public cDatos() {
        this.usrBD = "root";
        this.passBD = "n0m3l0";
        this.urlBD = "jdbc:mysql://localhost/Saker";
        this.driverClassName = "com.mysql.jdbc.Driver";
    }
    
    public void conectar() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        try{
            Class.forName(this.driverClassName).newInstance();
            conn = DriverManager.getConnection(urlBD, usrBD, passBD);
        }
        catch(Exception err){
            System.out.println("Error en cDatos" + err.getMessage());
        }
    }
    
    public void cierraConexion() throws SQLException{
        System.out.println("Acceso denegado");
        this.conn.close();
        
    }
    
    public ResultSet consulta(String consulta) throws SQLException {
        instruccion = (Statement) conn.createStatement();
        return instruccion.executeQuery(consulta);
    }
    
    public int insertar(String inserta) throws SQLException {
        instruccion = (Statement) conn.createStatement();
        return instruccion.executeUpdate(inserta);
    }
}