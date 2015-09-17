/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.ejb.Stateless;

/**
 *
 * @author Breynner
 */
@Stateless
public class BeanAdmin {
 private String correo;
 private String contrase;
 public String getCorreo(){
     return correo;
 }
 public void setCorreo(String correo){
     this.correo=correo;
 }
 public String getContrase(){
     return contrase;
 }
 public void setContrase(String contrase){
     this.contrase=contrase;
 }
 public String getMensaje(){
     return contrase;
 }

}
