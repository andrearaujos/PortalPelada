package br.com.portalpelada.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "convite")

public class Convite {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "con_id")
    @NotNull
    private int con_id;
	
	@Column(name="con_convidado_id", nullable=false, unique=true)
    private String con_convidado_id;

    @Column(name="con_pelada_id", nullable=false, unique=true)
    private String con_pelada_id;

	public int getCon_id() {
		return con_id;
	}

	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}

	public String getCon_convidado_id() {
		return con_convidado_id;
	}

	public void setCon_convidado_id(String con_convidado_id) {
		this.con_convidado_id = con_convidado_id;
	}

	public String getCon_pelada_id() {
		return con_pelada_id;
	}

	public void setCon_pelada_id(String con_pelada_id) {
		this.con_pelada_id = con_pelada_id;
	}
    
    

}
