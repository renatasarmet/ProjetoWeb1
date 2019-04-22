/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Site_Venda_Ingresso;
import br.ufscar.dc.dsw.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class Site_Venda_IngressoDAO {
    private UsuarioDAO daoUsuario ;
    
    public Site_Venda_IngressoDAO() {
        daoUsuario = new UsuarioDAO();
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
        Usuario usuario = new Usuario(site.getEmail(),site.getSenha(),site.getAtivo());
        site.setId_usuario(daoUsuario.insert(usuario));
        String sql = "INSERT INTO Site_Venda_Ingresso (id_usuario, url, nome, telefone) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setInt(1, site.getId_usuario());
            statement.setString(2, site.getUrl());
            statement.setString(3, site.getNome());
            statement.setString(4, site.getTelefone());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Site_Venda_Ingresso> getAll() {
        List<Site_Venda_Ingresso> listaSite = new ArrayList<>();
        String sql = "SELECT id, email,senha, url, nome, telefone FROM Site_Venda_Ingresso, Usuario where id = id_usuario";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id_usuario = resultSet.getInt("id");
                String url = resultSet.getString("url");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                Site_Venda_Ingresso site = new Site_Venda_Ingresso(id_usuario, email, senha, url, nome, telefone );
                listaSite.add(site);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSite;
    }

    public Site_Venda_Ingresso get(int id_usuario) {
        Usuario usuario = daoUsuario.get(id_usuario);
        Site_Venda_Ingresso site = null;
        String sql = "SELECT * FROM Site_Venda_Ingresso WHERE id_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id_usuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                site = new Site_Venda_Ingresso(id_usuario, usuario.getEmail(), usuario.getSenha(), url, nome, telefone);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }

    public void update(Site_Venda_Ingresso site) {
        Usuario usuario = new Usuario(site.getId_usuario(),site.getEmail(),site.getSenha(),site.getAtivo());
        daoUsuario.update(usuario);
        String sql = "UPDATE Site_Venda_Ingresso SET url = ?, nome = ?, telefone = ?";
        sql += " WHERE id_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site.getUrl());
            statement.setString(2, site.getNome());
            statement.setString(3, site.getTelefone());
            statement.setInt(4, site.getId_usuario());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Site_Venda_Ingresso site) {
        String sql = "DELETE FROM Site_Venda_Ingresso where id_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, site.getId_usuario());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        daoUsuario.delete(site.getId_usuario());
    }

}
