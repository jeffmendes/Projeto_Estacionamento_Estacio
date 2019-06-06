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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class DAOEntrada {
   Statement stmt = null;
   private Connection conn = null;    
    
   public DAOEntrada() throws IOException{
        conn = ConexaoDAO.getConexaoMySQL();
   }
   public boolean entradaDeVeiculo(Veiculo veiculo, String horaEntrada){
       String insertNoBanco = "INSERT INTO ControleDeAcesso (HoraEntrada, Placa, modelo)"
               + "VALUES (?, ?, ?)";   
       PreparedStatement stmt = null;  
        try {
            stmt = conn.prepareStatement(insertNoBanco);
            stmt.setString(1, horaEntrada);
            stmt.setString(2, veiculo.getPlaca());
            stmt.setString(3, veiculo.getModelo());
            stmt.executeUpdate();
            return true;    
        } catch (SQLException ex) {
            Logger.getLogger(DAOEntrada.class.getName()).log(Level.SEVERE, null, ex);
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
