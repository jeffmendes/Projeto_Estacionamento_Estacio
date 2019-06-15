/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

/**
 *
 * @author aluno
 */
public class Veiculo {
    private String placa;
    private String modelo;
    private double valor;
    
    public String getPlaca(){
        return placa;
    }
   
    public String getModelo(){
        return modelo;
    }
    
    public double getValor(){
        return valor;
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
}
