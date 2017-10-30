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
public class Cliente {
    private int id;
    private String nombres;
    private String apellidoPat;
    private String apellidoMat;
    private String dni ;
    private String direccion;
    private String estadoCivil;
    private int celular;
    private int conyugueid;
    
    public Cliente(){
        
    }
    
    public Cliente(int id, String nombres){
        this.id=id;
        this.nombres=nombres;
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
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidoPat
     */
    public String getApellidoPat() {
        return apellidoPat;
    }

    /**
     * @param apellidoPat the apellidoPat to set
     */
    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    /**
     * @return the apellidoMat
     */
    public String getApellidoMat() {
        return apellidoMat;
    }

    /**
     * @param apellidoMat the apellidoMat to set
     */
    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the celular
     */
    public int getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(int celular) {
        this.celular = celular;
    }

    /**
     * @return the conyugueid
     */
    public int getConyugueid() {
        return conyugueid;
    }

    /**
     * @param conyugueid the conyugueid to set
     */
    public void setConyugueid(int conyugueid) {
        this.conyugueid = conyugueid;
    }
}
