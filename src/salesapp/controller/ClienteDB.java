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
    private ArrayList<Cliente> clientes = new ArrayList<>();
    
    public ClienteDB(){
        
    }
    
    public void add(Cliente c) {
        clientes.add(c);
    }
    
    public void update(Cliente c){
        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getId() == c.getId()){
                clientes.set(i,c);
                return;
            }
        }        
    }
    
    public void delete(int idCliente) {

        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getId() == idCliente) {
                clientes.remove(i);
                return;
            }
        }
       
    }
    
    public ArrayList<Cliente> queryAll(){
        return clientes;
    }

    public Cliente queryById(int clienteId) {

    	for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getId() == clienteId) {
                return clientes.get(i);
            }
        }
        return null;

    }    
    
}
