/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import DAOs.DAOEntrada;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class EntradaVeiculo {
    
    ///
    //Author: Eduardo Ramos
    //Metodo responsavel por enviar para o DAO o comando e o veiculo a ser adicionado
    //Param Veiculo (Veiculo que sera armazenado)
    //Return Retorna se o carro foi ou nao adicionado com sucesso
    public boolean armazenarCarro(Veiculo veiculo, Vagas [] estacionamento){
        Date horaEntrada = new Date();
        Vagas posicaoEstacionamento = new Vagas();

        while(posicaoEstacionamento.getVeiculo().getPlaca()!= null){
            for (Vagas posicao : estacionamento) {
                posicaoEstacionamento = posicao;
            }        
        }
        posicaoEstacionamento.setVeiculo(veiculo);
        posicaoEstacionamento.setHorarioEntrada(horaEntrada);
       //DAOEntrada dao = new DAOEntrada();
        
       //dao.entradaDeVeiculo(veiculo, horaEntrada);
        return false;
    }
    
    public boolean isCarroEstacionado(){
        return false;
    }
}
