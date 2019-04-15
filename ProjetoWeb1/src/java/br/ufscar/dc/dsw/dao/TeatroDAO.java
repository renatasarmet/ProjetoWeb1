/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Teatro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author João
 */
public class TeatroDAO {

    /**
     *
     */
    public TeatroDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/ProjetoWeb1", "root", "root");
    }
    
    public void insert(Teatro teatro) {
        String sql = "INSERT INTO Teatro (email,senha, cnpj, nome, cidade) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;
            statement = conn.prepareStatement(sql);
            statement.setString(1, teatro.getEmail());
            statement.setString(2, teatro.getSenha());
            statement.setString(4, teatro.getCNPJ());
            statement.setString(4, teatro.getNome());
            statement.setString(4, teatro.getCidade());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}