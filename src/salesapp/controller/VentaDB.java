/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesapp.controller;

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
        ventas.add(v);
    }
    
    public static ArrayList<Venta> queryAll(){
        return ventas;
    }
    
}
