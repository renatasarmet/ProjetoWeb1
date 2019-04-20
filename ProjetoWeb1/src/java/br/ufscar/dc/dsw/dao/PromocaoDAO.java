/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Promocao;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Promocao> getAll() {
        List<Promocao> listaPromocao = new ArrayList<>();
        String sql = "SELECT * FROM Promocao";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                Float preco = resultSet.getFloat("preco");
                Date data_sessao = resultSet.getDate("data_sessao");
                Promocao promo = new Promocao(id, url, cnpj, nome, preco, data_sessao);
                listaPromocao.add(promo);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocao;
    }
    
    public Promocao get(int id) {
        Promocao promo = null;
        String sql = "SELECT * FROM Promocao WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                Float preco = resultSet.getFloat("preco");
                Date data_sessao = resultSet.getDate("data_sessao");
                promo = new Promocao(id, url, cnpj, nome, preco, data_sessao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promo;
    }
}
