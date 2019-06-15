/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import DAOs.DAOEntrada;
import DAOs.DAOSaida;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author aluno
 */
public class SaidaVeiculo {
    
    public void removerCarro(Veiculo veiculo){
        Date horarioSaida = new Date();
        
    }
    
     public boolean atualizarCarro(Veiculo veiculo) throws IOException{
        Date horaEntrada = new Date();
        DAOSaida saida = new DAOSaida();
        
        boolean isSaidaOK = false;
        String DataHora = "";
        SimpleDateFormat formatSimple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);       
        DataHora = formatSimple.format(horaEntrada);
        
        if(isCarroEstacionado(veiculo)){
             isSaidaOK = saida.saidaDeVeiculo(veiculo, DataHora);
}
        
        return isSaidaOK;
    }
    
    public boolean isCarroEstacionado(Veiculo  veiculo) throws IOException{
        DAOSaida saida = new DAOSaida();
        return saida.buscaCarroEstacionado(veiculo);
    }
}
