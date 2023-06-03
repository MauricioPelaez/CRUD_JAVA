/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import controlador.Controlador;
import java.util.List;
import valueobject.AutobusVO;
import valueobject.CiudadVO;
import valueobject.DepartamentoVO;
import valueobject.EstadoCivilVO;
import valueobject.TipoDocumentoVO;
import valueobject.RutaVO;
/**
 *
 * @author Mauricio Pelaez
 */
public class Fachada {
    
    private Controlador controlador;
    
    public Fachada(){
        controlador = new Controlador();
        
    }
    
    public List<TipoDocumentoVO> consultarTipoDocumento(){
        return controlador.consultarTipoDocumento();   
    }
    
      public List<EstadoCivilVO> consultarEstadoCivil(){
        return controlador.consultarEstadoCivil();  
    }
      
     public List<CiudadVO> consultarListaCiudad(int idDepartamento){
        return controlador.consultarListaCiudad(idDepartamento);  
    } 
      
      public List<DepartamentoVO> consultarListaDepartamento(){
        return controlador.consultarListaDepartamento();
    }
       public List<AutobusVO> consultarListaAutobus(){
        return controlador.consultarListaAutobus();
         }
      

      public boolean registrarRuta(RutaVO rutaVO){
        return controlador.registrarRuta(rutaVO);
       
    }
   
       public boolean registrarAutobus(AutobusVO autobusVO){
        return controlador.registrarAutobus(autobusVO);
       
    }
       
        public boolean actualizarAutobus(AutobusVO autobusVO){
        return controlador.actualizarAutobus(autobusVO);
       
    }
        public boolean eliminarAutobus(AutobusVO autobusVO){
        return controlador.eliminarAutobus(autobusVO);
       
    }
}
