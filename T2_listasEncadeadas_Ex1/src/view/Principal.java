
package view;

import model.ListaEncadeadaSimples_TipoGenerico;
import model.No_ListaEncadeada;

public class Principal {

	public static void main(String args[]) throws Exception {

		ListaEncadeadaSimples_TipoGenerico<Integer> listaInicial = new ListaEncadeadaSimples_TipoGenerico<>();

		int[] v = { 10, 5, 8, 1, 9, 2, 4, 7, 3, 6 };
		for (int ctd = 0; ctd < v.length; ctd++) {//Carrega lista
			listaInicial.addLast(v[ctd]);
		}
		for (int i = 0; i < listaInicial.size(); i++) {//Exibe lista
			No_ListaEncadeada<Integer> exibe = listaInicial.getNo(i);
			System.out.print(exibe.toString() + " ");
		}System.out.println();

		bubbleSortDaLista(listaInicial);		
		
		for (int i = 0; i < listaInicial.size(); i++) {//Exibe lista ordenada
			No_ListaEncadeada<Integer> exibe = listaInicial.getNo(i);
			System.out.print(exibe.toString() + " ");
		}

	}
	

	private static void bubbleSortDaLista(ListaEncadeadaSimples_TipoGenerico<Integer> lista) throws Exception {
		
		for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {
            	
                if (lista.getValue(j) > lista.getValue(j + 1)) {
                    // Trocar os valores dos nós
                    No_ListaEncadeada<Integer> noAtual = lista.getNo(j);
                    No_ListaEncadeada<Integer> noSeguinte = lista.getNo(j + 1);

                    Integer temporario = noAtual.dado;
                    noAtual.dado = noSeguinte.dado;
                    noSeguinte.dado = temporario;
                }
            }
        }
		
	}

}
