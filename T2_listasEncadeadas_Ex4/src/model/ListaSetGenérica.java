package model;

public class ListaSetGenérica<T> {

	No<T> inicio;

	public boolean isEmpty() {// Lista Vazia?
		if (inicio == null) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {// Tamanho Lista
		int tamanhoList = 0;

		if (!isEmpty()) {
			No<T> auxiliar = inicio;

			while (auxiliar != null) {
				auxiliar = auxiliar.proximo;
				tamanhoList++;
			}

		}
		return tamanhoList;
	}

	public No<T> getNo(int posicaoBuscada) throws Exception {// Pega Valor na Lista

		if (isEmpty()) {// Ta Vazia?
			throw new Exception("Lista Vazia");
		}

		int tamanhoLista = size();
		if ((posicaoBuscada < 0) || (posicaoBuscada > tamanhoLista - 1)) {// Posição está dentro da Lista?
			throw new Exception("Posição Inválida");
		}

		No<T> auxiliar = inicio;
		int contador = 0;

		while (contador < posicaoBuscada) {
			contador++;
			auxiliar = auxiliar.proximo;
		}

		return auxiliar;
	}

	public void addFirst(T valor) throws Exception {// adiciona elemento ao início da lista
		boolean existe = false;

		if (isEmpty()) {
			No<T> novoInicio = new No<>();// novo Nó
			novoInicio.dado = valor; // recebe o valor do "usuário"
			novoInicio.proximo = inicio;// Aponta para o antigo nó inicial
			inicio = novoInicio; // este se torna o novo nó inicial
		} else {
			for (int i = 0; i < size(); i++) {/* Verifica se valor ja está na lista */
				if (valor == getValue(i)) {
					existe = true;
				}
			}
			if (existe == true) {
				throw new Exception(" Este Valor Já está presente na lista ");/* Fim da Verificação */
			}else {
				No<T> novoInicio = new No<>();// novo Nó
				novoInicio.dado = valor; // recebe o valor do "usuário"
				novoInicio.proximo = inicio;// Aponta para o antigo nó inicial
				inicio = novoInicio; // este se torna o novo nó inicial
			}
		}
	}

	public void addLast(T valor) throws Exception { // Adiciona valor ao final da Lista
		boolean existe = false;

		if (isEmpty()) {
			addFirst(valor);
		} else {
			for (int i = 0; i < size(); i++) {/* Verifica se valor ja está na lista */
				if (valor == getValue(i)) {
					existe = true;
				}
			}
			if (existe == true) {
				throw new Exception(" Este Valor Já está presente na lista ");/* Fim da Verificação */
			} else {
				No<T> novoFim = new No<>();
				novoFim.dado = valor;
				novoFim.proximo = null;

				No<T> ultimo = getNo(size() - 1);
				ultimo.proximo = novoFim;
			}
		}
	}

	public void add(T valor, int posicaoDesejada) throws Exception {

		boolean existe = false;
		int tamanho = size();

		if ((posicaoDesejada < 0) || (posicaoDesejada > tamanho)) {
			throw new Exception("Posição Inválida");
		}
		/* Verifica se valor ja está na lista */
		for (int i = 0; i < tamanho; i++) {
			if (valor == getValue(i)) {
				existe = true;
			}
		}
		if (existe == true) {
			throw new Exception(" Este Valor Já está presente na lista ");
		}
		/* Fim da Verificação */

		if (isEmpty()) {
			addFirst(valor);

		} else if (posicaoDesejada == tamanho) {
			addLast(valor);

		} else {
			No<T> novoNo = new No<>();
			novoNo.dado = valor;

			No<T> anterior = getNo(posicaoDesejada - 1);
			novoNo.proximo = anterior.proximo;
			anterior.proximo = novoNo;
		}

	}

	public void removeFirst() throws Exception {// remove o Primeiro Item da Lista
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		inicio = inicio.proximo;
	}

	public void removeLast() throws Exception {// Remove o último item da Lista

		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}

		int tamanho = size();

		if (tamanho == 1) {
			removeFirst();

		} else {
			No<T> penultimoNo = getNo(tamanho - 2);
			penultimoNo.proximo = null;
		}

	}

	public void remove(int posicaoQueSeraExcluida) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}

		int tamanho = size();

		if (tamanho == 1) {
			removeFirst();

		} else if (posicaoQueSeraExcluida == tamanho - 1) {
			removeLast();

		} else {
			No<T> anterior = getNo(posicaoQueSeraExcluida - 1);
			No<T> noQueSeraExcluido = getNo(posicaoQueSeraExcluida);
			anterior.proximo = noQueSeraExcluido.proximo;
		}

	}

	public T getValue(int posicaoDesejada) throws Exception {

		if (isEmpty()) {
			throw new Exception("Lista Vazia");

		} else if ((posicaoDesejada < 0) || (posicaoDesejada > size())) {
			throw new Exception("Posição Inválida");

		} else {
			No<T> auxiliar = getNo(posicaoDesejada);
			return auxiliar.dado;
		}

	}

}
