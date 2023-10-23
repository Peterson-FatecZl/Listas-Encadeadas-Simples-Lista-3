package view;

import model.ListaEncadeadaSimples_TipoGenerico;

public class Principal {

	public static void main(String[] args) throws Exception {

		int[] a = { 3, 5, 8, 12, 9, 7, 16 };
		int[] b = { 9, 6, 2, 3, 7 };

		ListaEncadeadaSimples_TipoGenerico<Integer> A = new ListaEncadeadaSimples_TipoGenerico<>();
		ListaEncadeadaSimples_TipoGenerico<Integer> B = new ListaEncadeadaSimples_TipoGenerico<>();

		for (int i : a) {
			A.addLast(i);
		} // Preenche lista A
		for (int i : b) {
			B.addLast(i);
		} // Preenche lista B

		ListaEncadeadaSimples_TipoGenerico<Integer> I = new ListaEncadeadaSimples_TipoGenerico<>();
		ListaEncadeadaSimples_TipoGenerico<Integer> U = new ListaEncadeadaSimples_TipoGenerico<>();

		for (int i = 0; i < A.size(); i++) {// Percorre lista A
			int newNo = A.getValue(i);

			for (int ctd = 0; ctd < B.size(); ctd++) {// Percorre lista B
				if (newNo == B.getValue(ctd)) {// compara valor da lista A com Valor na lista B
					I.addLast(newNo);// (Intesecção) adiciona a lista I
				}
			}

		}

		for (int i = 0; i < A.size(); i++) {// Percorre lista A
			U.addLast(A.getValue(i));// preenche U
		}
		for (int ctd = 0; ctd < B.size(); ctd++) {
			boolean diferente = true;
			for (int i = 0; i < I.size(); i++) {
				if (B.getValue(ctd) == I.getValue(i)) {
					diferente = false;
				}
			}
			if (diferente == true) {
				U.addLast(B.getValue(ctd));
			}
		}
		
		/* EXIBE AS LISTAS */
		System.out.print("Lista I : ");
		for (int i = 0; i < I.size(); i++) {
			System.out.print(I.getValue(i) + " ");
		}
		System.out.println();
		System.out.print("Lista U : ");
		for (int i = 0; i < U.size(); i++) {
			System.out.print(U.getValue(i) + " ");
		}

	}

}
