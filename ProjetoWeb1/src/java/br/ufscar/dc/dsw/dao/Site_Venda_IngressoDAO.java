/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Site_Venda_Ingresso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class Site_Venda_IngressoDAO {
    public Site_Venda_IngressoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/ProjetoWeb1", "root", "root");
    }

    public void insert(Site_Venda_Ingresso site) {
        String sql = "INSERT INTO Site_Venda_Ingresso (email,senha, url, nome, telefone) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;
            statement = conn.prepareStatement(sql);
            statement.setString(1, site.getEmail());
            statement.setString(2, site.getSenha());
            statement.setString(3, site.getUrl());
            statement.setString(4, site.getNome());
            statement.setString(5, site.getTelefone());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
