/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import RegraDeNegocio.Veiculo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class DAOEntrada {
    Statement stmt = null;
    
   public boolean entradaDeVeiculo(Veiculo veiculo, Date horaEntrada){
       Connection conn = ConexaoDAO.getConexaoMySQL();
       String insertNoBanco = "INSERT INTO ";
        try {
            stmt = conn.createStatement();
            boolean rs = stmt.execute(insertNoBanco);
            
            return rs;
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntrada.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
   }
   
   public Veiculo buscaCarroEstacionado(Veiculo veiculo){
       Veiculo carroEstacionado = new Veiculo();
       
       Connection conn = ConexaoDAO.getConexaoMySQL();
       String buscaCarro = "SELECT * FROM";
       
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(buscaCarro);
       
            if(rs == null){
                return null;
            }
            
            while(rs.next()){
                
            }
            
            return carroEstacionado;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntrada.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
       
   }
}
