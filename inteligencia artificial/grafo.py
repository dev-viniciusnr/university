from math import radians, cos, sin, asin, sqrt

velocidade_maxima_estado = 1
preco_km = 1


def haversine(ponto1: tuple[float, float], ponto2: tuple[float, float]):
    """
    https://stackoverflow.com/questions/4913349/haversine-formula-in-python-bearing-and-distance-between-two-gps-points
    https://www.geeksforgeeks.org/program-distance-two-points-earth/
    Calculate the great circle distance in kilometers between two points
    on the earth (specified in decimal degrees)
    """
    # convert decimal degrees to radians
    lat1, lon1 = tuple(map(radians, ponto1))
    lat2, lon2 = tuple(map(radians, ponto2))

    # haversine formula
    dlon = lon2 - lon1
    dlat = lat2 - lat1
    a = sin(dlat / 2) ** 2 + cos(lat1) * cos(lat2) * sin(dlon / 2) ** 2
    c = 2 * asin(sqrt(a))
    r = 6371  # Radius of earth in kilometers. Use 3956 for miles. Determines return value units.

    return c * r  # calculate the result


class Grafo:
    def __init__(self, lista_de_nos: dict[int, tuple[float, float]],
                 grafo_direcionado: bool = True,
                 heuristica_admissivel: bool = True):

        # self.grafo_direcionado = grafo_direcionado
        self.grafo_direcionado = False

        # self.heuristica_admissivel = heuristica_admissivel
        self.heuristica_admissivel = True

        self.nos = {"Arad": (46.1856604270821, 21.310134500488864),
                    "Bucharest": (44.49876294248272, 26.092569663878148),
                    "Craiova": (44.32928064830327, 23.793616586988186),
                    "Dobreta": (44.636593438980626, 22.65732341454221),
                    "Eforie": (44.049837080666265, 28.652998213400412),
                    "Fagaras": (45.84219597319671, 24.97362919091787),
                    "Giurgiu": (43.904565409162636, 25.970241509173235),
                    "Hirsova": (44.68921804162812, 27.945828729718784),
                    "Iasi": (47.17460605614545, 27.63645128083772),
                    "Lugoj": (45.68965120079898, 21.904543215714803),
                    "Mehadia": (44.90521995042445, 22.36707421798798),
                    "Neamt": (46.93539464320847, 26.33635227393377),
                    "Oradea": (47.04643072862653, 21.91747669526824),
                    "Pitesti": (44.85652920003343, 24.869395411213784),
                    "Rimnicu Vilcea": (45.09976564487221, 24.36587289093969),
                    "Sibiu": (45.79446695540021, 24.120266856310845),
                    "Timisoara": (45.74879202892573, 21.207338477154554),
                    "Urziceni": (44.71801156060458, 26.64409425259183),
                    "Vaslui": (46.6412474784243, 27.727078708808634),
                    "Zerind": (46.62240495326818, 21.517467961616447)}

        self.lista_adjacencia = {}
        for nome_no in self.nos:
            self.lista_adjacencia[nome_no] = {}

        self.adicionar_caminho("Arad", "Zerind", 54.7)
        self.adicionar_caminho("Arad", "Sibiu", 273.0)
        self.adicionar_caminho("Arad", "Timisoara", 58.6)
        self.adicionar_caminho("Zerind", "Oradea", 60.5)
        self.adicionar_caminho("Oradea", "Sibiu", 306.0)
        self.adicionar_caminho("Timisoara", "Lugoj", 61.7)
        self.adicionar_caminho("Lugoj", "Mehadia", 112.0)
        self.adicionar_caminho("Mehadia", "Dobreta", 48.7)
        self.adicionar_caminho("Dobreta", "Craiova", 111.0)
        self.adicionar_caminho("Rimnicu Vilcea", "Sibiu", 101.0)
        self.adicionar_caminho("Rimnicu Vilcea", "Craiova", 122)
        self.adicionar_caminho("Rimnicu Vilcea", "Pitesti", 61.7)
        self.adicionar_caminho("Pitesti", "Bucharest", 120.0)
        self.adicionar_caminho("Pitesti", "Craiova", 123.0)
        self.adicionar_caminho("Sibiu", "Fagaras", 78.5)
        self.adicionar_caminho("Bucharest", "Fagaras", 245.0)
        self.adicionar_caminho("Bucharest", "Giurgiu", 62.7)
        self.adicionar_caminho("Bucharest", "Urziceni", 59.5)
        self.adicionar_caminho("Vaslui", "Urziceni", 267.0)
        self.adicionar_caminho("Hirsova", "Urziceni", 123.0)
        self.adicionar_caminho("Hirsova", "Eforie", 98.6)
        self.adicionar_caminho("Vaslui", "Iasi", 66.0)
        self.adicionar_caminho("Neamt", "Iasi", 132.0)

        # impressao da estrutura do grafo
        # for key in self.lista_adjacencia.keys():
        #     print("node", key, ": ", self.lista_adjacencia[key])

    def heuristica(self, no_partida, no_destino):
        if self.heuristica_admissivel:
            return self.heuristica_tempo(no_partida, no_destino)
        else:
            return self.heuristica_tempo(no_partida, no_destino) * 3

    def adicionar_caminho(self, no_partida, no_destino, custo):
        self.lista_adjacencia[no_partida][no_destino] = {"custo": custo}
        if not self.grafo_direcionado:
            self.lista_adjacencia[no_destino][no_partida] = {"custo": custo}

    def get_vizinhos(self, no):
        return self.lista_adjacencia[no].items()

    # def adicionar_caminho_preco(self, no_partida, no_destino, distancia, valor_pedagio=None):
    #     self.lista_adjacencia[no_partida][no_destino] = {"custo": distancia * preco_km + valor_pedagio,
    #                                                      "distancia": distancia, "valor_pedagio": valor_pedagio}
    #     if not self.grafo_direcionado:
    #         self.lista_adjacencia[no_destino][no_partida] = {"custo": distancia * preco_km + valor_pedagio,
    #                                                          "distancia": distancia, "valor_pedagio": valor_pedagio}
    #
    # def heuristica_preco(self, no_partida, no_destino):
    #     return self.haversine(self.nos[no_partida], self.nos[no_destino]) * preco_km

    def adicionar_caminho_tempo(self, no_partida, no_destino, distancia, velocidade_via):
        self.lista_adjacencia[no_partida][no_destino] = {"custo": distancia / velocidade_via,
                                                         "distancia": distancia, "velocidade": velocidade_via}
        if not self.grafo_direcionado:
            self.lista_adjacencia[no_destino][no_partida] = {"custo": distancia / velocidade_via,
                                                             "distancia": distancia, "velocidade": velocidade_via}

    def heuristica_tempo(self, no_partida, no_destino):
        return haversine(self.nos[no_partida], self.nos[no_destino]) / velocidade_maxima_estado
