package br.com.portalpelada.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.portalpelada.model.Pelada;
import br.com.portalpelada.model.Usuario;
import br.com.portalpelada.util.SessionUtil;

public class PeladaDao {
    private static PeladaDao instance;

    public static PeladaDao getInstance(){
        if (instance == null){
            instance = new PeladaDao();
        }
        return instance;
    }
	
	
	public Pelada buscarPelada(String nome_pelada) {
        Pelada pelada = null;

    	Session session = SessionUtil.getSessionFactory().openSession();
    	Criteria crit = session.createCriteria(Usuario.class);
    	
        try {
            crit.add(Restrictions.eq("pel_nome_evento", nome_pelada));
            List results = crit.list();
            if(results.size()>0){
                pelada = (Pelada)results.get(0);
            }
        } finally {
            session.flush();
            session.close();
        }

        return pelada;
    }
	
	public void cadastrarPelada(Pelada pelada) throws Exception{
        Transaction trns = null;
        Session session = SessionUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(pelada);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            throw new Exception("Error ao criar pelada");
        } finally {
            session.flush();
            session.close();
        }
    }    
	
	@SuppressWarnings("unchecked")
    public List<Pelada> listarPelada() {
        List<Pelada> lista = new ArrayList<Pelada>();

        Session session = SessionUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(Pelada.class);
        try {
            session.beginTransaction();
            crit.addOrder(Order.desc("nome_evento"));
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
