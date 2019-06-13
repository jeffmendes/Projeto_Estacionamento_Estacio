/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
            statusConnection();
        }catch (IOException e) {
            System.out.println("Erro no arquivo de configuracao");
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    public static java.sql.Connection getConexaoMySQL() throws FileNotFoundException, IOException{
        Connection conn = null;
        try {
            
            config.load(new FileInputStream("src\\DAOs\\config.ini"));
            
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost:3306";
            String mydatabase = "parking?autoReconnect=true&useSSL=false";
            String url = "jdbc:mysql://"+serverName+"/"+ mydatabase;
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
            System.out.println("O driver especificado nao foi encontrado");
            return null;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static String statusConnection(){
        return status;
    }
    
    public static boolean FecharConexao() throws IOException{
        try{
            ConexaoDAO.getConexaoMySQL().close();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public static java.sql.Connection ReiniciarConexao() throws IOException{
        FecharConexao();
        
        return ConexaoDAO.getConexaoMySQL();
    }
}
