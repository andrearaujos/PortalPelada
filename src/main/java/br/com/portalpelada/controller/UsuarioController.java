package br.com.portalpelada.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.portalpelada.dao.UsuarioDao;
import br.com.portalpelada.model.Usuario;
import br.com.portalpelada.util.MessagesUtils;

@ManagedBean(name = "UsuarioController")
@ViewScoped
public class UsuarioController implements Serializable  {
	
    private UsuarioDao usuarioDao;
    private Usuario usuario = new Usuario();
    private List <Usuario> lista = new ArrayList<Usuario>();

    public UsuarioController() {
        usuarioDao = new UsuarioDao();
    }

    public void incluir() throws Exception {
        usuarioDao.adicionarUsuario(usuario);        
        MessagesUtils.exigeMensagemInformacao("Inclusão de usuário: ", "O usuário foi incluido com sucesso!");
    }

    public void listar() {
        setLista(usuarioDao.listar());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
}
