/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesapp.controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import salesapp.model.Venta;

/**
 *
 * @author GUERRA
 */
public class VentaDB {
    private static ArrayList<Venta> ventas = new ArrayList<Venta>();
    
    public VentaDB(){
        
    }
   
    public static void add(Venta v){
        Connection conn=null;
        PreparedStatement psmt=null;
        
        try{
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                System.out.println("connected to database");
                //Paso 2: Preparar la sentencia
                String mysql = "INSERT INTO ventas "
                                + "(fecha, tipoVenta, medioDePago, seguro,techoLona,soat,idCliente,idMoto,monto,idIngreso)"
                                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
                psmt = (PreparedStatement) conn.prepareStatement(mysql);
                psmt.setDate(1, v.getFecha());
                psmt.setString(2, v.getTipoVenta());
                psmt.setString(3, v.getMedioPago());
                psmt.setString(4, v.getSeguro());
                psmt.setBoolean(5, v.isTechoLona());
                psmt.setBoolean(6, v.isSoat());
                psmt.setInt(7,v.getCliente().getId());
                psmt.setInt(8,v.getMoto().getId());
                psmt.setDouble(9, v.getMonto());
                psmt.setInt(10, v.getIngreso().getId());
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
    
    public static ArrayList<Venta> queryAll(){
        Connection conn=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        ArrayList<Venta> arr= new ArrayList<>();
        try {
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                //Paso 2: Preparar la sentencia
                String sql = "SELECT * FROM ventas";
                psmt = (PreparedStatement) conn.prepareStatement(sql);
                //Paso 3: Ejecutar la sentencia
                rs = psmt.executeQuery();
                //Paso 4(opc.): Procesar los resultados
                while (rs.next()){
                    Venta v = new Venta();
                    v.setId(rs.getInt("id"));
                    v.setFecha(rs.getDate("fecha"));
                    v.setTipoVenta(rs.getString("tipoVenta"));
                    v.setMedioPago(rs.getString("medioDePago"));
                    v.setSeguro(rs.getString("seguro"));
                    v.setTechoLona(rs.getBoolean("techoLona"));
                    v.setSoat(rs.getBoolean("soat"));
                    v.setCliente(ClienteDB.queryByid(rs.getInt("idCliente")));
                    v.setMoto(MotoDB.queryById(rs.getInt("idMoto")));
                    v.setMonto(rs.getDouble("monto"));
                    v.setIngreso(IngresoDB.queryByid(rs.getInt("idIngreso")));
                    arr.add(v);
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
    
}
