package view;

import model.ListaEncadeadaSimples_TipoGenerico;

public class Principal {

	public static void main(String[] args) throws Exception {

		ListaEncadeadaSimples_TipoGenerico<Integer> L = new ListaEncadeadaSimples_TipoGenerico<>();

		int[] V = { 3, 3, 9, 6, 9, 8, 9, 5, 7, 10, 4, 8, 10, 8 };
		int[] list = { 1, 2, 6, 7, 8 };

		for (int i : list) {// preenche lista L
			L.addLast(i);
		}

		for (int i : V) {
			boolean existe = false;

			for (int ctd = 0; ctd < L.size(); ctd++) {// passsa por toda a lista
				if (i == L.getValue(ctd)) {
					existe = true;
				} // se existe então True
			}
			if (existe) {// se existe == True
				L.addLast(i);
			} else if ((i % 2) == 0) {// Senão se valor par
				L.add(i, 2);
			} else {// então é impar
				L.add(i, 1);
			}
		}
	}

}
