package br.com.portalpelada.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "peladausuario")

public class PeladaUsuario {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "pelusu_id")
    @NotNull
    private int pelusu_id;
	
	@Column(name="pelusu_usu_id", nullable=false, unique=true)
    private String pelusu_usu_id;

    @Column(name="pelusu_pel_id", nullable=false, unique=true)
    private String pelusu_pel_id;

	public int getPelusu_id() {
		return pelusu_id;
	}

	public void setPelusu_id(int pelusu_id) {
		this.pelusu_id = pelusu_id;
	}

	public String getPelusu_usu_id() {
		return pelusu_usu_id;
	}

	public void setPelusu_usu_id(String pelusu_usu_id) {
		this.pelusu_usu_id = pelusu_usu_id;
	}

	public String getPelusu_pel_id() {
		return pelusu_pel_id;
	}

	public void setPelusu_pel_id(String pelusu_pel_id) {
		this.pelusu_pel_id = pelusu_pel_id;
	}
    
    
}
