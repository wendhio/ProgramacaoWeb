package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/projetoweb1";
    private static final String USER = "root";
    private static final String SENHA = "";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, SENHA);
        } catch (ClassNotFoundException | SQLException ex ) {
            throw new RuntimeException("Erro na conexão!", ex);
        } 
    }
    
    public static void closeConnection(Connection con){
        if( con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexao!"+ex);
            }
        }  
    }
    public static void closeConnection(Connection con, Statement stmt){
        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexao!"+ex);
            }
        }  
        closeConnection(con);
    }
    public static void closeConnection(Connection con, Statement stmt, ResultSet rs){
        if( rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexao!"+ex);
            }
        }  
        closeConnection(con, stmt);
    }
    
    
}
