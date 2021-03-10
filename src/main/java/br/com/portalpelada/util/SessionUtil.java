package br.com.portalpelada.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionUtil {
	
	public SessionUtil() {
	}
	
	public static SessionFactory sessionFactory;
	 
	public static SessionFactory getSessionFactory() {
	        // verificar se nossa session é null, se for passar a configuração e abrir
	        if (sessionFactory == null) {
	            // por favor dentro de try e catch para tratarmos o erro se ocorrer
	            try {
	                // instanciar o objeto para receber a configuração
	                AnnotationConfiguration annotation = new AnnotationConfiguration();
	                // vamos pedir para ler a configuração e abrir a sessão
	                sessionFactory = annotation.configure().buildSessionFactory();

	            } catch (Throwable ex) {
	                /* Throwable é o pai de todas as excessões então qualquer
	                 * excessão que ocorrer será tratada
	                 */
	                System.out.println("Erro ao inicar o Hibernte " + ex);
	                throw new ExceptionInInitializerError(ex);
	            }
	            // se td der certo retorna a sessao aberta
	            return sessionFactory;

	        } else {
	            return sessionFactory;
	        }
	    }
}
