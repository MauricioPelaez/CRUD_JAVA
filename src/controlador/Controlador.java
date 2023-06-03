/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dataaccessobjet.AutobusDAO;
import dataaccessobjet.CiudadDAO;
import dataaccessobjet.DepartamentoDAO;
import dataaccessobjet.EstadoCivilDAO;
import dataaccessobjet.TipoDocumentoDAO;
import java.util.List;
import valueobject.DepartamentoVO;
import valueobject.CiudadVO;
import valueobject.DepartamentoVO;
import valueobject.EstadoCivilVO;
import valueobject.TipoDocumentoVO;
import valueobject.RutaVO;
import dataaccessobjet.RutaDAO;
import valueobject.AutobusVO;
/**
 *
 * @author Mauricio Pelaez
 */
public class Controlador {
    
    private TipoDocumentoDAO tipoDocumentoDAO;
    private EstadoCivilDAO estadoCivilDAO;
    private CiudadDAO ciudadDAO;
    private DepartamentoDAO departamentoDAO;
    private RutaDAO rutaDAO;
    private AutobusDAO autobusDAO;
     
      public List<DepartamentoVO> consultarListaDepartamento(){
        departamentoDAO = new DepartamentoDAO();
        return departamentoDAO.consultarListaDepartamento();
    }
    
    public List<TipoDocumentoVO> consultarTipoDocumento(){
        tipoDocumentoDAO = new TipoDocumentoDAO();
        return tipoDocumentoDAO.consultarTipoDocumento();   
    }

    public List<EstadoCivilVO> consultarEstadoCivil() {
       estadoCivilDAO = new EstadoCivilDAO();
       return estadoCivilDAO.consultarEstadoCivil();
    }
    
     public List<CiudadVO> consultarListaCiudad(int idDepartamento) {
       ciudadDAO = new CiudadDAO();
       return ciudadDAO.consultarListaCiudad(idDepartamento);
    }
   public List<AutobusVO> consultarListaAutobus(){
        autobusDAO = new AutobusDAO();
        return autobusDAO.consultarListaAutobus();
    }
     
       public boolean registrarRuta(RutaVO rutaVO){
        rutaDAO = new RutaDAO();
        return rutaDAO.registrarRuta(rutaVO);
    }
       
    public boolean registrarAutobus(AutobusVO autobusVO){
        autobusDAO = new AutobusDAO();
        return autobusDAO.registrarAutobus(autobusVO);
    }

    public boolean actualizarAutobus(AutobusVO autobusVO) {
        autobusDAO = new AutobusDAO();
        return autobusDAO.actualizarAutobus(autobusVO);
    }
    public boolean eliminarAutobus(AutobusVO autobusVO) {
        autobusDAO = new AutobusDAO();
        return autobusDAO.eliminarAutobus(autobusVO);
    }

    
}
