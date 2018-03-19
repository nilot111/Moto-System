/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesapp.controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static salesapp.controller.ClienteDB.upperCaseAllFirst;
import salesapp.model.IngresoMoto;

/**
 *
 * @author GUERRA
 */
public class IngresoDB {
    private ArrayList<IngresoMoto> ingresoList = new ArrayList<IngresoMoto>();
    
    public static void add(IngresoMoto i) {
        Connection conn=null;
        PreparedStatement psmt=null;
        
        try{
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                System.out.println("connected to database");
                //Paso 2: Preparar la sentencia
                String mysql = "INSERT INTO ingresomoto "
                                + "(fecha, codFactura, añoFabricacion, chasis,"
                        + " motor, montoFacturado ,numPolizaImportacion , añoEntrada , numItem,"
                        + " ubicacion , idMoto)"
                                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                psmt = (PreparedStatement) conn.prepareStatement(mysql);
                psmt.setDate(1, i.getFecha());
                psmt.setString(2, i.getCodFactura() );
                psmt.setInt(3, i.getAñoFabricacion());
                psmt.setString(4, i.getChasis());
                psmt.setString(5, i.getMotor());
                psmt.setDouble(6, i.getMontoFacturado());
                psmt.setInt(7, i.getNumPoliza());
                psmt.setInt(8,i.getAñoEntrada());
                psmt.setInt(9, i.getNumItem());
                psmt.setString(10, i.getUbicacion());
                psmt.setInt(11, i.getIdMotoModelo());
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

    public static void update(IngresoMoto i) {
        Connection conn=null;
        PreparedStatement psmt=null;
        
        try{
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                System.out.println("connected to database");
                //Paso 2: Preparar la sentencia
                String mysql = "UPDATE ingresomoto set "
                                + "fecha = ?, codFactura = ?, añoFabricacion = ?, chasis = ?,"
                        + "motor = ?,montoFacturado = ?,numPolizaImportacion = ?,añoEntrada = ?,numItem = ?,"
                        + "ubicacion = ?,idMoto = ?"
                                + " WHERE id = ?";
                psmt = (PreparedStatement) conn.prepareStatement(mysql);
                psmt.setDate(1, i.getFecha());
                psmt.setString(2, i.getCodFactura() );
                psmt.setInt(3, i.getAñoFabricacion());
                psmt.setString(4, i.getChasis());
                psmt.setString(5, i.getMotor());
                psmt.setDouble(6, i.getMontoFacturado());
                psmt.setInt(7, i.getNumPoliza());
                psmt.setInt(8,i.getAñoEntrada());
                psmt.setInt(9, i.getNumItem());
                psmt.setString(10, i.getUbicacion());
                psmt.setInt(11, i.getIdMotoModelo());
                psmt.setInt(12, i.getId());
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
    
    public static ArrayList<IngresoMoto> queryAll(){
        Connection conn=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        ArrayList<IngresoMoto> arr= new ArrayList<>();
        try {
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                //Paso 2: Preparar la sentencia
                String sql = "SELECT * FROM ingresomoto WHERE estado = 'Stock'";
                psmt = (PreparedStatement) conn.prepareStatement(sql);
                //Paso 3: Ejecutar la sentencia
                rs = psmt.executeQuery();
                //Paso 4(opc.): Procesar los resultados
                while (rs.next()){
                        IngresoMoto i = new IngresoMoto();
                        i.setId(rs.getInt("id"));
                        i.setFecha(rs.getDate("fecha"));
                        i.setCodFactura(rs.getString("codFactura"));
                        i.setAñoFabricacion(rs.getInt("añoFabricacion"));
                        i.setChasis(rs.getString("chasis"));
                        i.setMotor(rs.getString("motor"));
                        i.setMontoFacturado(rs.getDouble("montoFacturado"));
                        i.setNumPoliza(rs.getInt("numPolizaImportacion"));
                        i.setAñoEntrada(rs.getInt("añoEntrada"));
                        i.setNumItem(rs.getInt("numItem"));
                        i.setUbicacion(rs.getString("ubicacion"));
                        i.setIdMotoModelo(rs.getInt("idMoto"));
                        i.setEstado(rs.getString("estado"));
                        arr.add(i);
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
    
    public static IngresoMoto vender(int idmoto){
        Connection conn=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        ArrayList<IngresoMoto> arr= new ArrayList<>();
        try {
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                //Paso 2: Preparar la sentencia
                String sql = "SELECT * FROM ingresomoto WHERE estado = 'Stock' AND idMoto = "+idmoto;
                psmt = (PreparedStatement) conn.prepareStatement(sql);
                //Paso 3: Ejecutar la sentencia
                rs = psmt.executeQuery();
                //Paso 4(opc.): Procesar los resultados
                if(rs.next()){
                        IngresoMoto i = new IngresoMoto();
                        i.setId(rs.getInt("id"));
                        i.setFecha(rs.getDate("fecha"));
                        i.setCodFactura(rs.getString("codFactura"));
                        i.setAñoFabricacion(rs.getInt("añoFabricacion"));
                        i.setChasis(rs.getString("chasis"));
                        i.setMotor(rs.getString("motor"));
                        i.setMontoFacturado(rs.getDouble("montoFacturado"));
                        i.setNumPoliza(rs.getInt("numPolizaImportacion"));
                        i.setAñoEntrada(rs.getInt("añoEntrada"));
                        i.setNumItem(rs.getInt("numItem"));
                        i.setUbicacion(rs.getString("ubicacion"));
                        i.setIdMotoModelo(rs.getInt("idMoto"));
                        i.setEstado(rs.getString("estado"));
                        arr.add(i);
                }
                String mysql = "UPDATE ingresomoto set "
                                + "estado = 'Vendido'"
                                + " WHERE id = "+rs.getInt("id");
                psmt = (PreparedStatement) conn.prepareStatement(mysql);
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
        return arr.get(0);        
    }
    
    public static IngresoMoto queryByid(int idIngreso){
        Connection conn=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        ArrayList<IngresoMoto> arr= new ArrayList<>();
        try {
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                //Paso 2: Preparar la sentencia
                String sql = "SELECT * FROM ingresomoto WHERE id = "+idIngreso;
                psmt = (PreparedStatement) conn.prepareStatement(sql);
                //Paso 3: Ejecutar la sentencia
                rs = psmt.executeQuery();
                //Paso 4(opc.): Procesar los resultados
                if(rs.next()){
                        IngresoMoto i = new IngresoMoto();
                        i.setId(rs.getInt("id"));
                        i.setFecha(rs.getDate("fecha"));
                        i.setCodFactura(rs.getString("codFactura"));
                        i.setAñoFabricacion(rs.getInt("añoFabricacion"));
                        i.setChasis(rs.getString("chasis"));
                        i.setMotor(rs.getString("motor"));
                        i.setMontoFacturado(rs.getDouble("montoFacturado"));
                        i.setNumPoliza(rs.getInt("numPolizaImportacion"));
                        i.setAñoEntrada(rs.getInt("añoEntrada"));
                        i.setNumItem(rs.getInt("numItem"));
                        i.setUbicacion(rs.getString("ubicacion"));
                        i.setIdMotoModelo(rs.getInt("idMoto"));
                        i.setEstado(rs.getString("estado"));
                        arr.add(i);
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
