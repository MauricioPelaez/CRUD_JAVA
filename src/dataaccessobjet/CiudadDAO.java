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
import valueobject.CiudadVO;

/**
 *
 * @author Mauricio Pelaez
 */
public class CiudadDAO {
   
    private ConexionBD conexion;
    
    public CiudadDAO(){
        conexion = new ConexionBD("SYSTEM", "fg452873");
    }
    
    public List<CiudadVO> consultarListaCiudad(int idDepartamento){
        String cadenaSQL = "SELECT CIUD_ID, DEPA_ID, CIUD_NOMBRE, CIUD_CODIGO FROM UNIVERSAL.CIUDAD WHERE DEPA_ID = "+ idDepartamento;
       
        System.out.println("ConsultaSQL " + cadenaSQL);
        
        ResultSet resultadoConsulta = conexion.executeQueryStatement(cadenaSQL);
        
        List<CiudadVO> listaCiudadVO = new ArrayList<>();
        
        try {
            while (resultadoConsulta.next()){
                CiudadVO ciudadVO = new CiudadVO();
                ciudadVO.setId(resultadoConsulta.getInt("CIUD_ID"));
                ciudadVO.setIdDepartamento(resultadoConsulta.getInt("DEPA_ID"));
                ciudadVO.setNombre(resultadoConsulta.getString("CIUD_NOMBRE"));
                ciudadVO.setCodigo(resultadoConsulta.getInt("CIUD_CODIGO"));
                
                listaCiudadVO.add(ciudadVO);
            }
        } catch (SQLException ex) {
            System.out.println("Se genero un error en el metodo consultarListaCiudad(int) de la clase CiudadDAO" + ex.getMessage());  
        }
        return listaCiudadVO;
    }
    
}
