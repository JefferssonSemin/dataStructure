
public class Nodo {

    public Nodo anterior;
    public Nodo posterior;
    public int Matricula;
    public int Idade;
    public int Setor;
    public int Qtd;


    Nodo(int matr, int idd, int set) {
        anterior = null;
        posterior = null;
        Matricula = matr;
        Idade = idd;
        Setor = set;
        Qtd = 0;
    }
}


