import static utils.InputUtils.getInt;

import java.util.ArrayList;

import types.PerfilAcesso;


public class Relatorios {

    public static void menuRelatorio() {
        while (true) {
            System.out.println("Seja bem-vindo ao Habilit Pro");
            System.out.println("1 - Relatórios de Empresas");
            System.out.println("2 - Relatórios de Trilhas");
            System.out.println("3 - Relatórios de Módulos");
            System.out.println("4 - Relatórios de Trabalhadores");
            System.out.println("5 - Voltar");
            int tipoOperacao = getInt();

            if (tipoOperacao == 1) ;
            else if (tipoOperacao == 2) ;
            else if (tipoOperacao == 3) ;
            else if (tipoOperacao == 4) ;
            else if (tipoOperacao == 5) return;
            else System.out.println("Digite uma opção válida!!");
        }
    }
}
