#include <iostream>
#include "hash.h" 

using namespace std;

int main(){
  Hash alunosHash(10);
   int   ras[11]   = {41, 48, 19, 12, 30};
  string nomes[11] = {"Pedro", "Raul", "Paulo", "Carlos", "Lucas"}; 
	    
  for (int i = 0; i < 11; i++) {
    Aluno aluno = Aluno(ras[i], nomes[i]);
    alunosHash.insertItem(aluno);
  }
  alunosHash.print();  
  cout << "------------------------------" <<  endl;
  
  Aluno aluno(12704,"");  
  bool     found = false;
  alunosHash.retrieveItem(aluno, found);
  cout << aluno.getNome() << " -> " << found << endl;
  
  cout << "------------------------------" <<  endl;

  alunosHash.deleteItem(aluno);
  alunosHash.print();
  cout << "Fim" << endl;  
}
