package it.polito.tdp.librettovoti;

import java.util.List;
import java.util.Map;
import java.util.*;

public class Libretto {

	private List<Voto> voti;
	private Map<String,Voto> votiMap;
	
	public Libretto() {
		this.voti=new ArrayList();
		this.votiMap = new HashMap<>();
		
	}
	
	public void add(Voto v) {
		this.voti.add(v);
		this.votiMap.put(v.getNomeEsame(), v);
		
	}
	
	public List<Voto> listaVotiUguali(int punteggio){
		List<Voto> risultato= new ArrayList();
		
		for(Voto v : this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
			}
		}
		return risultato;
		
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato=new Libretto();
		for(Voto v : this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
			}
		}
		
		return risultato;
		
	}
	
	/**
	 * Ricerca un Voto del corso di cui è specificato il nome.
	 * Se il corso non esiste, restituisce null.
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaCorso(String nomeCorso) {
	//	Voto risultato=null;
	//	for(Voto v:this.voti) {
	//		if(v.getNomeEsame().equals(nomeCorso)) {
	//			risultato=v;
	//			break;
	//		}
	//	}
		
		return this.votiMap.get(nomeCorso);
		
	}
	
	/**
	 * Il metodo controlla se quello voto è già stato inserito.
	 *Controlla se ci sia o meno duplicati
	 * @param nomeCorso
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
		boolean trovato=false;
		for(Voto v1 : this.voti) {
			if(v1.getNomeEsame().equals(v.getNomeEsame())  && v1.getVoto()==v.getVoto()) {
				trovato=true;
				break;
			}
		}
		return trovato;
	}
	
	public boolean esisteConflitto(Voto v) {
//		boolean trovato=false;
//		for(Voto v1 : this.voti) {
//			if(v1.getNomeEsame().equals(v.getNomeEsame())) {
//				if(v1.getVoto()!=v.getVoto()) {
//					trovato=true; //esiste conflito
//					break;
//				}
//			}
//		}
//		return trovato;
		
		Voto trovato=this.votiMap.get(v.getNomeEsame());
		if(trovato==null) {
			return false;
		}
		if(trovato.getVoto()!=v.getVoto()) {
			return true;		}
		else {
			return false;
		}
		
		
	}
	
	
	public String toString() {
		String s = "" ;
		for(Voto v: this.voti) {
			s = s + v.toString() + "\n" ;
		}
		return s ;
	}
}
