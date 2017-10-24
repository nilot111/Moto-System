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
public class Venta {
    private int id;
    private double monto;
    private String fecha;
    private Cliente cliente;
    private Moto moto;
    private String tipoVenta; // Factura, boleta, nota de credito
    
    public Venta(){
        
    }
    
    public Venta(int id,double monto,String fecha,Cliente cliente,Moto moto){
        this.id=id;
        this.monto=monto;
        this.fecha=fecha;
        this.cliente=cliente;
        this.moto=moto;
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
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the moto
     */
    public Moto getMoto() {
        return moto;
    }

    /**
     * @param moto the moto to set
     */
    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    /**
     * @return the tipoVenta
     */
    public String getTipoVenta() {
        return tipoVenta;
    }

    /**
     * @param tipoVenta the tipoVenta to set
     */
    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }
}
