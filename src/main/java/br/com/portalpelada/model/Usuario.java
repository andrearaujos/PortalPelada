package br.com.portalpelada.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "usu_id")
    @NotNull
    private int usu_id;
	
	@Column(name="usu_nome_completo", nullable=false, unique=true)
    private String usu_nome_completo;

    @Column(name="usu_apelido", nullable=false, unique=true)
    private String usu_apelido;

    @Column(name="usu_senha", nullable=false, unique=false)
    private String usu_senha;

    @Column(name="usu_email", nullable=false, unique=true)
    private String usu_email;

	public int getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(int usu_id) {
		this.usu_id = usu_id;
	}

	public String getUsu_nome_completo() {
		return usu_nome_completo;
	}

	public void setUsu_nome_completo(String usu_nome_completo) {
		this.usu_nome_completo = usu_nome_completo;
	}

	public String getUsu_apelido() {
		return usu_apelido;
	}

	public void setUsu_apelido(String usu_apelido) {
		this.usu_apelido = usu_apelido;
	}

	public String getUsu_senha() {
		return usu_senha;
	}

	public void setUsu_senha(String usu_senha) {
		this.usu_senha = usu_senha;
	}

	public String getUsu_email() {
		return usu_email;
	}

	public void setUsu_email(String usu_email) {
		this.usu_email = usu_email;
	}
    
    
    

}
