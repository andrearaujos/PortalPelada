package br.com.portalpelada.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.portalpelada.dao.UsuarioDao;
import br.com.portalpelada.model.Usuario;
import br.com.portalpelada.util.MessagesUtils;

@ManagedBean(name = "LoginController")
@ViewScoped
public class LoginController implements Serializable  {
    private UsuarioDao usuarioDAO = new UsuarioDao();
    private Usuario usuario = new Usuario();

    public String login() {

        usuario = usuarioDAO.buscarUsuario(usuario.getUsu_email(), usuario.getUsu_senha());
        if (usuario == null) {
            usuario = new Usuario();
            
            MessagesUtils.exigeMensagemErro("Usuário não encontrado!", "Erro no Login!");            
            return null;
        } else {
            return "/home";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
