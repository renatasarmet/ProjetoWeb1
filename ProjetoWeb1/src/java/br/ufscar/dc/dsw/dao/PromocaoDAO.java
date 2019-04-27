/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Promocao;
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

    public boolean insert(Promocao promo) {
        List<Promocao> listaPromocaoCNPJurl = new ArrayList<>();
        
        // Verificando se nao existe outra promocao com horario conflitante
        listaPromocaoCNPJurl = getAllWhereCNPJandURL(promo.getCnpj(), promo.getUrl());
        
        System.out.println(listaPromocaoCNPJurl.size());
        for(Promocao p: listaPromocaoCNPJurl){
            if((p.getData_sessao().equals(promo.getData_sessao()))&&(p.getHorario_sessao().equals(promo.getHorario_sessao()))){
                System.out.println("HORARIO CONFLITANTE");
                return false;
            }
        }
        
        String sql = "INSERT INTO Promocao (url,cnpj, nome, preco, data_sessao, horario_sessao) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;
            statement = conn.prepareStatement(sql);
            statement.setString(1, promo.getUrl());
            statement.setString(2, promo.getCnpj());
            statement.setString(3, promo.getNome());
            statement.setFloat(4, promo.getPreco());
            statement.setString(5, promo.getData_sessao());
            statement.setString(6, promo.getHorario_sessao());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return true;
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
                String data_sessao = resultSet.getString("data_sessao");
                String horario_sessao = resultSet.getString("horario_sessao");
                Promocao promo = new Promocao(id, url, cnpj, nome, preco, data_sessao, horario_sessao);
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
    
    public List<Promocao> getAllWhereCNPJandURL(String cnpj, String url) {
        List<Promocao> listaPromocao = new ArrayList<>();
        String sql = "SELECT * FROM Promocao WHERE cnpj = ? and url = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cnpj);
            statement.setString(2, url);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                Float preco = resultSet.getFloat("preco");
                String data_sessao = resultSet.getString("data_sessao");
                String horario_sessao = resultSet.getString("horario_sessao");
                Promocao promo = new Promocao(id, url, cnpj, nome, preco, data_sessao, horario_sessao);
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
                String data_sessao = resultSet.getString("data_sessao");
                String horario_sessao = resultSet.getString("horario_sessao");
                promo = new Promocao(id, url, cnpj, nome, preco, data_sessao, horario_sessao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promo;
    }
    
    public List<Promocao> getPromocaoSite(String url) {
        List<Promocao> listaPromocao = new ArrayList<>();
        String sql = "SELECT * FROM Promocao WHERE url = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, url);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
//               String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                Float preco = resultSet.getFloat("preco");
                String data_sessao = resultSet.getString("data_sessao");
                String horario_sessao = resultSet.getString("horario_sessao");
                Promocao promo = new Promocao(id, url, cnpj, nome, preco, data_sessao, horario_sessao);
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
    
    public List<Promocao> getPromocaoTeatro(String nome_teatro) {
        List<Promocao> listaPromocao = new ArrayList<>();
        String sql;
        if(nome_teatro.isEmpty())
            sql = "SELECT * FROM Promocao";
        else
            sql = "SELECT * FROM Promocao, Teatro WHERE upper(Teatro.nome) = upper( ? ) and Promocao.cnpj = Teatro.CNPJ";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            if(!nome_teatro.isEmpty())
                statement.setString(1, nome_teatro);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                Float preco = resultSet.getFloat("preco");
                String data_sessao = resultSet.getString("data_sessao");
                String horario_sessao = resultSet.getString("horario_sessao");
                Promocao promo = new Promocao(id, url, cnpj, nome, preco, data_sessao, horario_sessao);
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
    
    
    public boolean update(Promocao promo) {
        List<Promocao> listaPromocaoCNPJurl = new ArrayList<>();
        
        // Verificando se nao existe outra promocao com horario conflitante
        listaPromocaoCNPJurl = getAllWhereCNPJandURL(promo.getCnpj(), promo.getUrl());
        
        System.out.println(listaPromocaoCNPJurl.size());
        for(Promocao p: listaPromocaoCNPJurl){
            if((p.getData_sessao().equals(promo.getData_sessao()))&&(p.getHorario_sessao().equals(promo.getHorario_sessao()))){
                System.out.println("HORARIO CONFLITANTE");
                return false;
            }
        }
        
        String sql = "UPDATE Promocao SET url = ?, cnpj = ?, nome = ?, preco = ?,  data_sessao = ?,  horario_sessao = ?";
        sql += " WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promo.getUrl());
            statement.setString(2, promo.getCnpj());
            statement.setString(3, promo.getNome());
            statement.setFloat(4, promo.getPreco());
            statement.setString(5, promo.getData_sessao());
            statement.setString(6, promo.getHorario_sessao());
            statement.setInt(7, promo.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return true;
    }
    
    public void delete(Promocao promo) {
        String sql = "DELETE FROM Promocao where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, promo.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
