package br.com.portalpelada.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.portalpelada.model.PeladaUsuario;
import br.com.portalpelada.util.SessionUtil;

public class PeladaUsuarioDao {
	
	public PeladaUsuario buscarPeladaUsuario(Integer usuarioId, Integer peladaId) {
		PeladaUsuario peladausuario = null;
        Session session = SessionUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(PeladaUsuario.class);
        try {
            crit.add(Restrictions.eq("usuario_id", usuarioId));
            crit.add(Restrictions.eq("pelada_id", peladaId));

            List results = crit.list();
            if(results.size()>0){
            	peladausuario = (PeladaUsuario)results.get(0);
            }
        } finally {
            session.flush();
            session.close();
        }

        return peladausuario;
    }

    public void cadastrarPeladaUsuario(PeladaUsuario peladausuario) throws Exception{
        Transaction trns = null;
        Session session = SessionUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(peladausuario);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            throw new Exception("Error ao fazer inscricao");
        } finally {
            session.flush();
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<PeladaUsuario> listarPeladaUsuario() {
        List<PeladaUsuario> lista = new ArrayList<PeladaUsuario>();
        Session session = SessionUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(PeladaUsuario.class);
        try {
            session.beginTransaction();
//            lista = (List<Inscricao>) session.createCriteria(Inscricao.class).list();
            lista = crit.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lista;
    }

}
