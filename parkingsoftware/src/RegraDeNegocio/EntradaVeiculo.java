/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import DAOs.DAOEntrada;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
    public boolean armazenarCarro(Veiculo veiculo) throws IOException{
        Date horaEntrada = new Date();
        System.out.println("HERE");
        System.out.println("Veiculo:\n"
                + "Placa: " + veiculo.getPlaca()
                + "\nModelo: " + veiculo.getModelo()
                + "\nValor: " + veiculo.getValor());
        DAOEntrada entrada = new DAOEntrada();
        
        boolean isEntradaOK = false;
        String DataHora = "";
        SimpleDateFormat formatSimple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       
        DataHora = formatSimple.format(horaEntrada);
        
        if(!isCarroEstacionado(veiculo)){
             isEntradaOK = entrada.entradaDeVeiculo(veiculo, DataHora);
        }
        
        return isEntradaOK;
    }
    
    public boolean isCarroEstacionado(Veiculo  veiculo) throws IOException{
        DAOEntrada entrada = new DAOEntrada();
        return entrada.buscaCarroEstacionado(veiculo);
    }
}
