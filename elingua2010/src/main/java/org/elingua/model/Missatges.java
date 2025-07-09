package org.elingua.model;

/**
 * Missatges entity. @author MyEclipse Persistence Tools
 */
public class Missatges extends AbstractMissatges implements
		java.io.Serializable {


	/** Constructor per defecte */
	public Missatges() {
	}

	/** Constructor amb totes les propietats */
	public Missatges(Usuaris usuarisByReceptor, Usuaris usuarisByEmissor,
			String assumpte, String contingut) {
		super(usuarisByReceptor, usuarisByEmissor, assumpte, contingut);
	}

}
