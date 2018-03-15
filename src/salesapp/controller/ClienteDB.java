/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesapp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
//        Connection conn=null;
//        PreparedStatement psmt=null;
//        
//        try{
//            conn=DriverManager.getConnection("jdbc:mysql://SistemaMotos:3306/mydb",
//                    "root","root");
//            if(conn!=null){
//                System.out.println("connected to database");
//            }          
//        }catch(Exception e){
//            System.out.println("not connected");
//        }
//        finally{
//            try {
//                conn.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        clientes.add(c);
    }
    
    public static void update(Cliente c){
        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getDni().equals(c.getDni())){
                clientes.set(i,c);
                return;
            }
        }        
    }
    
    public static void delete(String dniCliente) {

        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getDni().equals(dniCliente)) {
                clientes.remove(i);
                return;
            }
        }
       
    }
    
    public static ArrayList<Cliente> queryAll(){
        return clientes;
    }

    public static Cliente queryByDni(String dni) {

    	for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getDni().equals(dni)) {
                return clientes.get(i);
            }
        }
        return null;

    }    
    
}
