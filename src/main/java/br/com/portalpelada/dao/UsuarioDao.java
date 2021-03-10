package br.com.portalpelada.dao;

import  br.com.portalpelada.util.SessionUtil;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


import br.com.portalpelada.model.Usuario;

public class UsuarioDao {
    private static UsuarioDao instance;

    public static UsuarioDao getInstance(){
        if (instance == null){
            instance = new UsuarioDao();
        }

        return instance;
    }
	
	public Usuario buscarUsuario(String email, String senha) {
		Usuario u = new Usuario();
		HttpSession httpSession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Session session = SessionUtil.getSessionFactory().openSession();
		Criteria crit = session.createCriteria(Usuario.class);
		try {
			crit.add(Restrictions.eq("usu_email", email));
            crit.add(Restrictions.eq("usu_senha", senha));
            List results = crit.list();
            if(results.size()>0){
                u = (Usuario)results.get(0);
                httpSession.setAttribute("usu_id", u.getUsu_id());
            }
		}finally {
            session.flush();
            session.close();
        }
		return u;
	}	
	
	public void adicionarUsuario(Usuario usuario) throws Exception{
        Transaction trns = null;
        Session session = SessionUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            throw new Exception("Error ao criar usuário");
        } finally {
            session.flush();
            session.close();
        }
    }
	
	@SuppressWarnings("unchecked")
    public List<Usuario> listar() {
    	List<Usuario> lstUsuarios = new ArrayList<Usuario>();

        Session session = SessionUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(Usuario.class);
        try {
            session.beginTransaction();
            crit.addOrder(Order.desc("nome"));
            lstUsuarios = crit.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lstUsuarios;
    }	
}
