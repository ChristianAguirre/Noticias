package uacm.edu.mx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity//va a hacer el mapeo de un objeto a una tabla entidad relación
@Table(name="usuario")//este genera la tabla en la base de datos 
public class Usuario {
	//ctrl+shif+o es para agregar todos los imports 
	//ctrl+shif+f acomoda todo el código 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
	@Size(min=4, max=30)
	@NotBlank
	private String nombre;
	@Size(min=1, max=30)
	@NotBlank
	private String apellidoP;
	@Size(min=1, max=30)
	@NotBlank
	private String apellidoM;
	@NotBlank
	@Email
	private String correo;
	@NotBlank
	private String pass;
	@NotBlank
	private String nickname;
	
	
	
	public Usuario() {
		
	}



	public Usuario( String nombre, String apellidoP, String apellidoM, String correo, String pass,
			String nickname) {
		
		
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.correo = correo;
		this.pass = pass;
		this.nickname = nickname;
	}





	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidoP() {
		return apellidoP;
	}



	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}



	public String getApellidoM() {
		return apellidoM;
	}



	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
	
	
	
}
