package br.com.portalpelada.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesUtils {
	
	public static void exigeMensagemErro(String titulo, String mensagem) {
	    FacesContext.getCurrentInstance().addMessage(
	            null,
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo,
	            		mensagem));
	}
	
	public static void exigeMensagemInformacao(String titulo, String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                		titulo,
                		mensagem));		
	}
}
