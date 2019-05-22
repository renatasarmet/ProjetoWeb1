package br.ufscar.dc.dsw.converter;
 
import br.ufscar.dc.dsw.dao.SiteVendaIngressoDAO;
import br.ufscar.dc.dsw.pojo.SiteVendaIngresso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
 
@FacesConverter("SiteVendaIngressoConverter")
public class SiteVendaIngressoConverter implements Converter{
 
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.parseLong(string);
        SiteVendaIngressoDAO dao = new SiteVendaIngressoDAO();
        return dao.get(id);
    }
 
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        SiteVendaIngresso siteVendaIngresso = (SiteVendaIngresso) o;
        return siteVendaIngresso.getId().toString();
    }
}
