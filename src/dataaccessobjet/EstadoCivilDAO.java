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
import valueobject.EstadoCivilVO;
/**
 *
 * @author Mauricio Pelaez
 */
public class EstadoCivilDAO {
    
    private ConexionBD conexion;
    
    public EstadoCivilDAO(){
        conexion = new ConexionBD("UNIVERSAL", "123456789");
    }
    
    public List<EstadoCivilVO> consultarEstadoCivil(){
        String cadenaSQL = "SELECT ESVI_ID, ESVI_NOMBRE FROM UNIVERSAL.ESTADOCIVIL";
        
        System.out.println("ConsultaSQL " + cadenaSQL);
        
        ResultSet resultadoConsulta = conexion.executeQueryStatement(cadenaSQL);
        
        List<EstadoCivilVO> listaEstadoCivilVO = new ArrayList<>();
        
        try {
            while (resultadoConsulta.next()) {
                EstadoCivilVO estadoCivilVO = new EstadoCivilVO();
                estadoCivilVO.setId(resultadoConsulta.getInt("ESVI_ID"));
                estadoCivilVO.setNombre(resultadoConsulta.getString("ESVI_NOMBRE"));
                
                listaEstadoCivilVO.add(estadoCivilVO);
            }
        } catch (SQLException ex) {
            System.out.println("Se genero un error en el metodo consultarEstdoCivil() de la clase EstadoCivilDAO" + ex.getMessage());
        }
        return listaEstadoCivilVO;
    }   
}


