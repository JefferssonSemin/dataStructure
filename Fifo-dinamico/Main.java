/*
Escreva um programa que permita implementar uma lista FIFO com alocação dinâmica de memória onde sejam observados os seguintes aspectos:
1) A lista terá encadeamento duplo;
2) Cada nodo da lista terá 5 campos: um para armazenar o número de matrícula do funcionário, um para armazenar sua idade, um para armazenar o código do setor de lotação e dois para armazenarem os endereços de memória dos nodos vizinhos (anterior e posterior);
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
Se a opção 1 for selecionada, o programa pede os dados de um funcionário, insere-o na lista e reapresenta o menu.
Se a opção 2 for selecionada, o programa retira um funcionário da lista, mostra a matrícula do excluído e a reapresenta o menu.
Se a opção 3 for selecionada, o programa mostra as matrículas existentes na lista (na ordem em que foram inseridas) e reapresenta o menu.
Se 4 for selecionada o programa mostra as matrículas existentes (na ordem inversa em que foram inseridas) e reapresenta o menu.
Se a opção 5 for selecionada, o programa pede um número de matrícula, procura-o na lista, diz se ele existe e reapresenta o menu.
Se a opção 6 for selecionada, o programa pede um número de matrícula, responde em qual setor o funcionário está lotado e reapresenta o menu.
Se a opção 7 for selecionada, o programa pede um número de matrícula, responde qual a idade dele e reapresenta o menu.
Se a opção 8 for selecionada, o programa calcula e mostra a média de idade dos funcionários e então reapresenta o menu.
Se opção 9 for selecionada, o programa apresenta a matrícula do funcionário mais idoso e reapresenta o menu.
Se a opção 10 for selecionada, o programa apresenta a matrícula do funcionário mais jovem.
Se a opção 11 for selecionada, o programa reinicializa a lista.
Se a opção 12 for selecionada, o programa diz quantos funcionários existem na empresa e reapresenta o menu. A opção 99 encerra.
OBS.: Construa um método para cada uma das opções do menu. Somente os métodos correspondentes as opções 3 e 4 do menu, além do método main(), podem fazer I/O.
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
                    matrp = Integer.parseInt(JOptionPane.showInputDialog("Dígite a matricula do funcionário."));
                    int ida = Integer.parseInt(JOptionPane.showInputDialog("Dígite a idade do funcionário."));
                    int set = Integer.parseInt(JOptionPane.showInputDialog("Dígite o código do setor de lotação."));
                    fifo.inserir(matrp, ida, set);

                    opcao = lerOpcaoDoMenu();
                    break;
                case 2: {
                    aux = fifo.retirar();
                    if (aux == -99)
                        System.out.println("A lista está vazia");
                    else
                        System.out.println("\nFoi retirado o funcionário com a matricula " + aux);

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
                    matrp = Integer.parseInt(JOptionPane.showInputDialog("Dígite a matrícula do funcionário que desejas localizar."));

                    if (fifo.procuraMatricula(matrp) == -1)
                        System.out.println("Não foi possível localizar a matrícula " + matrp);
                    else
                        System.out.println("Foi localizado a matrícula: " + matrp);

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 6: {
                    matrp = Integer.parseInt(JOptionPane.showInputDialog("Dígite a matrícula do funcionário que desejas localizar o setor."));
                    int resultado = fifo.procuraSetor(matrp);

                    if (resultado == -1)
                        System.out.println("Não foi possível localizar a matrícula " + matrp);
                    else
                        System.out.println("O funcionário com a matrícula" + matrp + " está lotada no setor: " + resultado);

                    opcao = lerOpcaoDoMenu();
                    break;
                }

                case 7: {
                    matrp = Integer.parseInt(JOptionPane.showInputDialog("Dígite a matrícula do funcionário que desejas saber a idade."));
                    int resultado = fifo.procuraIdade(matrp);

                    if (resultado == -1)
                        System.out.println("Não foi possível localizar a matrícula " + matrp);
                    else
                        System.out.println("O funcionário com a matrícula " + matrp + " tem " + resultado + " anos de idade.");

                    opcao = lerOpcaoDoMenu();
                    break;
                }

                case 8: {
                    System.out.println("A média de idade dos funcionários é: " + fifo.media());

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 9: {
                    System.out.println("A matrícula do funcionário mais velho é: " + fifo.idoso());

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 10: {
                    System.out.println("A matrícula do funcionário mais jovem é: " + fifo.jovem());

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 11: {
                    fifo.limpar();

                    opcao = lerOpcaoDoMenu();
                    break;
                }
                case 12: {
                    System.out.println("Existe " + fifo.contar() + " funcionários nessa lista");

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
        menu += "\n[5] - Procura matrícula";
        menu += "\n[6] - Procura lotacao ";
        menu += "\n[7] - Procura idade ";
        menu += "\n[8] - Média ";
        menu += "\n[9] - Mais idoso ";
        menu += "\n[10] - Mais jovem ";
        menu += "\n[11] - Limpar ";
        menu += "\n[12] - Quantos ";
        menu += "\n[99] - Vazar ";
        menu += "\n[ ------------------------- ]";
        menu += "\nInforme sua opção: ";

        String strOpcao = JOptionPane.showInputDialog(null, menu);

        return Integer.parseInt(strOpcao);
    }
}
