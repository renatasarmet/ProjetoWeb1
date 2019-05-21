/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.bean.promocao;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.pojo.Promocao;
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
public class NovaPromocao implements Serializable {
    
    private Promocao promocao;
    
    public NovaPromocao() {
        promocao = new Promocao();
    }
    
    public Promocao getPromocao() {
        return promocao;
    }
    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }
    public String recomecar() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
    public String gravarPromocao() throws SQLException, NamingException {
        PromocaoDAO dao = new PromocaoDAO();
        dao.save(promocao);
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