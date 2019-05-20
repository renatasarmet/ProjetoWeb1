/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.projetoweb.bean.site_venda_ingresso;


import br.ufscar.dc.dsw.dao.Site_Venda_IngressoDAO;
import br.ufscar.dc.dsw.projetoweb.pojo.Site_Venda_Ingresso;
import java.io.Serializable;
import java.sql.SQLException;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.naming.NamingException;

@ManagedBean
@SessionScoped
public class Novo_Site_Venda_Ingresso implements Serializable {
    
    private Site_Venda_Ingresso site_venda_ingresso;
    
    public Novo_Site_Venda_Ingresso() {
        site_venda_ingresso = new Site_Venda_Ingresso();
    }
    
    public Site_Venda_Ingresso getSite_Venda_Ingresso() {
        return site_venda_ingresso;
    }
    public void setSite_Venda_Ingresso(Site_Venda_Ingresso site_venda_ingresso) {
        this.site_venda_ingresso = site_venda_ingresso;
    }
    public String recomecar() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
    public String gravarSite_Venda_Ingresso() throws SQLException, NamingException {
        Site_Venda_IngressoDAO dao = new Site_Venda_IngressoDAO();
        dao.save(site_venda_ingresso);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = facesContext.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        return recomecar();
    }
    public void validarEmail(FacesContext context,
            UIComponent toValidate,
            Object obj) {

        String value = (String) obj;

        if (!value.contains("@")) {
            ((UIInput) toValidate).setValid(false);
            FacesMessage message = new FacesMessage("E-mail em formato incorreto!");
            context.addMessage(toValidate.getClientId(context), message);
        }
    }
}
