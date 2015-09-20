
package Bean;

import javax.ejb.Stateless;

/**
 *
 * @author Breynner
 */
@Stateless
public class BeanAdmin {
 private String correoadmin;
 private String contraseadmin;
 private String idesclave;
 private String nombreesclave;
 private String contraesclave;
 private String idbus;
 
 public String getCorreoAdmin(){
     return correoadmin;
 }
 public void setCorreoAdmin(String correo){
     this.correoadmin=correo;
 }
 public String getContraAdmin(){
     return contraseadmin;
 }
 public void setContraAdmin(String contrase){
     this.contraseadmin=contrase;
 }
 public String getIdEsClave(){
     return idesclave;
 }
 public void setIdEsClave(String id){
     this.idesclave=id;
 }
  public String getNombreEsClave(){
     return nombreesclave;
 }
 public void setNombreEsClave(String nombre){
     this.nombreesclave=nombre;
 }
  public String getContraEsClave(){
     return contraesclave;
 }
 public void setContraEsClave(String contra){
     this.contraesclave=contra;
 }
 public String getIdBus(){
     return idbus;
 }
 public void setIdBus(String id){
     this.idbus=id;
 }
 
}
