/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import RegraDeNegocio.Veiculo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson
 */
public class DAOSaida {
    Statement stmt = null;
    
   public boolean saidaDeVeiculo(Veiculo veiculo, String horaSaida) throws IOException{
       Connection conn = ConexaoDAO.getConexaoMySQL();
       String insertNoBanco = "UPDATE ControleDeAcesso SET HoraSaida = ? WHERE Placa = ? AND HoraSaida IS NULL";
       PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(insertNoBanco);
            stmt.setString(1, horaSaida);
            stmt.setString(2, veiculo.getPlaca());
            stmt.executeUpdate();
            return true;        
        } catch (SQLException ex) {
            Logger.getLogger(DAOSaida.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
   }
   
    public boolean buscaCarroEstacionado(Veiculo veiculo) throws IOException{
       Veiculo carroEstacionado = new Veiculo();
       
       Connection conn = ConexaoDAO.getConexaoMySQL();
       String buscaCarro = "SELECT * FROM  ControleDeAcesso WHERE Placa = 'cba-1234' AND HoraSaida IS NULL";
       
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(buscaCarro);
       
            if(rs == null){
                return false;
            }
            
            while(rs.next()){
                return true;
            }
            
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntrada.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
       
   }
}
    
