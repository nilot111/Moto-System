/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesapp.model;

/**
 *
 * @author GUERRA
 */
public class Moto {
    private int id;
    private String tipo; // motocarros, 4 ruedas,motocicletas
    private String producto; // torito ,boxer,discover,..
    private String modelo; // estandar ,superlujo,boxer bm150
    private double precioLista;
    private double precioContado;
    private String color;
    private int stock;
    
    public Moto(){
        
    }
    
    public Moto(int id,String tipo,String producto,String modelo,double precLista,
                double precContado,String color){
        this.id=id;
        this.tipo=tipo;
        this.producto=producto;
        this.modelo=modelo;
        this.precioLista=precLista;
        this.precioContado=precContado;
        this.color=color;
        this.stock=0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the precioLista
     */
    public double getPrecioLista() {
        return precioLista;
    }

    /**
     * @param precioLista the precioLista to set
     */
    public void setPrecioLista(double precioLista) {
        this.precioLista = precioLista;
    }

    /**
     * @return the precioContado
     */
    public double getPrecioContado() {
        return precioContado;
    }

    /**
     * @param precioContado the precioContado to set
     */
    public void setPrecioContado(double precioContado) {
        this.precioContado = precioContado;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
