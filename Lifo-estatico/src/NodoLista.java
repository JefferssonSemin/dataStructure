public class NodoLista {
    public int idade;
    public int matricula;
    public NodoLista vizinho;

    NodoLista(int idd, int mtr)
    {
        idade = idd;
        matricula = mtr;
        vizinho = null;
    }
}
