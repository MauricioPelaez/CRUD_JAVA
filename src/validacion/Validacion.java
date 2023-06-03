/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacion;

import java.util.Date;

/**
 *
 * @author Mauricio Pelaez
 */
public class Validacion {
    
   public static boolean noEsNuloVacio(String cadena){
        if(cadena != null && cadena.trim().length() > 0){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean esTexto(String cadena){
        String expresionRegular = "^[a-zA-ZñÑ-@]*$";
        if(cadena.matches(expresionRegular)){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean esNumero(String cadena){
        String expresionRegular = "^[0-9]*$";
        if(cadena.matches(expresionRegular)){
            return true;
        }else{
            return false;
        }
    }
    
    
      public static boolean esFecha(String cadena){
        String expresionRegular = "^[0-9-/]*$";
        if(cadena.matches(expresionRegular)){
            return true;
        }else{
            return false;
        }
    }

    
    
}