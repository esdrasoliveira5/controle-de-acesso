package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Controle de Acesso.
 */

public class Principal {
  /**
   * Método principal.
   */
  public static void main(String[] args) {
    ArrayList<Short> pessoas = new ArrayList<Short>();
    Scanner scanner = new Scanner(System.in);

    short log;
    short idade;
    do {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Acessar o estabelecimento\n" + "2 - Finalizar sistema e mostrar relatório: ");
      log = scanner.nextShort();
      if (log == 1) {
        System.out.println("Entre com a sua idade:");
        idade = scanner.nextShort();
        imprimeIdade(idade);
        pessoas.add(idade);
        System.out.println("Entre com o número correspondente à opção desejada:\n"
            + "1 - Acessar o estabelecimento\n" + "2 - Finalizar sistema e mostrar relatório");
        log = scanner.nextShort();
      }

    } while (log == 1);
    imprime("RELATORIO");
    scanner.close();
  }

  static void imprimeIdade(int idade) {
    if (idade < 18) {
      imprime("Pessoa cliente menor de idade, catraca liberada!");
    } else if (idade >= 18 && idade <= 49) {
      imprime("Pessoa adulta, catraca liberada!");
    } else {
      imprime("Pessoa adulta a partir de 50, catraca liberada!");
    }
  }

  static void imprime(String mensagem) {
    System.out.println(mensagem);
  }
}
