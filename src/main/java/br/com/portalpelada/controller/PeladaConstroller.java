package br.com.portalpelada.controller;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.portalpelada.dao.PeladaDao;
import br.com.portalpelada.model.Pelada;
import br.com.portalpelada.util.MessagesUtils;

@ManagedBean(name = "PeladaController")
@ViewScoped
public class PeladaConstroller implements Serializable  {
	private PeladaDao peladaDao;
    private Pelada pelada;
    private List <Pelada> lista = new ArrayList<Pelada>();

    public void PeladaController() {
    	pelada = new Pelada();
        peladaDao = new PeladaDao();
    }

    public void criarPelada() throws Exception {
        peladaDao.cadastrarPelada(pelada);  
        MessagesUtils.exigeMensagemInformacao("Gerenciamento de pelada: ", "A pelada foi incluida com sucesso!");
    }

    public void listar() {
        setLista(peladaDao.listarPelada());
    }
    
    public Pelada getPelada() {
        return pelada;
    }

    public void setPelada(Pelada pelada) {
        this.pelada = pelada;
    }

    public List<Pelada> getLista() {
        return lista;
    }

    public void setLista(List<Pelada> lista) {
        this.lista = lista;
    }
}
