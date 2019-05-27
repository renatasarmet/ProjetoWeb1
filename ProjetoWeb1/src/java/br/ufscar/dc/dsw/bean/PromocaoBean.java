package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.pojo.Promocao;
import br.ufscar.dc.dsw.pojo.Teatro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PromocaoBean {

    private Promocao promocao;
    private List<Promocao> listaPromocao;
    
    private List<Teatro> listaTeatro;
    
    private String erro;

    private String nome;
    private static final String CONTEXT_URL = "/promocao/";

    public String listaBusca() {
        return CONTEXT_URL + "index.xhtml";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String lista() {
        PromocaoDAO dao = new PromocaoDAO();
        listaPromocao = dao.getAll();
        return CONTEXT_URL + "index.xhtml";
    }
    
    public String lista(String nomeUsuario, String classe){
        UsuarioDAO daoUsuario = new UsuarioDAO();
        PromocaoDAO dao = new PromocaoDAO();
        Long usuarioId = daoUsuario.get(nomeUsuario).getId();
        if(classe.equalsIgnoreCase("Teatro")){
            listaPromocao = dao.getAllTeatro(usuarioId);
        }else if(classe.equalsIgnoreCase("Site")){
            listaPromocao = dao.getAllURL(usuarioId);
        }
        return CONTEXT_URL + "index.xhtml";
    }

    public String cadastra() {
        promocao = new Promocao();
        return CONTEXT_URL + "form.xhtml";
    }
    
    public String cadastra(String nomeTeatro) {
        UsuarioDAO daoUsuario = new UsuarioDAO();
        TeatroDAO daoTeatro = new TeatroDAO();
        promocao = new Promocao();
        listaTeatro = new ArrayList<>();
        listaTeatro.add(daoTeatro.get(daoUsuario.get(nomeTeatro).getId()));
        
        return CONTEXT_URL + "form.xhtml";
    }

    public String edita(Long id) {
        PromocaoDAO dao = new PromocaoDAO();
        promocao = dao.get(id);
        return CONTEXT_URL + "form.xhtml";
    }

    public String salva() {
        PromocaoDAO dao = new PromocaoDAO();
        
        for (Promocao promocao1 : dao.getAll()) {
            if((promocao1.getData_sessao().equals(promocao.getData_sessao()))&&(promocao1.getHorario_sessao().equals(promocao.getHorario_sessao()))&&(promocao1.getTeatro().equals(promocao.getTeatro()))&&!(promocao1.getId().equals(promocao.getId()))){
                erro = "Horário conflitante";
                System.out.println("Erro: horario conflitante");
                return CONTEXT_URL + "form.xhtml";
            }
        }
        
        erro = "";
        
        if (promocao.getId() == null) {
            dao.save(promocao);
        } else {
            dao.update(promocao);
        }
        
        listaPromocao = dao.getAll();
        return CONTEXT_URL + "index.xhtml";
    }

    public String delete(Promocao promocao) {
        PromocaoDAO dao = new PromocaoDAO();
        dao.delete(promocao);
        return CONTEXT_URL + "index.xhtml";
    }

    public String volta() {
        return CONTEXT_URL + "index.xhtml?faces-redirect=true";
    }

    public List<Promocao> getPromocoes() throws SQLException {
        return listaPromocao;
    }
    
    public List<Teatro> getTeatros() {
        return listaTeatro;
    }

    public List<Promocao> getPromocoesURL(String email) throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        UsuarioDAO daoUsuario = new UsuarioDAO();
        return dao.getAllURL(daoUsuario.get(email).getId());
    }

    public Promocao getPromocao() {
        return promocao;
    }
    
    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
    
}
