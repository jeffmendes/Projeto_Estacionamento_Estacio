/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class Vagas {
    private Veiculo veiculo = new Veiculo();
    private Date horarioEntrada = new Date();
    private Date horarioSaida = new Date();

    /**
     * @return the veiculo
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * @return the horarioEntrada
     */
    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    /**
     * @param horarioEntrada the horarioEntrada to set
     */
    public void setHorarioEntrada(Date horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    /**
     * @return the horarioSaida
     */
    public Date getHorarioSaida() {
        return horarioSaida;
    }

    /**
     * @param horarioSaida the horarioSaida to set
     */
    public void setHorarioSaida(Date horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
    
    
    
    
    
}
