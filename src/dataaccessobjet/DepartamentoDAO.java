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
import valueobject.DepartamentoVO;

/**
 *
 * @author hearf
 */
public class DepartamentoDAO {
    
    
    
    private ConexionBD conexion;
    
    public DepartamentoDAO(){
        conexion = new ConexionBD("SYSTEM", "fg452873");
    }
    
    
    public List<DepartamentoVO> consultarListaDepartamento(){
        String cadenaSQL = "SELECT DEPA_ID, PAIS_ID, DEPA_NOMBRE, DEPA_CODIGO FROM UNIVERSAL.DEPARTAMENTO";
        
        System.out.println("cadenaSQL "+cadenaSQL);
        
        ResultSet resultadoConsulta = conexion.executeQueryStatement(cadenaSQL);
        
        List<DepartamentoVO> listaDepartamentoVO = new ArrayList<>();
        
        try{
            while(resultadoConsulta.next()){
                DepartamentoVO departamentoVO = new DepartamentoVO();
                
                departamentoVO.setId(resultadoConsulta.getInt("DEPA_ID"));
                departamentoVO.setIdPais(resultadoConsulta.getInt("PAIS_ID"));
                departamentoVO.setNombre(resultadoConsulta.getString("DEPA_NOMBRE"));
                departamentoVO.setCodigo(resultadoConsulta.getString("DEPA_CODIGO"));
                
                listaDepartamentoVO.add(departamentoVO);                
            }
        }catch(SQLException ex){
            System.out.println("Se genero un error en el metodo consultarDepartamento() de la clase consultarDepartamento "+ ex.getMessage());
        }
        
        return listaDepartamentoVO;
    }
    
}
    
    
    
  
    
    
    

