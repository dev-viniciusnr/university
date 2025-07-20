from noArvore import NoArvore
from grafo import Grafo
from plotador import Plotador


# refaz o caminho de trás para frente
def construir_caminho(no_final: NoArvore):
    caminho = []
    no_atual = no_final
    while no_atual is not None:
        caminho.append(no_atual.nome)
        no_atual = no_atual.noPai

    # retorna o caminho na ordem correta
    return caminho[::-1]


def a_estrela(grafo, nome_no_inicial, nome_no_final):
    # Criando nós iniciais
    no_inicial = NoArvore(nome=nome_no_inicial, heuristica=grafo.heuristica(nome_no_inicial, nome_no_final))
    no_objetivo = NoArvore(nome=nome_no_final)

    # Criando listas abertas e fechadas
    lista_nos_abertos = []
    lista_nos_fechados = []

    # Inserindo o nó inicial na lista de nós abertos
    lista_nos_abertos.append(no_inicial)

    # configura a plotagem
    plotador = Plotador(grafo=grafo)

    # Exibe o estado inicial
    plotador.plotar_grafo(lista_nos_abertos=lista_nos_abertos, lista_nos_fechados=lista_nos_fechados)

    # Loop para buscar o caminho
    while len(lista_nos_abertos) > 0:
        print(f"Lista abertos: {lista_nos_abertos}")
        print(f"Lista fechada: {lista_nos_fechados}")

        # Encontrando o nó com menor valor para a função de avaliação
        menor_f = lista_nos_abertos[0].f
        posicao_na_lista = 0
        for index, no_aberto in enumerate(lista_nos_abertos):
            if no_aberto.f < menor_f:
                posicao_na_lista = index
                menor_f = no_aberto.f

        # Removendo da lista aberta e adicionando na lista fechada
        no_atual = lista_nos_abertos.pop(posicao_na_lista)
        lista_nos_fechados.append(no_atual)
        print(f"Nó selecionado: {no_atual}")
        print(f"Lista abertos - após seleção: {lista_nos_abertos}")
        print(f"Lista fechada - após seleção: {lista_nos_fechados}")

        # Exibe o estado após seleção de um nó
        #plotador.plotar_passo(lista_nos_abertos, lista_nos_fechados)

        # Verificação se é o nó objetivo
        if no_atual == no_objetivo:
            caminho = construir_caminho(no_atual)  # Reconstroi o caminho encontrado para ser retornado
            print(f"\n\nCaminho encontrado: {caminho}")
            plotador.plotar_grafo(lista_nos_abertos, lista_nos_fechados, caminho)  # exibe o caminho final
            return caminho

        # Criando os nós vizinhos do nó selecionado
        vizinhos = []
        for (nome_no_vizinho, dados_caminho) in grafo.get_vizinhos(no=no_atual.nome):
            novo_no = NoArvore(nome=nome_no_vizinho,
                               no_pai=no_atual,
                               custo_atual=no_atual.g + dados_caminho["custo"],
                               heuristica=grafo.heuristica(nome_no_vizinho, no_objetivo.nome))
            vizinhos.append(novo_no)

        print(f"Vizinhos do selecionado: {vizinhos}")
        print("Verificando vizinhos que já foram fechados e atualizando para nos de custo menor\n")

        # Verificação para adicionar ou não na lista de abertos
        for vizinho in vizinhos:
            # Caso já tenha sido visitado
            if vizinho in lista_nos_fechados:
                continue

            # Caso já esteja na lista, chama a função para verificar se será atualizado
            if vizinho in lista_nos_abertos:
                for no_aberto in lista_nos_abertos:
                    if no_aberto == vizinho:
                        no_aberto.atualizar_caso_menor(novo_no_pai=no_atual, novo_custo=vizinho.g)
                        break

            # Se nenhum dos casos anteriores, apenas adiciona na lista
            else:
                lista_nos_abertos.append(vizinho)

        # Exibe o estado após abertura dos nos vizinhos
        plotador.plotar_grafo(lista_nos_abertos, lista_nos_fechados)

    # Caso não encontre o caminho
    print("\n\nCaminho não encontrado")
    return None


def main():
    nome_no_inicial = "Arad"
    nome_no_final = "Bucharest"

    a_estrela(grafo=Grafo([]), nome_no_inicial=nome_no_inicial, nome_no_final=nome_no_final)


if __name__ == '__main__':
    main()
