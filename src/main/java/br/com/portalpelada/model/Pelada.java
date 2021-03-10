package br.com.portalpelada.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pelada")


public class Pelada {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "pel_id")
    @NotNull
    private int pel_id;
	
	@Column(name="pel_data", nullable=false, unique=true)
    private String pel_data;

    @Column(name="pel_hora", nullable=false, unique=true)
    private String pel_hora;

    @Column(name="pel_local", nullable=false, unique=false)
    private String pel_local;

    @Column(name="pel_usu_id", nullable=false, unique=true)
    private String pel_usu_id;
    
    @Column(name="pel_nome_evento", nullable=false, unique=true)
    private String pel_nome_evento;
    

	public int getPel_id() {
		return pel_id;
	}

	public void setPel_id(int pel_id) {
		this.pel_id = pel_id;
	}

	public String getPel_data() {
		return pel_data;
	}

	public void setPel_data(String pel_data) {
		this.pel_data = pel_data;
	}

	public String getPel_hora() {
		return pel_hora;
	}

	public void setPel_hora(String pel_hora) {
		this.pel_hora = pel_hora;
	}

	public String getPel_local() {
		return pel_local;
	}

	public void setPel_local(String pel_local) {
		this.pel_local = pel_local;
	}

	public String getPel_usu_id() {
		return pel_usu_id;
	}

	public void setPel_usu_id(String pel_usu_id) {
		this.pel_usu_id = pel_usu_id;
	}

	public String getPel_nome_evento() {
		return pel_nome_evento;
	}

	public void setPel_nome_evento(String pel_nome_evento) {
		this.pel_nome_evento = pel_nome_evento;
	}
    
    
    
}
