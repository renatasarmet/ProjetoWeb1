
/**
 *
 * @author Renata
 */

package br.ufscar.dc.dsw.bean;
 
import br.ufscar.dc.dsw.dao.PapelDAO;
import br.ufscar.dc.dsw.dao.SiteVendaIngressoDAO;
import br.ufscar.dc.dsw.pojo.SiteVendaIngresso;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
@ManagedBean
@SessionScoped
public class SiteVendaIngressoBean implements Serializable {
 
    private SiteVendaIngresso siteVendaIngresso;
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
 
    public String lista() {
        return "site_venda_ingresso/index.xhtml";
    }
 
    public String cadastra() {
        siteVendaIngresso = new SiteVendaIngresso();
        return "form.xhtml";
    }
 
    public String edita(Long id) {
        SiteVendaIngressoDAO dao = new SiteVendaIngressoDAO();
        siteVendaIngresso = dao.get(id);
        return "form.xhtml";
    }
 
    public String salva() {
        SiteVendaIngressoDAO dao = new SiteVendaIngressoDAO();
        PapelDAO papelDAO = new PapelDAO();
        siteVendaIngresso.setSenha(encoder.encode(siteVendaIngresso.getSenha()));
        siteVendaIngresso.setAtivo(true);
        if (siteVendaIngresso.getId() == null) {
            dao.save(siteVendaIngresso);
            siteVendaIngresso.getPapel().add(papelDAO.get("ROLE_SITE"));
            dao.update(siteVendaIngresso);
        } else {
            dao.update(siteVendaIngresso);
        }
        return "index.xhtml";
    }
 
    public String delete(SiteVendaIngresso siteVendaIngresso) {
        SiteVendaIngressoDAO dao = new SiteVendaIngressoDAO();
        dao.delete(siteVendaIngresso);
        return "index.xhtml";
    }
 
    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<SiteVendaIngresso> getSites() throws SQLException {
        SiteVendaIngressoDAO dao = new SiteVendaIngressoDAO();
        return dao.getAll();
    }
 
    public SiteVendaIngresso getSiteVendaIngresso() {
        return siteVendaIngresso;
    }
}
