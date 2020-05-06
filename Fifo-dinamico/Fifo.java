
public class Fifo {

    private Nodo comeco;
    private Nodo fim;

    Fifo() {
        comeco = null;
        fim = null;

    }

    public void inserir(int mat, int idd, int set) {
        Nodo aux;

        aux = new Nodo(mat, idd, set);
        aux.anterior = null;
        aux.posterior = null;

        if (comeco == null)
            comeco = aux;
        else
            fim.posterior = aux;
        aux.anterior = fim;
        fim = aux;
    }

    public int retirar() {
        int aux = -99;
        if (comeco != null) {
            aux = comeco.Matricula;
            comeco = comeco.posterior;
            comeco.anterior = null;
            if (comeco == null)
                fim = null;
        }
        return aux;
    }

    public void mostrar() {
        Nodo aux;
        System.out.println("Veja a lista fifo a seguir: ");
        aux = comeco;
        while (aux != null) {
            System.out.println(" Matrícula: " + aux.Matricula + " Idade: " + aux.Idade + " Setor: " + aux.Setor);
            aux = aux.posterior;
        }
    }

    public void mostrarInverso() {
        Nodo aux;
        System.out.println("Veja a lista fifo inversa a seguir: ");
        aux = fim;
        while (aux != null) {
            System.out.println("Matrícula: " + aux.Matricula + " Idade: " + aux.Idade + " Setor: " + aux.Setor);
            aux = aux.anterior;
        }
    }

    public void limpar() {
        comeco = null;
        fim = null;
    }

    public int media() {
        int qtd = 0, totalIdade = 0;

        for (Nodo aux = comeco; aux != null; aux = aux.posterior) {
            if (comeco == null) {
                return 0;
            }

            qtd = qtd + 1;
            totalIdade = totalIdade + aux.Idade;
        }

        return totalIdade / qtd;
    }

    public int procuraMatricula(int matriculaBusca) {
        for (Nodo aux = comeco; aux != null; aux = aux.posterior) {
            if (aux.Matricula == matriculaBusca) {
                return 1;
            }
        }
        return -1;
    }

    public int procuraSetor(int matriculaBusca) {
        for (Nodo aux = comeco; aux != null; aux = aux.posterior) {
            if (aux.Matricula == matriculaBusca) {
                return aux.Setor;
            }
        }
        return -1;
    }

    public int procuraIdade(int matriculaBusca) {
        Nodo aux;
        aux = comeco;
        for (aux = comeco; aux != null; aux = aux.posterior) {
            if (aux.Matricula == matriculaBusca) {
                return aux.Idade;
            }
        }
        return -1;
    }

    public int idoso() {
        int idade = 0;
        int matr = 0;

        for (Nodo aux = comeco; aux != null; aux = aux.posterior) {
            if (aux.Idade > idade) {
                idade = aux.Idade;
                matr = aux.Matricula;
            }
        }
        return matr;
    }

    public int jovem() {
        int idade = 150;
        int matr = 0;

        for (Nodo aux = comeco; aux != null; aux = aux.posterior) {
            if (aux.Idade < idade) {
                idade = aux.Idade;
                matr = aux.Matricula;
            }
        }
        return matr;
    }

    public int contar() {
        int quantos = 0;

        for (Nodo aux = comeco; aux != null; aux = aux.posterior)
            quantos = quantos + 1;
        return quantos;
    }
}

