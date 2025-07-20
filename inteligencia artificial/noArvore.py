class NoArvore:
    def __init__(self, nome: int, heuristica: float = 0.0, custo_atual: float = 0.0, no_pai: 'NoArvore' = None):
        self.nome = nome
        self.noPai = no_pai

        self.g = custo_atual
        self.h = heuristica
        self.f = self.g + self.h

    def __eq__(self, outro):
        return self.nome == outro.nome

    def __repr__(self):
        return f'\033[0;31m(Nó:{self.nome}, f(n): {self.h})\033[0m'

    def atualizar_caso_menor(self, novo_no_pai, novo_custo):
        if novo_custo < self.g:
            print(f"{novo_custo}+{self.h}")
            self.noPai = novo_no_pai
            self.g = novo_custo
            self.f = self.g + self.h
