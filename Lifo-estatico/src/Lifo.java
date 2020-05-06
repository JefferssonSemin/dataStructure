/* Escreva um programa em JAVA que permita implementar uma lista LIFO, com alocação estática de memória.
 A lista vai abrigar as informações de funcionários da empresa. A solução deverá observar os seguintes aspectos:

      I.  A lista irá abrigar os números de matrícula e as idades dos funcionários;

      II. A classe correspondente à lista, deverá oferecer os seguintes métodos (e somente estes)

a)Um que permita inserir um funcionário na lista;

b)Um que permita retirar um funcionário da lista;

c)Um que permita verificar a idade média dos funcionários;

d)Um que permita verificar a idade de um determinado funcionário.
 Este método recebe como parâmetro o número de matrícula do funcionário a ser pesquisado;

e)Não é preciso desenvolver o método main().



Você terá quatro formas de enviar seu programa ao Professor:

1) colar na caixa de resposta apresentada pelo Moodle;
2) enviar por email para rheinzle@unifebe.edu.br anexando um arquivo com extensão .java;
3) enviar por email anexando um arquitvo de extensão .txt;
4) colar o código fonte no próprio corpo do email enviado.

*/

public class Lifo {
    private NodoLista topo;

    Lifo()
    {
        topo = null;
    }

    public void Inserir(int idade, int numero) {
        NodoLista aux = new NodoLista(idade, numero);
        aux.vizinho = this.topo;
        this.topo = aux;
    }

    public int Retirar() {
        int aux = -99;
        if (this.topo != null) {
            aux = this.topo.idade;
            this.topo = this.topo.vizinho;
        }

        return aux;
    }

    public void mostrar() {
        System.out.print("Veja a Lista:");

        for(NodoLista aux = this.topo; aux != null; aux = aux.vizinho) {
            System.out.print(" " + aux.idade + "        " + aux.matricula);
        }

    }

    public void IdadeMedia() {
        this.topo = null;
    }

    public void IdadeEspecifica(int matricula) {
        this.topo = null;
    }
}
