package org.elingua.control;

import java.util.Map;

import org.elingua.model.Sessio;



import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Aquest interceptor proporciona autenticació per a les accions de seguretat de l'aplicació. 
 * L'interceptor fa dues coses. En primer lloc, comprova el mapa àmbit de la sessió per veure si l'objecte 
 * usuari existeix,que indica que l'usuari està logejat.
 * Si aquest objecte no està present, l'interceptor altera el flux de treball (Workflow) de la sol·licitud 
 * i retorna una cadena de control que redirecciona a la pàgina d'inici de sessió. 
 * Si l'objecte usuari és al mapa sessió, l'interceptor injecta l'objecte usuari 
 * en l'acció mitjançant una trucada al mètode SETUSER, a continuació, permet el processament de 
 * la sol·licitud per continuar.  
 * 
 * @author Marina Martin
 * @version 1.0
 */

public class AuthenticationInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}
	
	public String intercept( ActionInvocation actionInvocation ) throws Exception {

		/* Obtenim el mapa de sessió a partir del context d'invocació (el ActionContext).*/
		 
		Map session = actionInvocation.getInvocationContext().getSession();
		
		Sessio user = (Sessio) session.get("usuari");
		
		/* 
		 * Si l'usuari no existeix retorna la cadena de control LOGIN.
		 */
		if (user == null) {
		    return Action.LOGIN;
		} 
		
		
		/*
		 * Si l'usuari està logejat, agfem l'acció, injectem l'usuari i continuem l'execució
		 * de la petició invocant la resta d'interceptors de la pila (interceptor Stack) i finalment
		 * executem l'acció.
		 */
		else {
				
		    Action action = ( Action ) actionInvocation.getAction();
		    
		    if (action instanceof UserAware) {
		        ((UserAware)action).setUser(user);
		    }
		    
		    /*
		     * Continuem amb el forat recursiu de invocacions dels interceptors.
		     */
		    
		    return actionInvocation.invoke();
		}

	}
	
	
}
