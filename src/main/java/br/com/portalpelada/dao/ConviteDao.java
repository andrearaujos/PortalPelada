package br.com.portalpelada.dao;

import java.util.ArrayList;
import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.portalpelada.model.Convite;
import br.com.portalpelada.model.Pelada;
import br.com.portalpelada.model.Usuario;
import br.com.portalpelada.util.SessionUtil;

public class ConviteDao {
	
	public Convite bucarConvite(Integer usuarioId, Integer peladaId) {	
        Convite convite = null;
        Session session = SessionUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Convite.class);
        
        try {
            crit.add(Restrictions.eq("usu_id", usuarioId));
            crit.add(Restrictions.eq("pel_id", peladaId));
            List results = crit.list();
            if(results.size()>0){
            	convite = (Convite)results.get(0);
            }
        } finally {
            session.flush();
            session.close();
        }

        return convite;
    }

    public void salvarConvite(Convite convite) throws Exception{
        Transaction trns = null;
        Session session = SessionUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(convite);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            throw new Exception("Error ao salvar convite");
        } finally {
            session.flush();
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Convite> listar() {
        List<Convite> lista = new ArrayList<Convite>();

        Session session = SessionUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            lista = (List<Convite>) session.createCriteria(Convite.class).list();
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
