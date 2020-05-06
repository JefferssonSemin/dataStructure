//escreva um programa que permita implementar uma lista fifo com alogação estatica de memoria, a lista que tera um
// tamanho maximo de 20 servira para abrigar o numero de matricula dos trabalhadores de uma empresa.

//o programa deve mostrar o seguinte menu

//Menu

//1 inserir:
//se a opçao 1 for selecionada o programa pede o numero de matricula a ser inserido, faz a operação e reapresenta o menu.

//2 retirar
//o programa retira uma matricula da fila e mostra qual foi.

//3 mostrar
//mostra a fila e reapresenta o menu.

//4 Detonar
//destroi a fila

//5 cabeça
//o programa mostra a matricula que esta na cabeça da fila.
//e reapresenta o menu.

//6 populacao
//o programa diz quantas matriculas estão na fila e reapresenta o menu.

//7 vagas
//diz quantas vagas tem na fila. e reapresenta o menu.
//8 procurar

//o programa pergunta o numero de matricula e verifica se existe na fila e diz em que posição da fila ele esta

//9 vazar

//somente o metodo Main e o meto correspondente a 3 opção do menu podem fazer I/O


import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        var fifo = new Fifo();
        int opcao = LerMenu();

        do{

            switch (opcao){
                case 1 :{
                    int matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matricula"));
                    fifo.Inserir(matricula);
                    opcao = LerMenu();
                    break;
                }
                case 2 :{
                    System.out.println("Foi removido a matricula " + fifo.Retirar());
                    opcao = LerMenu();
                    break;
                }
                case 3 :{
                    fifo.Mostra();
                    opcao = LerMenu();
                    break;
                }
                case 4 :{
                    fifo.Detonar();
                    opcao = LerMenu();
                    break;
                }
                case 5 :{
                    var valor = fifo.Cabeca();
                    if (valor == 0){
                        System.out.println("Não há uma cabeça na fila ainda");
                    }else {
                        System.out.println("A cabeça da fila é " + valor);
                    }
                    opcao = LerMenu();
                    break;
                }
                case 6 :{
                    System.out.println("A fila possui " + fifo.Populacao()+" registros");
                    opcao = LerMenu();
                    break;
                }
                case 7 :{
                    System.out.println("Há " + fifo.Vagas()+" vagas disponíveis");
                    opcao = LerMenu();
                    break;
                }
                case 8 :{

                    int matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matricula"));
                    var resultado = fifo.Procurar(matricula);

                    if (resultado == -1)
                        System.out.println("Não foi localizado a matricula");
                    else
                    System.out.println("A "+ matricula+" foi encontrada na posição " + resultado);
                    opcao = LerMenu();
                    break;
                }
            }



        }
        while(opcao != 9);

    }

    public static int LerMenu(){
        String menu = "[-------- Menu ---------]";
        menu += "\n[1] - Inserir";
        menu += "\n[2] - Retirar";
        menu += "\n[3] - Mostrar ";
        menu += "\n[4] - Detonar ";
        menu += "\n[5] - Cabeca";
        menu += "\n[6] - Populacao";
        menu += "\n[7] - vagas";
        menu += "\n[8] - Procurar";
        menu += "\n[9] - Vazar";
        menu += "\n[ ------------------------- ]";
        menu += "\nInforme sua opção: ";

        String strOpcao = JOptionPane.showInputDialog(null,menu);

        return Integer.parseInt(strOpcao);
    }
}
