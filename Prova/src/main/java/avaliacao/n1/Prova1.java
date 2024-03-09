/*
 * Copyright (C) 2024 Josias Junior Santos <josiajrsantos@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package avaliacao.n1;

import java.util.Scanner;

/**
 *
 * @author Josias Junior Santos <josiajrsantos@gmail.com>
 * @date 08/03/2024
 * @brief Class Prova1
 */
public class Prova1 {

    public static void main(String[] args) {
        // Inicia as variaveis do tipo int opcao, qde de e qual tipo de café(expresso,capuccino leite com cafe,mocha,ice coffe com valor 0 e uma variavel para cafes vendidos. 
        // Inicia as variaveis do tipo double que são os valores dos cafes, também inicia valor da conta e as variaveis para a opção de pagamento.
        int opcao = 0, qde_expresso = 0, qde_capuccino = 0, qde_leite_com_cafe = 0, qde_mocha = 0, qde_ice_coffe = 0, opcao2 = 0, qde_cafes_vendidos;
        double valor_expresso, valor_capuccino, valor_leite_com_cafe, valor_mocha, valor_ice_coffe, valor_cafes_vendidos, valor_conta, pagamento_parcial, pagamento_total, restante = 0, verificando;

        Scanner sc = new Scanner(System.in);
        // Abre o loop para que seja registrado a venda de cafes.
        do {
            // Print na tela mostrando o menu com as 4 opções.
            System.out.println("Forneça uma opção: \n"
                    + "1 - café expresso; \n"
                    + "2 - café capuccino; \n"
                    + "3 - leite com café; \n"
                    + "4 - mocha; \n"
                    + "5 - ice coffe; \n"
                    + "6 - Remover item; \n"
                    + "7 - totalizar vendas;");
            // Lê qual a opcao digitada.
            opcao = sc.nextInt();
            // Inicia a condição if para saber qual a opcao digitada. E caso seja diferente de 4 ele mostra a msg "Opção inválida".
            if (opcao == 1) {
                qde_expresso++;
            } else if (opcao == 2) {
                qde_capuccino++;
            } else if (opcao == 3) {
                qde_leite_com_cafe++;
            } else if (opcao == 4) {
                qde_mocha++;
            } else if (opcao == 5) {
                qde_ice_coffe++;
            } else if (opcao == 6) {
                System.out.println("Escolha o item que ira remover");
                System.out.println("1 - Expresso: " + qde_expresso);
                System.out.println("2 - Capuccino: " + qde_capuccino );
                System.out.println("3 - Leite com cafe: " + qde_leite_com_cafe );
                System.out.println("4 - Mocha: " + qde_mocha );
                System.out.println("5 - Ice Coffe: " + qde_ice_coffe);
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        qde_expresso--;
                        break;
                    case 2:
                        qde_capuccino--;
                        break;
                    case 3:
                        qde_leite_com_cafe--;
                        break;
                    case 4:
                        qde_mocha--;
                        break;
                    case 5:
                        qde_ice_coffe--;
                        break;
                    default:
                        break;
                }
            } else if (opcao != 7) {
                System.out.println("Opção inválida");
            }

        } //  a condição para que o loop se encerre 
        while (opcao != 7);

        valor_expresso = qde_expresso * 0.75;
        valor_capuccino = qde_capuccino;
        valor_leite_com_cafe = qde_leite_com_cafe * 1.25;
        valor_mocha = qde_mocha * 1.00;
        valor_ice_coffe = qde_ice_coffe * 1.50;
        qde_cafes_vendidos = qde_expresso + qde_capuccino + qde_leite_com_cafe + qde_mocha + qde_ice_coffe;
        valor_cafes_vendidos = valor_expresso + valor_capuccino + valor_leite_com_cafe + valor_mocha + valor_ice_coffe;
        valor_conta = valor_cafes_vendidos;
        System.out.println("Qde café expresso: " + qde_expresso + " ­ valor: " + valor_expresso);
        System.out.println("Qde capuccino: " + qde_capuccino + " ­ valor: " + valor_capuccino);
        System.out.println("Qde leite com café: " + qde_leite_com_cafe + " ­ valor: " + valor_leite_com_cafe);
        System.out.println("Qde mocha: " + qde_mocha + " ­ valor: " + valor_mocha);
        System.out.println("Qde ice coffe: " + qde_ice_coffe + " ­ valor: " + valor_ice_coffe);
        System.out.println("Qde cafés vendidos: " + qde_cafes_vendidos + " ­ valor cafés vendidos: " + valor_cafes_vendidos);
        do {
            System.out.println("Pagamento total ou parcial da conta?: \n"
                    + "1 Parcial; \n"
                    + "2 Total; \n");
            opcao2 = sc.nextInt();
            if (opcao2 == 1) {
                System.out.println("Informe o valor do Pagamento Parcial");
                pagamento_parcial = sc.nextDouble();
                restante = valor_conta - pagamento_parcial;
                System.out.println("Valor em aberto da conta: " + restante);
                valor_conta = restante;
            } else if (opcao2 == 2) {
                System.out.println("Informe o valor pago: ");
                pagamento_total = sc.nextDouble();
                if (pagamento_total <= valor_conta) {
                    System.out.println("Valores em aberto: ");
                    restante = pagamento_total - valor_conta;
                    System.out.println("Quite os debitos para fechar a conta");
                } else if (pagamento_total == valor_conta){
                    System.out.println("Valores quitados,Conta encerrada");
                }
            }
        } while (restante != 0 );
        System.out.println("Valores quitados,Conta encerrada");
    }
}