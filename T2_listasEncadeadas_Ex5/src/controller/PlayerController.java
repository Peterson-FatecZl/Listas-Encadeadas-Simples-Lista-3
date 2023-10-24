package controller;

import model.ListaEncadeadaSimples_TipoGenerico;

public class PlayerController {

	public void adicionaMusica(ListaEncadeadaSimples_TipoGenerico<Musica> lista, String musica) {
		String[] propriedadesMusica = musica.split(";");
		Musica novaMusicaAdicionada = new Musica(propriedadesMusica[0], propriedadesMusica[1], propriedadesMusica[2]);

		try {
			lista.addLast(novaMusicaAdicionada);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeMusica(ListaEncadeadaSimples_TipoGenerico<Musica> lista, int posicao) {
		try {
			lista.remove(posicao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executaPlayist(ListaEncadeadaSimples_TipoGenerico<Musica> lista) {
		try {
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.getNo(i));
				Thread.sleep(500);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
