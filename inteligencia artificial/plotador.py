import matplotlib.pyplot as plt
import networkx as nx
from grafo import Grafo


class Plotador:
    options = {
        "node_shape": "s",
        "node_size": 1000,
        "node_color": "white",
        "linewidths": 0.5,
        "edgecolors": "black",
        "edge_color": "grey",
        # "width": 1,
        # "with_labels": True,
        "font_weight": 'bold',
        "font_size": 8,
    }

    def __init__(self, grafo: Grafo):
        # cria a estrutura correta para a plotagem
        if grafo.grafo_direcionado:
            self.grafo = nx.DiGraph(grafo.lista_adjacencia)
        else:
            self.grafo = nx.Graph(grafo.lista_adjacencia)

        # self.posicoes = grafo.nos  # coleta a posição dos nós
        self.posicoes = nx.spring_layout(self.grafo, seed=2022)
        self.custos = nx.get_edge_attributes(self.grafo, 'custo')  # retorna um dicionário de custos de cada caminho

        # define o tamanho das imagens
        plt.figure(figsize=(9, 6))

    def lista_de_nomes_formatados(self, lista_nos_abertos, lista_nos_fechados):
        nomes_com_peso = dict()

        lista_nomes_nos_abertos = list(map(lambda x: x.nome, lista_nos_abertos))
        lista_nomes_nos_fechados = list(map(lambda x: x.nome, lista_nos_fechados))
        for no in self.grafo.nodes:
            if no not in lista_nomes_nos_abertos and no not in lista_nomes_nos_fechados:
                nomes_com_peso[no] = f"{no:.1}\n"

        for no in lista_nos_fechados:
            nomes_com_peso[no.nome] = f"{no.nome:.1}\n{no.f:.2f}"
        for no in lista_nos_abertos:
            nomes_com_peso[no.nome] = f"{no.nome:.1}\n{no.f:.2f}"
        return nomes_com_peso

    def plotar_grafo(self, lista_nos_abertos, lista_nos_fechados, caminho=None):
        plt.clf()

        if len(lista_nos_abertos) == 0 or caminho is not None:
            plt.title("Resultado final")
        else:
            plt.title("Buscando caminho...")

        nx.draw(self.grafo, self.posicoes, **Plotador.options)  # desenha o grafo inicial

        # coloca os nomes dos nós
        nx.draw_networkx_labels(self.grafo, self.posicoes,
                                font_size=Plotador.options["font_size"],
                                font_weight=Plotador.options["font_weight"],
                                labels=self.lista_de_nomes_formatados(lista_nos_abertos, lista_nos_fechados))
        # coloca os pesos nos caminhos
        nx.draw_networkx_edge_labels(self.grafo, self.posicoes, edge_labels=self.custos)

        # alterando cor dos nós fechados
        nx.draw_networkx_nodes(self.grafo,
                               self.posicoes,
                               node_shape=Plotador.options["node_shape"],
                               nodelist=list(map(lambda x: x.nome, lista_nos_fechados)),
                               node_size=Plotador.options["node_size"],
                               linewidths=Plotador.options["linewidths"],
                               edgecolors=Plotador.options["edgecolors"],
                               node_color="red")  # fechados

        # alterando cor dos nós abertos
        nx.draw_networkx_nodes(self.grafo,
                               self.posicoes,
                               node_shape=Plotador.options["node_shape"],
                               nodelist=list(map(lambda x: x.nome, lista_nos_abertos)),
                               node_size=Plotador.options["node_size"],
                               linewidths=Plotador.options["linewidths"],
                               edgecolors=Plotador.options["edgecolors"],
                               node_color="yellow")  # abertos

        # alterando cor dos nós do caminho encontrado
        if caminho is not None:
            nx.draw_networkx_nodes(self.grafo,
                                   self.posicoes,
                                   node_shape=Plotador.options["node_shape"],
                                   nodelist=caminho,
                                   linewidths=Plotador.options["linewidths"],
                                   edgecolors=Plotador.options["edgecolors"],
                                   node_size=Plotador.options["node_size"],
                                   node_color="green")

        # só avança para próximo grafo após um click
        plt.waitforbuttonpress()
