package br.ufscar.dc.dsw.converter;
 
import br.ufscar.dc.dsw.dao.Site_Venda_IngressoDAO;
import br.ufscar.dc.dsw.pojo.Site_Venda_Ingresso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
 
@FacesConverter("Site_Venda_IngressoConverter")
public class Site_Venda_IngressoConverter implements Converter{
 
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.parseLong(string);
        Site_Venda_IngressoDAO dao = new Site_Venda_IngressoDAO();
        return dao.get(id);
    }
 
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Site_Venda_Ingresso site_venda_ingresso = (Site_Venda_Ingresso) o;
        return site_venda_ingresso.getId().toString();
    }
}
