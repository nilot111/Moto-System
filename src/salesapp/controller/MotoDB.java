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
import salesapp.model.Moto;

/**
 *
 * @author GUERRA
 */
public class MotoDB {
    private static ArrayList<Moto> motoList = new ArrayList<Moto>();
    private static int idCounter=0;
    public MotoDB(){
        
    }
    
    public static void add(Moto m) {
        Connection conn=null;
        PreparedStatement psmt=null;
        
        try{
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                System.out.println("connected to database");
                //Paso 2: Preparar la sentencia
                String mysql = "INSERT INTO motos "
                                + "(tipo, producto, modelo, precioLista, precioContado, color, stock)"
                                + "VALUES (?,?,?,?,?,?,?)";
                psmt = (PreparedStatement) conn.prepareStatement(mysql);
                psmt.setString(1, m.getTipo());
                psmt.setString(2, m.getProducto());
                psmt.setString(3, m.getModelo());
                psmt.setDouble(4, m.getPrecioLista());
                psmt.setDouble(5, m.getPrecioContado());
                psmt.setString(6, m.getColor());
                psmt.setInt(7, m.getStock());
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
    
    public static void update(Moto m){
        Connection conn=null;
        PreparedStatement psmt=null;
        
        try{
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                System.out.println("connected to database");
                //Paso 2: Preparar la sentencia
                String mysql = "UPDATE motos set "
                                + "tipo = ?, producto = ?, modelo = ?, precioLista = ?,precioContado = ?,color = ?,stock = ?"
                                + " WHERE id = ?";
                psmt = (PreparedStatement) conn.prepareStatement(mysql);
                //pstmt.setInt(1, p.getId());
                psmt.setString(1, m.getTipo());
                psmt.setString(2, m.getProducto());
                psmt.setString(3, m.getModelo());
                psmt.setDouble(4, m.getPrecioLista());
                psmt.setDouble(5, m.getPrecioContado());
                psmt.setString(6, m.getColor());
                psmt.setInt(7, m.getStock());
                psmt.setInt(8,m.getId());
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
    
    public static void delete(int idmoto) {
        Connection conn=null;
        PreparedStatement psmt=null;
        
        try{
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                System.out.println("connected to database");
                //Paso 2: Preparar la sentencia
                String mysql = "UPDATE motos set "
                                + "activo = 0"
                                + " WHERE id = ?";
                psmt = (PreparedStatement) conn.prepareStatement(mysql);

                psmt.setInt(1,idmoto);
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
    
    public static ArrayList<Moto> queryAll(){
        Connection conn=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        ArrayList<Moto> arr= new ArrayList<>();
        try {
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                //Paso 2: Preparar la sentencia
                String sql = "SELECT * FROM motos WHERE activo = 1";
                psmt = (PreparedStatement) conn.prepareStatement(sql);
                //Paso 3: Ejecutar la sentencia
                rs = psmt.executeQuery();
                //Paso 4(opc.): Procesar los resultados
                while (rs.next()){
                        Moto m = new Moto();
                        m.setId(rs.getInt("id"));
                        m.setTipo(rs.getString("tipo"));
                        m.setProducto(rs.getString("producto"));
                        m.setModelo(rs.getString("modelo"));
                        m.setPrecioLista(rs.getDouble("precioLista"));
                        m.setPrecioContado(rs.getDouble("precioContado"));
                        m.setColor(rs.getString("color"));
                        m.setStock(rs.getInt("stock"));
                        arr.add(m);
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

    public static Moto queryById(int idmoto) {
        Connection conn=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        ArrayList<Moto> arr= new ArrayList<>();
        try {
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                //Paso 2: Preparar la sentencia
                String sql = "SELECT * FROM motos  WHERE id = "+idmoto;
                psmt = (PreparedStatement) conn.prepareStatement(sql);
                //Paso 3: Ejecutar la sentencia
                rs = psmt.executeQuery();
                //Paso 4(opc.): Procesar los resultados
                while (rs.next()){
                        Moto m = new Moto();
                        m.setId(rs.getInt("id"));
                        m.setTipo(rs.getString("tipo"));
                        m.setProducto(rs.getString("producto"));
                        m.setModelo(rs.getString("modelo"));
                        m.setPrecioLista(rs.getDouble("precioLista"));
                        m.setPrecioLista(rs.getDouble("precioContado"));
                        m.setColor(rs.getString("color"));
                        m.setStock(rs.getInt("stock"));
                        arr.add(m);
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
    
    public static void vender(Moto m){
        Connection conn=null;
        PreparedStatement psmt=null;
        
        try{
            //Paso 1: Obtener la conexión
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                    "root","root");
            if(conn!=null){
                System.out.println("connected to database");
                //Paso 2: Preparar la sentencia
                String mysql = "UPDATE motos set "
                                + "stock = ?"
                                + " WHERE id = ?";
                psmt = (PreparedStatement) conn.prepareStatement(mysql);

                psmt.setInt(1,m.getStock()-1);
                psmt.setInt(2,m.getId());
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
}
