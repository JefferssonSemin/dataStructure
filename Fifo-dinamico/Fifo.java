
public class Fifo {

    private Nodo comeco;
    private Nodo fim;

    Fifo() {
        comeco = null;
        fim = null;

    }

    public void Inserir(int mat, int idd, int set) {
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

    public int Retirar() {
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

    public void Mostrar() {
        Nodo aux;
        System.out.println("Veja a lista fifo a seguir: ");
        aux = comeco;
        while (aux != null) {
            System.out.println(" Matrícula: " + aux.Matricula + " Idade: " + aux.Idade + " Setor: " + aux.Setor);
            aux = aux.posterior;
        }
    }

    public void MostrarInverso() {
        Nodo aux;
        System.out.println("Veja a lista fifo inversa a seguir: ");
        aux = fim;
        while (aux != null) {
            System.out.println("Matrícula: " + aux.Matricula + " Idade: " + aux.Idade + " Setor: " + aux.Setor);
            aux = aux.anterior;
        }
    }

    public void Limpar() {
        comeco = null;
        fim = null;
    }

    public int Media() {
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

    public int ProcuraMatricula(int matriculaBusca) {
        for (Nodo aux = comeco; aux != null; aux = aux.posterior) {
            if (aux.Matricula == matriculaBusca) {
                return 1;
            }
        }
        return -1;
    }

    public int ProcuraSetor(int matriculaBusca) {
        for (Nodo aux = comeco; aux != null; aux = aux.posterior) {
            if (aux.Matricula == matriculaBusca) {
                return aux.Setor;
            }
        }
        return -1;
    }

    public int ProcuraIdade(int matriculaBusca) {
        Nodo aux;
        aux = comeco;
        for (aux = comeco; aux != null; aux = aux.posterior) {
            if (aux.Matricula == matriculaBusca) {
                return aux.Idade;
            }
        }
        return -1;
    }

    public int Idoso() {
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

    public int Jovem() {
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

    public int Contar() {
        int quantos = 0;

        for (Nodo aux = comeco; aux != null; aux = aux.posterior)
            quantos = quantos + 1;
        return quantos;
    }

    public int SetorIdoso(){
        int idade = 0;
        int setor = 0;

        for (Nodo aux = comeco; aux != null; aux = aux.posterior) {
            if (aux.Idade > idade) {
                idade = aux.Idade;
                setor = aux.Setor;
            }
        }
        return setor;
    }
    public boolean Repetido(){
            Nodo aux;
            Nodo auxb;
            for (aux=comeco; aux != null; aux = aux.posterior){
                for (auxb=aux.posterior; auxb != null; auxb = auxb.posterior) {
                    if(auxb.Matricula == aux.Matricula) {
                        return true;
                    }
                }
            }
            return false;
        }

     // Mostra todos os setores com mais de 1, porém n consegui mostrar os que retornam apenas 1 :(.
    public void Lotados(){
        Nodo aux;
        Nodo auxb;

        for (aux=comeco; aux != null; aux = aux.posterior){
            System.out.println("Há 1 funcionários no setor " + aux.Setor);
            int fun = 1;
            for (auxb= aux.posterior; auxb != null; auxb = auxb.posterior) {
                if(auxb.Setor == aux.Setor) {
                    fun++;
                    System.out.println("Há " + fun + " funcionários no setor " + auxb.Setor);
                }
            }
        }
    }
}

