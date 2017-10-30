/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesapp.controller;

import java.util.ArrayList;
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
