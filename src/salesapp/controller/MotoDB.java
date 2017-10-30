/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesapp.controller;

import java.util.ArrayList;
import salesapp.model.Moto;

/**
 *
 * @author GUERRA
 */
public class MotoDB {
    private static ArrayList<Moto> motoList = new ArrayList<Moto>();
    
    public MotoDB(){
        
    }
    
    public static void add(Moto c) {
        motoList.add(c);
    }
    
    public static void update(Moto c){
        for (int i = 0; i < motoList.size(); i++){
            if (motoList.get(i).getId()==c.getId()){
                motoList.set(i,c);
                return;
            }
        }        
    }
    
    public static void delete(int id) {

        for (int i = 0; i < motoList.size(); i++){
            if (motoList.get(i).getId()==id){
                motoList.remove(i);
                return;
            }
        }
       
    }
    
    public static ArrayList<Moto> queryAll(){
        return motoList;
    }

    public static Moto queryById(int id) {

    	for (int i = 0; i < motoList.size(); i++){
            if (motoList.get(i).getId()==id){
                return motoList.get(i);
            }
        }
        return null;

    }        
}
