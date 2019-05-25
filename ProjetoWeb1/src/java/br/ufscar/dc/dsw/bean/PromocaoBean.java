package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.pojo.Promocao;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class PromocaoBean {

    private Promocao promocao;
    private String nome;

    public String lista() {
        return "promocao/index.xhtml";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String listaBusca(){
        return "index.xhtml";
    }

    public String cadastra() {
        promocao = new Promocao();
        return "form.xhtml";
    }

    public String edita(Long id) {
        PromocaoDAO dao = new PromocaoDAO();
        promocao = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        PromocaoDAO dao = new PromocaoDAO();
        if (promocao.getId() == null) {
            dao.save(promocao);
        } else {
            dao.update(promocao);
        }
        return "index.xhtml";
    }

    public String delete(Promocao promocao) {
        PromocaoDAO dao = new PromocaoDAO();
        dao.delete(promocao);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Promocao> getPromocoes() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        if(nome == null || nome.equals(""))
            return dao.getAll();
        else
            return dao.getAllTeatro(nome);
    }

    public List<Promocao> getPromocoesURL(String email) throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.getAllURL(email);
    }

    public Promocao getPromocao() {
        return promocao;
    }
}
