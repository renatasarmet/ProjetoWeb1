
/**
 *
 * @author Renata
 */

package br.ufscar.dc.dsw.bean;
 
import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.dao.PapelDAO;
import br.ufscar.dc.dsw.pojo.Teatro;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
@ManagedBean
@SessionScoped
public class TeatroBean implements Serializable {
 
    private Teatro teatro;
    private String cidade;
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
     
    public String getCidade() {
        return cidade;
    }
 
    public String lista() {
        return "teatro/index.xhtml";
    }
    public String listaBusca(){
        return "index.xhtml";
    }
 
    public String cadastra() {
        teatro = new Teatro();
        return "form.xhtml";
    }
 
    public String edita(Long id) {
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(id);
        return "form.xhtml";
    }
 
    public String salva() {
        TeatroDAO dao = new TeatroDAO();
        PapelDAO papelDAO = new PapelDAO();
        teatro.setSenha(encoder.encode(teatro.getSenha()));
        teatro.setAtivo(true);
        if (teatro.getId() == null) {
            dao.save(teatro);
            teatro.getPapel().add(papelDAO.get("ROLE_TEATRO"));
            dao.update(teatro);
        } else {
            dao.update(teatro);
        }
        return "index.xhtml";
    }
 
    public String delete(Teatro teatro) {
        TeatroDAO dao = new TeatroDAO();
        dao.delete(teatro);
        return "index.xhtml";
    }
 
    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Teatro> getTeatros() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        if(cidade == null || cidade.equals(""))
            return dao.getAll();
        else
            return dao.getAllCidade(cidade);
    }
    public List<Teatro> getTeatrosCidade() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.getAllCidade(cidade);
    }
 
    public Teatro getTeatro() {
        return teatro;
    }

    private void PapelDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
