package it.polito.tdp.librettovoti;

import java.time.LocalDate;

public class Voto {

	//POJO: Plain Old Java Object
	//Java Bean
	//Semplice contenitore di dati (non ha logica)
	
	private String nomeEsame;
	private int voto;
	private LocalDate data;
	
	/**
	 * Costruttore della classe Voto
	 * @param nome Nome del corso superato
	 * @param voto Voto ottenuto
	 * @param data Data di superamento
	 */
	public Voto(String nomeEsame, int voto, LocalDate data) {
		this.nomeEsame = nomeEsame;
		this.voto = voto;
		this.data = data;
	}

	public String getNomeEsame() {
		return nomeEsame;
	}

	public void setNomeEsame(String nomeEsame) {
		this.nomeEsame = nomeEsame;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Esame " + nomeEsame + " superato con " + voto + " il " + data ;
	}
	
	
	
}
