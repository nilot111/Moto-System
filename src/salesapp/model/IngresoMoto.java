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
public class IngresoMoto {
    private int id;
    private int codMoto;
    private String fecha;
    private int codFactura;
    private int añoFabricacion;
    private String chasis;
    private String motor;
    private double montoFacturado;
    private int numPoliza;
    private int añoEntrada;
    private int numItemVehiculo;
    private String ubicacion;
    private String placa;
    
    
    
    public IngresoMoto(){
        
    }
    
    public IngresoMoto(int id,int codMoto,String placa,String fecha,double montFactura){
        this.id=id;
        this.codMoto=codMoto;
        this.placa=placa;
        this.montoFacturado=montFactura;
        this.fecha=fecha;
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
     * @return the codMoto
     */
    public int getCodMoto() {
        return codMoto;
    }

    /**
     * @param codMoto the codMoto to set
     */
    public void setCodMoto(int codMoto) {
        this.codMoto = codMoto;
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
     * @return the codFactura
     */
    public int getCodFactura() {
        return codFactura;
    }

    /**
     * @param codFactura the codFactura to set
     */
    public void setCodFactura(int codFactura) {
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
     * @return the numItemVehiculo
     */
    public int getNumItemVehiculo() {
        return numItemVehiculo;
    }

    /**
     * @param numItemVehiculo the numItemVehiculo to set
     */
    public void setNumItemVehiculo(int numItemVehiculo) {
        this.numItemVehiculo = numItemVehiculo;
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
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
