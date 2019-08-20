package ed.listadinamica;

public class List {
	private Node first; /* Node para referencia do inicio da lista. */
	private int numElementos; /*
								 * Um contador generico para auxiliar nos metodos
								 * de busca.
								 */
	@SuppressWarnings("unused")
	private Node temp; /*
						 * Node para auxiliar no metodo adicionar sem perder a
						 * referencia dos itens anteriores da lista.
						 */

	public List() { /*
					 * Construtor vazio, apenas para poder inicializar a lista.
					 */
	}

	public void addInfo(int info) { /* Metodo para adicionar um item a lista. */
		if (first == null) { /* Teste para verificar se a lista eh vazia. */
			first = new Node(info); /*
									 * Lista vazia - adiciona-se direto no
									 * primeiro elemento
									 */

			temp = first;
			numElementos++;
		} else { /*
					 * Condicao para adicionar na lista caso ela nao tenha um unico
					 * elemento apenas.
					 */
			Node check = first; /*
								 * Node para percorrer a lista sem perder a
								 * referencia do inicio.
								 */
			boolean valid = false; /*
									 * Booleano para validacao do teste de
									 * repeticao de item na lista.
									 */
			while (check != null) { /* Laco para percorrer a lista. */
				if (info == check.getInfo()) { /*
												 * Teste para verificar se o item
												 * que se deseja adicionar ja
												 * esta contido na lista.
												 */
					valid = true; /*
									 * Caso esteja na determinada posicao, muda-se
									 * o valor do booleano.
									 */
					break;
				} else
					check = check.getNext(); /*
												 * Caso nao esteja, pula para o
												 * proximo item da lista.
												 */
			}
			if (valid == false) { /* Checagem do item repetido. */
				if (info < first
						.getInfo()) { /*
										 * Teste para verificar se o item que
										 * deseja inserir tem valor menor que o
										 * item no inicio da lista.
										 */
					Node aux = first; /*
										 * Node auxiliar para guardar a referencia
										 * do inicio.
										 */
					Node novo = new Node(
							info); /*
									 * Criacao do node que sera a referencia para
									 * o item que estamos inserindo na lista.
									 */
					first = novo; /* Mudando a referencia do inicio. */
					novo.setNext(aux); /* Recolocando a lista em ordem. */
					temp = aux; /* Mudando a referencia da variavel auxiliar. */
					numElementos++; /*
									 * Aumentando a contagem do numero de
									 * elementos da lista.
									 */
				} else { /*
							 * Condicao para caso o item nao tenha valor menor do
							 * que o item no inicio da lista...
							 */
					Node run = first; /*
										 * Node auxiliar para percorrer a lista
										 * sem perder a referencia do inicio.
										 */
					int position = 0; /*
										 * Int para determinar a posicao em que o
										 * item sera inserido na lista.
										 */
					while (run != null) { /* Laco para percorrer a lista. */
						if (info > run.getInfo()) { /*
													 * Teste para encontrar a
													 * posicao da lista em que o
													 * item sera inserido.
													 */
							run = run.getNext(); /*
													 * Mudando as referencias para
													 * percorrer a lista.
													 */
							position++; /* Mudando a variavel posicao. */
						} else
							break; /*
									 * Caso encontre um elemento maior do que o
									 * que se deseja adicionar na lista, para de
									 * percorrer a lista.
									 */
					}

					run = first; /*
									 * Node auxiliar voltando ao seu valor inicial
									 * para percorrer novamente a lista, agora
									 * para inserir o item na posicao correta.
									 */
					for (int i = 0; i < position
							- 1; i++) {/*
										 * Laco para percorrer a lista ate o
										 * local apropriado.
										 */
						run = run.getNext(); /*
												 * Mudando a referencia do node,
												 * percorrendo a lista.
												 */
					}

					Node novo = new Node(
							info); /*
									 * Criando um node que sera a referencia do
									 * item que deseja inserir na lista.
									 */
					Node aux = run.getNext(); /*
												 * Guardando o conteudo da lista
												 * posterior a posicao onde sera
												 * inserido o elemento.
												 */
					run.setNext(novo); /*
										 * Inserindo o item na lista no local
										 * especificado.
										 */
					novo.setNext(aux); /*
										 * Recolocando o conteudo anterior da
										 * lista de volta.
										 */
					temp = aux; /* Mudando a referencia do node auxiliar. */
					numElementos++; /*
									 * E aumentando o numero de elementos na
									 * lista.
									 */
				}
			} else { /*
						 * Caso o item ja tenha sido inserido anteriormente, exibe
						 * mensagem no console.
						 */
				System.out.println("Nao foi possivel adicionar o item pois o mesmo ja foi inserido na lista.\n");
			}
		}
	}

	public boolean searchInfo(
			int consulta) { /*
							 * Se o objeto existir dentro da lista, retorna
							 * verdadeiro. Se nao, falso!
							 */
		boolean retorno = false;
		Node temp = new Node(consulta); /*
										 * Novo no que serve para comparar as
										 * infos dentro da lista.
										 */
		Node aux = first; /*
							 * Para nao perder a referencia do inicio, cria-se um
							 * auxiliar para mexer nessa posicao sem perder a
							 * referencia
							 */
		if (aux == null) { /* Teste para saber se a lista eh vazia ou nao. */
			System.out.println("Nao foi possivel consultar. Lista vazia.\n");
		} else {
			while (aux != null) { /*
									 * Condicao para percorrer a lista ate
									 * encontrar o valor.
									 */
				if (temp.getInfo() == aux
						.getInfo()) { /*
										 * Teste para saber se o valor corresponde
										 * ao passado como parametro.
										 */
					retorno = true; /*
									 * Mudando o valor do booleano caso encontre
									 * o elemento na lista.
									 */
					break;
				}
				aux = aux.getNext(); /*
										 * Transferindo a referencia do node para o
										 * proximo.
										 */
			}
			if (retorno == false) { /*
									 * Dependendo do caso eh exibida uma
									 * mensagem no console.
									 */
				System.out.println("Objeto nao encontrado.\n");
			} else {
				System.out.println("Objeto encontrado.\n");
			}
		}
		return retorno;
	}

