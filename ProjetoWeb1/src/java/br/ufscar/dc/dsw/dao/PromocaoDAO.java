/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Promocao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Renata
 */
public class PromocaoDAO {

    public PromocaoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/ProjetoWeb1", "root", "root");
    }

    public void insert(Promocao promocao) {
        String sql = "INSERT INTO Promocao (url,cnpj, nome, preco, data_sessao) VALUES (?, ?, ?, ?, ?)";
        try {
            System.out.println("to no DAO");
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;
            statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getUrl());
            statement.setString(2, promocao.getCnpj());
            statement.setString(3, promocao.getNome());
            statement.setFloat(4, promocao.getPreco());
            statement.setDate(5, new java.sql.Date(promocao.getData_sessao().getTime()));
            statement.executeUpdate();
            statement.close();
            conn.close();
            System.out.println("terminei o DAO");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
