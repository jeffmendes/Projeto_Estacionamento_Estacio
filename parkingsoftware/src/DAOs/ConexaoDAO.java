/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author Eduardo
 */
public class ConexaoDAO {
    private static String status = "Não conectou...";
    private static Properties config = new Properties();
    private static File arq = new File ("src\\DAOs\\config.ini");
    
    public ConexaoDAO(){
        try{
            config.load(new FileInputStream(arq));
            getConexaoMySQL();
        }catch (IOException e) {
            System.out.println("Erro no arquivo de configuracao");
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    public static java.sql.Connection getConexaoMySQL(){
        Connection conn = null;
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost";
            String mydatabase = "mysql";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = config.getProperty("username");
            String password = config.getProperty("password");
            
            conn = DriverManager.getConnection(url, username, password);
            
            if(conn != null){
                status = ("STATUS---> Conectado com Sucesso");
            }else{
                status = ("STATUS---> Nao foi possivel realizar a conexao");
            }
            
            return conn;
        }catch(ClassNotFoundException e){
            System.out.println("O driver expecificado nao foi encontrado");
            return null;
        }catch(SQLException e){
            System.out.println("Nao foi possivel conectar ao Banco de Dados");
            return null;
        }
    }
    
    public static String statusConnection(){
        return status;
    }
    
    public static boolean FecharConexao(){
        try{
            ConexaoDAO.getConexaoMySQL().close();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public static java.sql.Connection ReiniciarConexao(){
        FecharConexao();
        
        return ConexaoDAO.getConexaoMySQL();
    }
}
