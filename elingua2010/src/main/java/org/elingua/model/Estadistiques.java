package org.elingua.model;

import java.util.Date;

/**
 * Entitat Estadistiques.
 * 
 * @author Marina Martin
 */
public class Estadistiques extends AbstractEstadistiques implements
		java.io.Serializable {


	/** Constructor per defecte */
	public Estadistiques() {
	}

	/** Constructor amb les propietats obligatòries */
	public Estadistiques(Usuaris usuaris) {
		super(usuaris);
	}

	/** Constructor amb totes les propietats */
	public Estadistiques(Usuaris usuaris, Date ultimLog, Integer cursPub,
			Integer cursCon, Integer msmEnv, Integer msmReb) {
		super(usuaris, ultimLog, cursPub, cursCon, msmEnv, msmReb);
	}

}
