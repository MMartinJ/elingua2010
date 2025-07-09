package org.elingua.model;

import java.util.List;
import java.util.Set;


/**
 * Usuaris entity. @author MyEclipse Persistence Tools
 */
public class Sessio implements java.io.Serializable {
	
	private Integer idUsuari;
    private String nomUsuari;
    private String tipus;
    private List idiomesSap;
    private List idiomesApren;
    // Constructors

    /** default constructor */
    public Sessio() {
    }

	/** minimal constructor */
    public Sessio(int idUsuari, String nomUsuari, String tipus, List idiomesSap, List  idiomesApren) {
    		this.idUsuari = idUsuari;
    		this.nomUsuari = nomUsuari;
    		this.tipus = tipus;
    		this.idiomesSap = idiomesSap;
    		this.idiomesApren = idiomesApren;
    	
    }

	public Integer getIdUsuari() {
		return idUsuari;
	}

	public void setIdUsuari(Integer idUsuari) {
		this.idUsuari = idUsuari;
	}

	public String getNomUsuari() {
		return nomUsuari;
	}

	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	

	public List getIdiomesSap() {
		return idiomesSap;
	}

	public void setIdiomesSap(List idiomesSap) {
		this.idiomesSap = idiomesSap;
	}

	public List getIdiomesApren() {
		return idiomesApren;
	}

	public void setIdiomesApren(List idiomesApren) {
		this.idiomesApren = idiomesApren;
	}
    
    
    
   
}
