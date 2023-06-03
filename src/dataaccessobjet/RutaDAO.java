/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccessobjet;

import conexionBD.ConexionBD;
import java.text.SimpleDateFormat;
import valueobject.RutaVO;
/**
 *
 * @author hearf
 */
public class RutaDAO {
    
    private ConexionBD conexion;

    public RutaDAO() {
        conexion = new ConexionBD("SYSTEM", "fg452873");
        
    }
    
    public boolean registrarRuta(RutaVO rutaVO) {
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        String fechaRegistro = formatoFecha.format(rutaVO.getFechaRegistro());
        
        String cadenaSQL ="INSERT INTO LOGISTICO.RUTA (RUTA_ID,CIUD_IDORIGEN,CIUD_IDDESTINO,RUTA_TIEMPOESTIMADO,RUTA_FECHAREGISTRO,RUTA_ESTADO) " +
                "VALUES (LOGISTICO.S_RUTA_ID.NEXTVAL,'"+rutaVO.getIdOrigen()+"','" + rutaVO.getIdDestino()+"','" +rutaVO.getTiempoEstimado()+"'," +" TO_DATE('" + fechaRegistro + "','DD/MM/YYYY'), '" + rutaVO.getEstado()+"' )";
   
    System.out.println("cadenaSQL " + cadenaSQL);
    return conexion.executeUpdateStatement(cadenaSQL);
    }
    
       }
     
                                                                                                            


 
   
    
    

    
    
    
    
    
    
    
    
    
   
    
    
    

