/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccessobjet;

import conexionBD.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import valueobject.TipoDocumentoVO;

/**
 *
 * @author Mauricio Pelaez
 */
public class TipoDocumentoDAO {
    
    private ConexionBD conexion;
    
    public TipoDocumentoDAO(){
        conexion = new ConexionBD("UNIVERSAL", "123456789");
    }
    
    public List<TipoDocumentoVO> consultarTipoDocumento(){
        String cadenaSQL = "SELECT TIDO_ID, TIDO_NOMBRE, TIDO_ABREVIATURA, TIDO_ESTADO FROM UNIVERSAL.TIPODOCUMENTO";
        
        System.out.println("consultaSQL " + cadenaSQL);
        
        ResultSet resultadoConsulta =  conexion.executeQueryStatement(cadenaSQL);
        
        List<TipoDocumentoVO> listaTipoDocumentoVO = new ArrayList<>();
        
        try {
            while (resultadoConsulta.next()) {
                TipoDocumentoVO tipoDocumentoVO = new TipoDocumentoVO();
                tipoDocumentoVO.setId(resultadoConsulta.getInt("TIDO_ID"));
                tipoDocumentoVO.setNombre(resultadoConsulta.getString("TIDO_NOMBRE"));
                tipoDocumentoVO.setAbreviatura(resultadoConsulta.getString("TIDO_ABREVIATURA"));
                tipoDocumentoVO.setEstado(resultadoConsulta.getString("TIDO_ESTADO"));
                
                listaTipoDocumentoVO.add(tipoDocumentoVO);
            }
        } catch (SQLException ex) {
            System.out.println("Se genero un error en el metodo consultarTipoDocumento() de la clase TipoDocumentoDAO" + ex.getMessage());
        }
        return listaTipoDocumentoVO;
            
    }
}
