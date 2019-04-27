/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Teatro;
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
 * @author João
 */
public class TeatroDAO {

    /**
     *
     */
    private UsuarioDAO daoUsuario ;

    public TeatroDAO() {
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

    public void insert(Teatro teatro) {
        Usuario usuario = new Usuario(teatro.getEmail(),teatro.getSenha(),teatro.getAtivo());
        teatro.setId_Usuario(daoUsuario.insert(usuario,2));
        String sql = "INSERT INTO Teatro (id_usuario, CNPJ, nome, cidade) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setInt(1, teatro.getId());
            statement.setString(2, teatro.getCNPJ());
            statement.setString(3, teatro.getNome());
            statement.setString(4, teatro.getCidade());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Teatro get(int id){
        Usuario usuario = daoUsuario.get(id);
        Teatro t = null;
        String query = "SELECT * FROM Teatro WHERE id_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, usuario.getId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                t = new Teatro(usuario.getId(), usuario.getEmail(), usuario.getSenha(), cnpj, nome, cidade);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
    public Teatro getByEmail(String email){
        Usuario usuario = daoUsuario.getByEmail(email);
        Teatro t = null;
        String query = "SELECT * FROM Teatro WHERE id_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, usuario.getId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                t = new Teatro(usuario.getId(), usuario.getEmail(), usuario.getSenha(), cnpj, nome, cidade);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
    
    public List<Teatro> getAll() {
        List<Teatro> listaTeatro = new ArrayList<>();
        String query = "SELECT id, email, senha, cnpj, nome, cidade FROM Teatro,Usuario where id = id_usuario";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String CNPJ = resultSet.getString("CNPJ");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                Teatro teatro = new Teatro(id, email, senha, CNPJ, nome, cidade);
                listaTeatro.add(teatro);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatro;
    }
    public List<Teatro> getTeatrosCidade(String cidade) {
        List<Teatro> listaTeatro = new ArrayList<>();
        String query = "SELECT id, email, senha, cnpj, nome, cidade FROM Teatro,Usuario where id = id_usuario and cidade = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, cidade);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String CNPJ = resultSet.getString("CNPJ");
                String nome = resultSet.getString("nome");
                Teatro teatro = new Teatro(id, email, senha, CNPJ, nome, cidade);
                listaTeatro.add(teatro);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatro;
    }

    public void update(Teatro t) {
        Usuario usuario = new Usuario(t.getId_Usuario(),t.getEmail(),t.getSenha(),t.getAtivo());
        daoUsuario.update(usuario);
        String query = "UPDATE Teatro SET nome = ?, cidade = ? WHERE id_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, t.getNome());
            statement.setString(2, t.getCidade());
            statement.setInt(3, t.getId_Usuario());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM Teatro WHERE id_usuario = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        daoUsuario.delete(id);
    }
    
        
    public String getCNPJ(String email) {
        String cnpj = "";
        String sql = "SELECT cnpj FROM Teatro, Usuario WHERE id_usuario = id and email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cnpj = resultSet.getString("cnpj");
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cnpj;
    }
}
