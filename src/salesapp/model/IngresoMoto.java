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
public class IngresoMoto {
    private int id;
    private Date fecha;
    private String codFactura;
    private int añoFabricacion;
    private String chasis;
    private String motor;
    private double montoFacturado;
    private int numPoliza;
    private int añoEntrada;
    private int numItem;
    private String ubicacion;
    private int idMotoModelo;
    private String estado;
    
    public IngresoMoto(){
        
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
     * @return the codFactura
     */
    public String getCodFactura() {
        return codFactura;
    }

    /**
     * @param codFactura the codFactura to set
     */
    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }

    /**
     * @return the añoFabricacion
     */
    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    /**
     * @param añoFabricacion the añoFabricacion to set
     */
    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    /**
     * @return the chasis
     */
    public String getChasis() {
        return chasis;
    }

    /**
     * @param chasis the chasis to set
     */
    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    /**
     * @return the motor
     */
    public String getMotor() {
        return motor;
    }

    /**
     * @param motor the motor to set
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }

    /**
     * @return the montoFacturado
     */
    public double getMontoFacturado() {
        return montoFacturado;
    }

    /**
     * @param montoFacturado the montoFacturado to set
     */
    public void setMontoFacturado(double montoFacturado) {
        this.montoFacturado = montoFacturado;
    }

    /**
     * @return the numPoliza
     */
    public int getNumPoliza() {
        return numPoliza;
    }

    /**
     * @param numPoliza the numPoliza to set
     */
    public void setNumPoliza(int numPoliza) {
        this.numPoliza = numPoliza;
    }

    /**
     * @return the añoEntrada
     */
    public int getAñoEntrada() {
        return añoEntrada;
    }

    /**
     * @param añoEntrada the añoEntrada to set
     */
    public void setAñoEntrada(int añoEntrada) {
        this.añoEntrada = añoEntrada;
    }

    /**
     * @return the numItem
     */
    public int getNumItem() {
        return numItem;
    }

    /**
     * @param numItem the numItem to set
     */
    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the idMotoModelo
     */
    public int getIdMotoModelo() {
        return idMotoModelo;
    }

    /**
     * @param idMotoModelo the idMotoModelo to set
     */
    public void setIdMotoModelo(int idMotoModelo) {
        this.idMotoModelo = idMotoModelo;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
