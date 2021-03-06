/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesapp.controller;


//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import salesapp.model.Cliente;

/**
 *
 * @author GUERRA
 */
public class ClienteDB {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    
    public ClienteDB(){
        
    }
    

    public static void add(Cliente c) {
        Connection conn=null;
        PreparedStatement psmt=null;
        
        try{
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                System.out.println("connected to database");
                //Paso 2: Preparar la sentencia
                String mysql = "INSERT INTO clientes "
                                + "(nombres, apellidoPat, apellidoMat, dni,direccion,estadoCivil,celular,fechaNacimiento,fechaRegistro)"
                                + "VALUES (?,?,?,?,?,?,?,?,?)";
                psmt = (PreparedStatement) conn.prepareStatement(mysql);
                psmt.setString(1, upperCaseAllFirst(c.getNombres()));
                psmt.setString(2, upperCaseAllFirst(c.getApellidoPat()));
                psmt.setString(3, upperCaseAllFirst(c.getApellidoMat()));
                psmt.setString(4, c.getDni());
                psmt.setString(5, c.getDireccion());
                psmt.setString(6, c.getEstadoCivil());
                psmt.setInt(7, c.getCelular());
                psmt.setDate(8, c.getFechaNacimiento());
                psmt.setDate(9, c.getFechaRegistro());
                //Paso 4: Ejecutar la sentencia
                psmt.executeUpdate();                
            }          
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        finally{
            try { if (psmt!= null) psmt.close();} 
                    catch (Exception e){e.printStackTrace();};
            try { if (conn!= null) conn.close();} 
                    catch (Exception e){e.printStackTrace();};
        }
        //clientes.add(c);
    }
    
    public static String upperCaseAllFirst(String value) {

        char[] array = value.toCharArray();
        // Uppercase first letter.
        array[0] = Character.toUpperCase(array[0]);

        // Uppercase all letters that follow a whitespace character.
        for (int i = 1; i < array.length; i++) {
            if (Character.isWhitespace(array[i - 1])) {
                array[i] = Character.toUpperCase(array[i]);
            }
        }

        // Result.
        return new String(array).replaceAll("( +)"," ").trim();
    } 
    
    public static void update(Cliente c){
        Connection conn=null;
        PreparedStatement psmt=null;
        
        try{
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                System.out.println("connected to database");
                //Paso 2: Preparar la sentencia
                String mysql = "UPDATE clientes set "
                                + "nombres = ?, apellidoPat = ?, apellidoMat = ?, dni = ?,direccion = ?,estadoCivil = ?,celular = ?, fechaNacimiento = ?"
                                + " WHERE id = ?";
                psmt = (PreparedStatement) conn.prepareStatement(mysql);
                //pstmt.setInt(1, p.getId());
                psmt.setString(1, upperCaseAllFirst(c.getNombres()));
                psmt.setString(2, upperCaseAllFirst(c.getApellidoPat()));
                psmt.setString(3, upperCaseAllFirst(c.getApellidoMat()));
                psmt.setString(4, c.getDni());
                psmt.setString(5, c.getDireccion());
                psmt.setString(6, c.getEstadoCivil());
                psmt.setInt(7, c.getCelular());
                psmt.setDate(8, c.getFechaNacimiento());
                psmt.setInt(9, c.getId());
                //Paso 4: Ejecutar la sentencia
                psmt.executeUpdate();                
            }          
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        finally{
            try { if (psmt!= null) psmt.close();} 
                    catch (Exception e){e.printStackTrace();};
            try { if (conn!= null) conn.close();} 
                    catch (Exception e){e.printStackTrace();};
        }       
    }
    
    public static void delete(String dniCliente) {
        Connection conn=null;
        PreparedStatement psmt=null;
        
        try{
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                System.out.println("connected to database");
                //Paso 2: Preparar la sentencia
                String mysql = "UPDATE clientes set "
                                + "activo = 0"
                                + " WHERE dni = ?";
                psmt = (PreparedStatement) conn.prepareStatement(mysql);

                psmt.setString(1,dniCliente);
                //Paso 4: Ejecutar la sentencia
                psmt.executeUpdate();                
            }          
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        finally{
            try { if (psmt!= null) psmt.close();} 
                    catch (Exception e){e.printStackTrace();};
            try { if (conn!= null) conn.close();} 
                    catch (Exception e){e.printStackTrace();};
        } 
    }
    
    public static ArrayList<Cliente> queryAll(){
        Connection conn=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        ArrayList<Cliente> arr= new ArrayList<>();
        try {
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                //Paso 2: Preparar la sentencia
                String sql = "SELECT * FROM clientes WHERE activo = 1";
                psmt = (PreparedStatement) conn.prepareStatement(sql);
                //Paso 3: Ejecutar la sentencia
                rs = psmt.executeQuery();
                //Paso 4(opc.): Procesar los resultados
                while (rs.next()){
                        Cliente c = new Cliente();
                        c.setId(rs.getInt("id"));
                        c.setNombres(rs.getString("nombres"));
                        c.setApellidoPat(rs.getString("apellidoPat"));
                        c.setApellidoMat(rs.getString("apellidoMat"));
                        c.setDni(rs.getString("dni"));
                        c.setDireccion(rs.getString("direccion"));
                        c.setEstadoCivil(rs.getString("estadoCivil"));
                        c.setCelular(rs.getInt("celular"));
                        c.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                        c.setFechaRegistro(rs.getDate("fechaRegistro"));
                        arr.add(c);
                }                
            }
            
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        finally{
            try { if (psmt!= null) psmt.close();} 
                    catch (Exception e){e.printStackTrace();};
            try { if (conn!= null) conn.close();} 
                    catch (Exception e){e.printStackTrace();};
        }        
        return arr;
    }

    public static Cliente queryByid(int idcliente) {
        Connection conn=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        ArrayList<Cliente> arr= new ArrayList<>();
        try {
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                //Paso 2: Preparar la sentencia
                String sql = "SELECT * FROM clientes WHERE id = "+idcliente;
                psmt = (PreparedStatement) conn.prepareStatement(sql);
                //Paso 3: Ejecutar la sentencia
                rs = psmt.executeQuery();
                //Paso 4(opc.): Procesar los resultados
                while (rs.next()){
                        Cliente c = new Cliente();
                        c.setId(rs.getInt("id"));
                        c.setNombres(rs.getString("nombres"));
                        c.setApellidoPat(rs.getString("apellidoPat"));
                        c.setApellidoMat(rs.getString("apellidoMat"));
                        c.setDni(rs.getString("dni"));
                        c.setDireccion(rs.getString("direccion"));
                        c.setEstadoCivil(rs.getString("estadoCivil"));
                        c.setCelular(rs.getInt("celular"));
                        c.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                        c.setFechaRegistro(rs.getDate("fechaRegistro"));                        
                        arr.add(c);
                }                
            }
            
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        finally{
            try { if (psmt!= null) psmt.close();} 
                    catch (Exception e){e.printStackTrace();};
            try { if (conn!= null) conn.close();} 
                    catch (Exception e){e.printStackTrace();};
        }        
        return arr.get(0);

    }    
    
}
