package controller;

public class Musica {
	String nome;
	String nomeArtista;
	int duracao;
	
	public Musica(String songName, String singerName, String timeSong) {
		this.nome = songName;
		this.nomeArtista = singerName;
		this.duracao = Integer.parseInt(timeSong);
		
	}
	
	public String toString() {
		return "[Música: "+nome+" Artista: "+nomeArtista+" Duração: "+duracao+" min]";
	}
}
