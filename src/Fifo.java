public class Fifo {

    private int fifo[];
    private int comeco;
    private int fim;

    public Fifo(){
        fifo = new int[20];
        comeco = -1;
        fim = -1;
    }

    public boolean Inserir(int matricula){
        int aux;

        aux = (fim + 1) % fifo.length;

        if (aux != comeco){
            fim = aux;
            fifo[aux] = matricula;
            if (comeco < 0)
                comeco = 0;
            return true;
        }
        return false;
    }

    public int Retirar(){

        int volta = - 999;
        if (comeco >= 0){
            volta = fifo[comeco];
            if (comeco == fim){
                comeco =- 1;
                fim =- 1;
            }
            else {
                comeco = (comeco + 1) % fifo.length;
            }
        }
        return volta;
    }

    public void Mostra(){
        int aux;
        if(comeco == -1){
            System.out.println("lista vazia");
            return;
        }
        aux = comeco;
        System.out.print("    " + fifo[aux]);
        while (aux != fim){
            aux = (aux + 1) % fifo.length;
            System.out.print("     " + fifo[aux]);
        }
    }

    public void Detonar(){
        comeco = -1;
        fim = -1;
    }

    public int Cabeca(){
        if (comeco == -1)
            return 0;

        return fifo[comeco];
    }

    public int Populacao(){
        if (comeco == -1){
            return 0;
        }
            var resultado = fim - comeco;
            return resultado += 1;
    }

    public int Vagas(){
        if (comeco == -1){
            return 20;
        }
        var resultado = fim - comeco;
        return 20 - (resultado += 1);
    }

    public int Procurar(int matriculaBusca){
        for (int i = 0; i<20; i++){
            if (fifo[i] == matriculaBusca){
                return i;
            }
        }
        return -1;
    }
}