	public void getIElement(
			int index) { /* Metodo para pegar o iesimo elemento da lista. */
		Node run = first; /*
							 * Node auxiliar para percorrer a lista sem perder a
							 * referencia do inicio.
							 */
		if (run != null) { /* Teste para saber se a lista eh vazia ou nao. */
			if (index >= 0
					&& index < numElementos) { /*
												 * Teste para saber se o indice
												 * esta contido dentro do
												 * tamanho da lista.
												 */
				for (int i = 0; i < index; i++) { /*
													 * Laco para percorrer a lista
													 * ate o indice indicado.
													 */
					run = run.getNext(); /*
											 * Passando a referencia do node para o
											 * proximo.
											 */
				}
				System.out.println(run.getInfo()
						+ "\n");/*
								 * Quando alcanca a posicao desejada, imprime no
								 * console a informacao.
								 */
			} else { /*
						 * Caso o indice passado seja incompativel com o tamanho da
						 * lista, imprime mensagem correspondente.
						 */
				System.out.println("O indice nao corresponde a nenhuma posicao da lista.\n");
			}
		} else { /*
					 * Caso a lista esteja vazia eh exibida uma mensagem no
					 * console.
					 */
			System.out.println("Nao foi possivel obter o elemento pois a lista esta vazia.\n");
		}
	}

	public void printList() { /*
								 * Metodo para imprimir todo o conteudo da lista.
								 */
		Node run = first; /*
							 * Node auxiliar para percorrer a lista sem perder a
							 * referencia do inicio.
							 */
		if (run == null) { /* Teste para saber se a lista eh vazia ou nao. */
			System.out.println("A lista esta vazia.\n");
		} else if (run.getNext() == null) { /*
											 * Teste para saber se a lista
											 * possui apenas um elemento.
											 */
			System.out.println("LISTA DE ELEMENTO UNICO\n" + run.getInfo() + "\n");
		} else { /*
					 * Caso seja composta de dois ou mais elementos, o node
					 * percorre a lista atraves do laco e imprime s informacoes
					 * na tela.
					 */
			System.out.println("TODOS OS ELEMENTOS DA LISTA\n");
			while (run.getNext() != null) { /* Laco para percorrer a lista. */
				System.out.print(run.getInfo() + " "); /*
													 * Exibindo na tela o
													 * elemento de cada posicao.
													 */
				run = run.getNext(); /*
										 * E passando a referencia para o proximo.
										 */
			}
			System.out.print(run.getInfo() + "\n\nFIM DA LISTA\n");
		}
	}

	public void drainOutList() { /* Metodo para esvaziar a lista. */
		if (first != null) { /* Teste para saber se a lista eh vazia ou nao. */
			first = null; /*
							 * Caso nao seja, apaga a referencia do inicio e
							 * consequentemente as outras, deixando a lista
							 * vazia.
							 */
			System.out
					.println("Lista esvaziada!\n"); /*
													 * Exibindo mensagem
													 * pertinente no console.
													 */
		} else { /*
					 * Caso a lista ja esteja vazia eh exibida uma mensagem no
					 * console.
					 */
			System.out.println("Impossivel limpar a lista. Lista vazia.\n");
		}
	}

	public void remove(int index) { /*
									 * Metodo para remover um elemento em
									 * determinada posicao da lista.
									 */
		Node run = first; /*
							 * Node para percorrer a lista sem perder a referencia
							 * do inicio.
							 */
		if (run != null) { /* Teste pra verificar se a lista eh nula. */
			if (index >= 0 && index < numElementos) { /*
														 * Teste pra verificar se
														 * o indice passado esta
														 * contido na lista.
														 */
				if (index == 0) { /*
									 * Condicao especial para excluir o primeiro
									 * elemento da lista.
									 */
					first = first
							.getNext(); /*
										 * Passando a referencia do inicio para
										 * o item posterior a ele. E exibindo
										 * mensagem pertinente no console.
										 */
					System.out.println("Removido com sucesso!\n");
				} else {
					for (int i = 0; i < index
							- 1; i++) { /*
										 * Laco para percorrer a lista ate
										 * chegar na posicao que se deseja
										 * excluir.
										 */
						run = run.getNext(); /*
												 * Passando a referencia para o
												 * proximo item da lista.
												 */
					}
					run.setNext(run.getNext()
							.getNext());/*
										 * Mudando a referencia do proximo item
										 * da lista e apagando a referencia do
										 * elemento que se deseja remover. E
										 * exibindo mensagem pertinente no
										 * console.
										 */
					System.out.println("Removido com sucesso!\n");
				}
			} else { /*
						 * Caso o indice nao corresponda a uma posicao da lista eh
						 * exibida mensagem no console.
						 */
				System.out
						.println("Impossivel excluir. O indice passado nao corresponde a nenhuma posicao da lista.\n");
			}
		} else { /* Caso a lista esteja vazia eh exibida mensagem no console. */
			System.out.println("Impossivel remover. Lista vazia.\n");
		}
	}
}
