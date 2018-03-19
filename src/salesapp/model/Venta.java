/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesapp.model;

import java.sql.Date;





/**
 *
 * @author GUERRA
 */
public class Venta {
    private int id;
    private double monto;
    private Date fecha;
    private Cliente cliente;
    private Moto moto;
    private String tipoVenta; // Factura, boleta, nota de credito
    private String medioPago; // Efectivo, tarjeta, transferencia
    private String seguro; // No , 1 año, 2 años , 3 años
    private boolean techoLona; 
    private boolean soat;
    private IngresoMoto ingreso;
    public Venta(){
        
    }
    
    public Venta(int id,double monto,Cliente cliente,Moto moto){
        this.id=id;
        this.monto=monto;
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
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
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

    /**
     * @return the medioPago
     */
    public String getMedioPago() {
        return medioPago;
    }

    /**
     * @param medioPago the medioPago to set
     */
    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    /**
     * @return the seguro
     */
    public String getSeguro() {
        return seguro;
    }

    /**
     * @param seguro the seguro to set
     */
    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    /**
     * @return the techoLona
     */
    public boolean isTechoLona() {
        return techoLona;
    }

    /**
     * @param techoLona the techoLona to set
     */
    public void setTechoLona(boolean techoLona) {
        this.techoLona = techoLona;
    }

    /**
     * @return the soat
     */
    public boolean isSoat() {
        return soat;
    }

    /**
     * @param soat the soat to set
     */
    public void setSoat(boolean soat) {
        this.soat = soat;
    }

    /**
     * @return the ingreso
     */
    public IngresoMoto getIngreso() {
        return ingreso;
    }

    /**
     * @param ingreso the ingreso to set
     */
    public void setIngreso(IngresoMoto ingreso) {
        this.ingreso = ingreso;
    }
}
