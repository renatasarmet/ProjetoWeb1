
/**
 *
 * @author Renata
 */

package br.ufscar.dc.dsw.bean;
 
import br.ufscar.dc.dsw.dao.Site_Venda_IngressoDAO;
import br.ufscar.dc.dsw.pojo.Site_Venda_Ingresso;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean
@SessionScoped
public class Site_Venda_IngressoBean implements Serializable {
 
    private Site_Venda_Ingresso site_venda_ingresso;
 
    public String lista() {
        return "site_venda_ingresso/index.xhtml";
    }
 
    public String cadastra() {
        site_venda_ingresso = new Site_Venda_Ingresso();
        return "form.xhtml";
    }
 
    public String edita(Long id) {
        Site_Venda_IngressoDAO dao = new Site_Venda_IngressoDAO();
        site_venda_ingresso = dao.get(id);
        return "form.xhtml";
    }
 
    public String salva() {
        Site_Venda_IngressoDAO dao = new Site_Venda_IngressoDAO();
        if (site_venda_ingresso.getId() == null) {
            dao.save(site_venda_ingresso);
        } else {
            dao.update(site_venda_ingresso);
        }
        return "index.xhtml";
    }
 
    public String delete(Site_Venda_Ingresso site_venda_ingresso) {
        Site_Venda_IngressoDAO dao = new Site_Venda_IngressoDAO();
        dao.delete(site_venda_ingresso);
        return "index.xhtml";
    }
 
    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Site_Venda_Ingresso> getSites() throws SQLException {
        Site_Venda_IngressoDAO dao = new Site_Venda_IngressoDAO();
        return dao.getAll();
    }
 
    public Site_Venda_Ingresso getSite_venda_ingresso() {
        return site_venda_ingresso;
    }
}
