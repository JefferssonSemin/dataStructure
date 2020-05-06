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

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Lifo minha = new Lifo();
        int opcao = lerOpcaoDoMenu();

        do {
            int aux;
            int aux2;
            switch(opcao) {
                case 1:
                    String entra = JOptionPane.showInputDialog("informe a idade ");
                    aux = Integer.parseInt(entra);
                    String entra2 = JOptionPane.showInputDialog("informe a matricula ");
                    aux2 = Integer.parseInt(entra2);
                    minha.Inserir(aux, aux2);
                    System.out.println("\nINSERIDA A IDADE" + aux);
                    opcao = lerOpcaoDoMenu();
                    break;
                case 2:
                    aux = minha.Retirar();
                    if (aux == -99) {
                        System.out.println("Lista Vazia");
                    } else {
                        System.out.println("\nRetirada a idade " + aux);
                    }

                    opcao = lerOpcaoDoMenu();
                    break;
                case 3:
                    minha.mostrar();
                    opcao = lerOpcaoDoMenu();
                    break;
                case 4:
                    //minha.detonar();
                    opcao = lerOpcaoDoMenu();
            }
        } while(opcao != 5);
    }

    private static Integer lerOpcaoDoMenu() {
        String menu = "[-------- Menu ---------]";
        menu = menu + "\n[1] - Inserir";
        menu = menu + "\n[2] - Retirar";
        menu = menu + "\n[3] - Mostrar ";
        menu = menu + "\n[4] - Detonar ";
        menu = menu + "\n[5] - Cabeca";
        menu = menu + "\n[ ------------------------- ]";
        menu = menu + "\nInforme sua opcao: ";
        String strOpcao = JOptionPane.showInputDialog((Component) null, menu);
        return Integer.parseInt(strOpcao);
    }
}
