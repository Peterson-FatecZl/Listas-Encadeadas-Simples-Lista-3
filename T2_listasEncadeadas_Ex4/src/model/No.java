package model;

public class No<T> {

	public T dado;// Tipo generido de dado
	public No<T> proximo;// Ponteiro para proximo dado da lista

	public String toString() {
		return String.valueOf(dado);// Mostra como String o dado que está contido neste nó.
	}
}