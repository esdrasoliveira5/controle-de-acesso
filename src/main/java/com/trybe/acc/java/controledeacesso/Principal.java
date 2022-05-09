package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
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
      imprime("Entre com o número correspondente à opção desejada:");
      imprime("1 - Acessar o estabelecimento");
      imprime("2 - Finalizar sistema e mostrar relatório");

      log = scanner.nextShort();
      if (log == 1) {
        System.out.println("Entre com a sua idade:");
        idade = scanner.nextShort();
        imprimeIdade(idade);
        pessoas.add(idade);
      } else if (log != 1 && log != 2) {
        imprime("Entre com uma opção válida!");
      }

    } while (log != 2);
    gerarRelatorio(pessoas);
    scanner.close();
  }

  static void gerarRelatorio(ArrayList<Short> pessoas) {
    int totalPessoas = pessoas.size();
    int menores = 0;
    int adultos = 0;
    int velhos = 0;

    for (int i = 0; i < totalPessoas; i += 1) {
      if (pessoas.get(i) < 18) {
        menores += 1;
      } else if (pessoas.get(i) >= 18 && pessoas.get(i) <= 49) {
        adultos += 1;
      } else {
        velhos += 1;
      }
    }

    imprime("----- Quantidade -----");
    imprime("menores: " + menores);
    imprime("adultas: " + adultos);
    imprime("a partir de 50: " + velhos);
    imprime("");
    imprime("----- Percentual -----");
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    String menorPorcentagem = decimalFormat.format(menores * 100f / totalPessoas);
    imprime("menores: " + menorPorcentagem + "%");

    String adultoPorcentagem = decimalFormat.format(adultos * 100f / totalPessoas);
    imprime("adultas: " + adultoPorcentagem + "%");

    String velhoPorcentagem = decimalFormat.format(velhos * 100f / totalPessoas);
    imprime("a partir de 50: " + velhoPorcentagem + "%");
    imprime("");
    imprime("TOTAL: " + (totalPessoas));
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
