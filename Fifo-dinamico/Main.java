/*
Escreva um programa que permita implementar uma lista FIFO com aloca��o din�mica de mem�ria onde sejam observados os seguintes aspectos:
1) A lista ter� encadeamento duplo;
2) Cada nodo da lista ter� 5 campos: um para armazenar o n�mero de matr�cula do funcion�rio, um para armazenar sua idade, um para armazenar o c�digo do setor de lota��o e dois para armazenarem os endere�os de mem�ria dos nodos vizinhos (anterior e posterior);
3) O programa deve mostrar o seguinte menu:
1. INSERIR
2. RETIRAR
3. MOSTRAR NA ORDEM
4. MOSTRAR INVERTIDA
5. PROCURA MATRICULA
6. PROCURA LOTACAO
7. PROCURA IDADE
8. MEDIA
9. MAIS IDOSO
10. MAIS JOVEM
11. LIMPAR
12. QUANTOS
99. VAZAR
Se a op��o 1 for selecionada, o programa pede os dados de um funcion�rio, insere-o na lista e reapresenta o menu.
Se a op��o 2 for selecionada, o programa retira um funcion�rio da lista, mostra a matr�cula do exclu�do e a reapresenta o menu.
Se a op��o 3 for selecionada, o programa mostra as matr�culas existentes na lista (na ordem em que foram inseridas) e reapresenta o menu.
Se 4 for selecionada o programa mostra as matr�culas existentes (na ordem inversa em que foram inseridas) e reapresenta o menu.
Se a op��o 5 for selecionada, o programa pede um n�mero de matr�cula, procura-o na lista, diz se ele existe e reapresenta o menu.
Se a op��o 6 for selecionada, o programa pede um n�mero de matr�cula, responde em qual setor o funcion�rio est� lotado e reapresenta o menu.
Se a op��o 7 for selecionada, o programa pede um n�mero de matr�cula, responde qual a idade dele e reapresenta o menu.
Se a op��o 8 for selecionada, o programa calcula e mostra a m�dia de idade dos funcion�rios e ent�o reapresenta o menu.
Se op��o 9 for selecionada, o programa apresenta a matr�cula do funcion�rio mais idoso e reapresenta o menu.
Se a op��o 10 for selecionada, o programa apresenta a matr�cula do funcion�rio mais jovem.
Se a op��o 11 for selecionada, o programa reinicializa a lista.
Se a op��o 12 for selecionada, o programa diz quantos funcion�rios existem na empresa e reapresenta o menu. A op��o 99 encerra.
OBS.: Construa um m�todo para cada uma das op��es do menu. Somente os m�todos correspondentes as op��es 3 e 4 do menu, al�m do m�todo main(), podem fazer I/O.
*/

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int opcao, aux, matrp;
        opcao = lerOpcaoDoMenu();

        Fifo fifo = new Fifo();

        do {
            switch (opcao) {
                case 1:
                    matrp = Integer.parseInt(JOptionPane.showInputDialog("D�gite a matricula do funcion�rio."));
                    int ida = Integer.parseInt(JOptionPane.showInputDialog("D�gite a idade do funcion�rio."));
                    int set = Integer.parseInt(JOptionPane.showInputDialog("D�gite o c�digo do setor de lota��o."));
                    fifo.inserir(matrp, ida, set);

                    opcao = lerOpcaoDoMenu();
                    break;
                case 2: {
                    aux = fifo.retirar();
                    if (aux == -99)
                        System.out.println("A lista est� vazia");
                    else
                        System.out.println("\nFoi retirado o funcion�rio com a matricula " + aux);

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 3: {
                    fifo.mostrar();

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 4: {
                    fifo.mostrarInverso();

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 5: {
                    matrp = Integer.parseInt(JOptionPane.showInputDialog("D�gite a matr�cula do funcion�rio que desejas localizar."));

                    if (fifo.procuraMatricula(matrp) == -1)
                        System.out.println("N�o foi poss�vel localizar a matr�cula " + matrp);
                    else
                        System.out.println("Foi localizado a matr�cula: " + matrp);

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 6: {
                    matrp = Integer.parseInt(JOptionPane.showInputDialog("D�gite a matr�cula do funcion�rio que desejas localizar o setor."));
                    int resultado = fifo.procuraSetor(matrp);

                    if (resultado == -1)
                        System.out.println("N�o foi poss�vel localizar a matr�cula " + matrp);
                    else
                        System.out.println("O funcion�rio com a matr�cula" + matrp + " est� lotada no setor: " + resultado);

                    opcao = lerOpcaoDoMenu();
                    break;
                }

                case 7: {
                    matrp = Integer.parseInt(JOptionPane.showInputDialog("D�gite a matr�cula do funcion�rio que desejas saber a idade."));
                    int resultado = fifo.procuraIdade(matrp);

                    if (resultado == -1)
                        System.out.println("N�o foi poss�vel localizar a matr�cula " + matrp);
                    else
                        System.out.println("O funcion�rio com a matr�cula " + matrp + " tem " + resultado + " anos de idade.");

                    opcao = lerOpcaoDoMenu();
                    break;
                }

                case 8: {
                    System.out.println("A m�dia de idade dos funcion�rios �: " + fifo.media());

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 9: {
                    System.out.println("A matr�cula do funcion�rio mais velho �: " + fifo.idoso());

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 10: {
                    System.out.println("A matr�cula do funcion�rio mais jovem �: " + fifo.jovem());

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 11: {
                    fifo.limpar();

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 12: {
                    System.out.println("Existe " + fifo.contar() + " funcion�rios nessa lista");

                    opcao = lerOpcaoDoMenu();
                    break;
                }
            }
        } while (opcao != 99);
    }

    private static Integer lerOpcaoDoMenu() {
        String menu = "[-------- Menu ---------]";
        menu += "\n[1] - Inserir";
        menu += "\n[2] - Retirar";
        menu += "\n[3] - Mostrar na ordem";
        menu += "\n[4] - Mostrar invertido ";
        menu += "\n[5] - Procura matr�cula";
        menu += "\n[6] - Procura lotacao ";
        menu += "\n[7] - Procura idade ";
        menu += "\n[8] - M�dia ";
        menu += "\n[9] - Mais idoso ";
        menu += "\n[10] - Mais jovem ";
        menu += "\n[11] - Limpar ";
        menu += "\n[12] - Quantos ";
        menu += "\n[99] - Vazar ";
        menu += "\n[ ------------------------- ]";
        menu += "\nInforme sua op��o: ";

        String strOpcao = JOptionPane.showInputDialog(null, menu);

        return Integer.parseInt(strOpcao);
    }
}
