/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.acme.persistencia.postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;

/**
 *
 * @author marlon
 */
public class InicializadorBancoDadosDataSource {

    public static String DB_NAME = "trabalho_tp";
    public static String USER_NAME = "tecnicas";
    public static String PASSWORD = "123456";
    private static DataSource dataSource;

    public static Connection conectarBd() throws Exception {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/" + DB_NAME,
                            USER_NAME, PASSWORD);
        } catch (Exception e) {
            throw new Exception("Erro ao conectar ao banco de dados");
        }
        return c;
    }
}
