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
import valueobject.AutobusVO;




/**
 *
 * @author hearf
 */
public class AutobusDAO {
    
       private ConexionBD conexion;

    public AutobusDAO() {
        conexion = new ConexionBD("SYSTEM", "fg452873");
        
    }
     
    public boolean registrarAutobus(AutobusVO autobusVO) {
    
    String cadenaSQL = "  INSERT INTO LOGISTICO.AUTOBUS (AUTO_ID, AUTO_ESTADO, AUTO_MATRICULA, AUTO_CAPACIDAD, AUTO_SOAT, AUTO_TECNOMECANICA, AUTO_TARJETAOPERACIONAL)" +
     "VALUES (LOGISTICO.S_AUTO_ID.NEXTVAL,'"+autobusVO.getEstado()+"','" +autobusVO.getMatricula()+"','"+autobusVO.getCapacidad()+"','"+autobusVO.getSoat()+"','"+autobusVO.getTecnomecanica()+"','"+autobusVO.getTarjetaOperacional()+"')";
    
    
      System.out.println("cadenaSQL " + cadenaSQL);
    return conexion.executeUpdateStatement(cadenaSQL);
    }
    
    public List<AutobusVO> consultarListaAutobus(){
        String cadenaSQL = "SELECT AUTO_ID, AUTO_ESTADO, AUTO_MATRICULA, AUTO_CAPACIDAD, AUTO_SOAT, AUTO_TECNOMECANICA, AUTO_TARJETAOPERACIONAL FROM LOGISTICO.AUTOBUS";
        
        System.out.println("cadenaSQL "+cadenaSQL);
        
        ResultSet resultadoConsulta = conexion.executeQueryStatement(cadenaSQL);
        
        List<AutobusVO> listaAutobusVO = new ArrayList<>();
        
        try{
            while(resultadoConsulta.next()){
                AutobusVO autobusVO = new AutobusVO();
                
                autobusVO.setId(resultadoConsulta.getInt("AUTO_ID"));
                autobusVO.setEstado(resultadoConsulta.getString("AUTO_ESTADO"));
                autobusVO.setMatricula(resultadoConsulta.getString("AUTO_MATRICULA"));
                autobusVO.setCapacidad(resultadoConsulta.getString("AUTO_CAPACIDAD"));
                autobusVO.setSoat(resultadoConsulta.getString("AUTO_SOAT"));
                autobusVO.setTecnomecanica(resultadoConsulta.getString("AUTO_TECNOMECANICA"));
                autobusVO.setTarjetaOperacional(resultadoConsulta.getString("AUTO_TARJETAOPERACIONAL"));
                
                listaAutobusVO.add(autobusVO);                
            }
        }catch(SQLException ex){
            System.out.println("Se genero un error en el metodo consultarDepartamento() de la clase consultarDepartamento "+ ex.getMessage());
        }
        
        return listaAutobusVO;
    
    
    
 }   

    public boolean actualizarAutobus(AutobusVO autobusVO) {
        String cadenaSQL ="UPDATE LOGISTICO.AUTOBUS SET AUTO_ESTADO  = '"+autobusVO.getEstado()+"', AUTO_CAPACIDAD = '"+autobusVO.getCapacidad()+"', AUTO_SOAT = '"+autobusVO.getSoat()+"', AUTO_TECNOMECANICA ='"+autobusVO.getTecnomecanica()+"'WHERE AUTO_ID = "+autobusVO.getId();
                         
        
        
        System.out.println("cadenaSQL,"+cadenaSQL);
        
    return conexion.executeUpdateStatement(cadenaSQL);
        
    }
    
    
    
    public boolean eliminarAutobus(AutobusVO autobusVO) {
        String cadenaSQL ="DELETE FROM LOGISTICO.AUTOBUS WHERE AUTO_ID = "+autobusVO.getId();
                         
        
        
        System.out.println("cadenaSQL,"+cadenaSQL);
        
    return conexion.executeUpdateStatement(cadenaSQL);
        
    }
    
    
    
    
}
