/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luanl
 */
public class ConexaoBD {

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection("jdbc:mysql://localhost/igreja", "root", "");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getException());
        }
    }
    
//    private static final String USUARIO = "root";
//    private static final String SENHA = "";
//    private static final String URL = "jdbc:mysql://localhost/igreja";
//    private static final String DRIVER = "com.mysql.jdbc.Driver";
//
//    // Conectar ao banco
//    public static Connection abrir() throws Exception {
//        // Registrar o driver
//        Class.forName(DRIVER);
//        // Capturar a conexão
//        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
//        // Retorna a conexao aberta
//        return conn;
//
//    }
}
