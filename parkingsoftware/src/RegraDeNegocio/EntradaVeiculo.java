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
        
//        Locale BRAZIL = new Locale("pt","BR");
        
        DAOEntrada entrada = new DAOEntrada();
        boolean isEntradaOK = false;
        String DataHora = "";
        SimpleDateFormat formatSimple = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss", Locale.US);       
        DataHora = formatSimple.format(horaEntrada);
        
        if(!isCarroEstacionado(veiculo)){
             isEntradaOK = entrada.entradaDeVeiculo(veiculo, DataHora);
        }
        
        return isEntradaOK;
    }
    
    public boolean isCarroEstacionado(Veiculo  veiculo){
        return false;
    }
    
    
    public static void main(String[] args) throws IOException {
        EntradaVeiculo obj = new EntradaVeiculo();
        Veiculo objV = new Veiculo();
        
        objV.setPlaca("cba-1234");
        objV.setModelo("Ford Ka");
        
        obj.armazenarCarro(objV);
    }
}
