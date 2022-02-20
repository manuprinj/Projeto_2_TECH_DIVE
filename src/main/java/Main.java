import static utils.InputUtils.getCNPJ;
import static utils.InputUtils.getCPF;
import static utils.InputUtils.getData;
import static utils.InputUtils.getEmail;
import static utils.InputUtils.getInt;
import static utils.InputUtils.getSenha;
import static utils.InputUtils.getString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import types.Estados;
import types.PerfilAcesso;
import types.RegionaisSENAI;
import types.Segmentos;
import types.Status;
import types.TipoEmpresa;


public class Main {

    public static int opcaoTipoEmpresa;
    public static int numeroSequencial = 1;
    public static List<Empresa> empresas = new ArrayList<>();
    public static List<Trilha> trilhas = new ArrayList<>();
    public static List<Modulos> modulos = new ArrayList<>();
    public static List<Trabalhador> trabalhadores = new ArrayList<>();
    public static List<Usuario> usuarios = new ArrayList<>();

    public static void menuAdministrativo() {
        while (true) {
            System.out.println("Seja bem-vindo ao Habilit Pro");
            System.out.println("1 - Cadastrar Empresa");
            System.out.println("2 - Cadastrar Trilha");
            System.out.println("3 - Cadastrar Módulo");
            System.out.println("4 - Cadastrar Trabalhador");
            System.out.println("5 - Cadastrar Usuários");
            System.out.println("6 - Relatórios");
            System.out.println("7 - Sair");
            int tipoOperacao = getInt();

            if (tipoOperacao == 1) cadastrarEmpresa();
            else if (tipoOperacao == 2) cadastrarTrilha();
            else if (tipoOperacao == 3) cadastrarModulo();
            else if (tipoOperacao == 4) cadastrarTrabalhador();
            else if (tipoOperacao == 5) cadastrarUsuario();
            else if (tipoOperacao == 6) ;
            else if (tipoOperacao == 7) return;
            else System.out.println("Digite uma opção válida!!");

        }
    }

    public static void cadastrarEmpresa() {
        System.out.println("CADASTRO DE EMPRESAS");
        String nome = getString("Digite o nome:");
        String cnpj = getCNPJ("Digite o CNPJ:");
        for (Empresa empresa : empresas) {
            if (empresa.getCnpj().equals(cnpj)) {
                System.out.println("Este CNPJ já está vinculado à uma empresa cadastrada!");
                return;
            }
        }
        TipoEmpresa tipoEmpresa = getTipoEmpresa();
        Segmentos segmento = getSegmento();
        String cidade = getString("Digite a cidade:");
        Estados estado = getEstado();
        RegionaisSENAI regionalSenai = getRegional();

        if (opcaoTipoEmpresa == TipoEmpresa.FILIAL.ordinal()) {
            String nomeFilial = getString("Digite o nome da Filial:");
            Empresa empresa = new Empresa(nome, cnpj, tipoEmpresa, nomeFilial, segmento, cidade, estado, regionalSenai);
            empresas.add(empresa);
            System.out.println(empresa);
        } else {
            Empresa empresa = new Empresa(nome, cnpj, tipoEmpresa, segmento, cidade, estado, regionalSenai);
            empresas.add(empresa);
            System.out.println(empresa);
        }

    }

    public static void cadastrarTrilha() {
        System.out.println("CADASTRO DE TRILHAS");
        String nomeEmpresa = validacaoEmpresa().getNomeEmpresa();
        String ocupacao = getString("Digite a ocupação da trilha:");
        int anoAtual = LocalDate.now().getYear();
        String nomeTrilha = (ocupacao + " | " + nomeEmpresa.toString() + " | " + numeroSequencial + " | " + anoAtual);
        String apelidoTrilha = (ocupacao + " | " + numeroSequencial);
        // Módulos
        // String anotacoes = getString("Digite as anotações da trilha:");

        Trilha trilha = new Trilha(nomeEmpresa, ocupacao, numeroSequencial, nomeTrilha, apelidoTrilha);
        trilhas.add(trilha);
        numeroSequencial++;

        System.out.println(trilha);
    }

    public static void cadastrarModulo() {
        System.out.println("CADASTRO DE MÓDULOS");
        String nomeTrilha = validacaoTrilha().getNomeTrilha();
        String nomeModulo = getString("Digite o nome do módulo:");

        System.out.println("Digite as habilidades:");
        //pegar as habilidades

        String tarefaAvaliacao = getString("Digite as tarefas de validação do módulo:");
        LocalDate prazoLimite = getData("Digite o prazo limite para avaliação (dd/MM/yyyy): ");
        Status status = getStatus();

        Modulos modulo = new Modulos(nomeTrilha, nomeModulo, null, tarefaAvaliacao, prazoLimite, status);
        modulos.add(modulo);
    }

    public static void cadastrarTrabalhador() {
        System.out.println("CADASTRO DE TRABALHOR");
        String nomeTrabalhador = getString("Digite o nome do trabalhador:");
        String cpf = getCPF("Digite o CPF do trabalhador:");
        String nomeEmpresa = validacaoEmpresa().getNomeEmpresa();
        String setorArea = getString("Digite o setor/área do trabalhador:");
        String funcao = getString("Digite a função do trabalhador:");
        //        Data Modificação
        //        String nomeTrilha = validacaoTrilha().getNomeTrilha();
        //        String nomeModulo = getString("Digite o nome do módulo:");
        //        Avaliacao;
        //        Anotacoes;

        Trabalhador trabalhador =
                new Trabalhador(nomeTrabalhador, cpf, nomeEmpresa, setorArea, funcao, null, null, null, null);
        trabalhadores.add(trabalhador);
    }

    public static void cadastrarUsuario() {
        System.out.println("CADASTRO DE USUÁRIO");
        String nomeTrabalhador = getString("Digite o nome do usuário:");
        String cpf = getCPF("Digite o CPF do usuário:");
        String email = getEmail("Digite o e-mail do usuário:");
        String senha = getSenha("Digite a senha do usuário:");
        PerfilAcesso perfilAcesso = getPerfilAcesso();

        Usuario usuario = new Usuario(nomeTrabalhador, cpf, email, senha, perfilAcesso);
        usuarios.add(usuario);

    }

    private static TipoEmpresa getTipoEmpresa() {
        System.out.println("Selecione o tipo da empresa:");
        for (TipoEmpresa value : TipoEmpresa.values()) {
            System.out.println(value.ordinal() + 1 + " - " + value.getNome());
        }
        opcaoTipoEmpresa = getInt() - 1;
        return TipoEmpresa.values()[opcaoTipoEmpresa];
    }

    private static Segmentos getSegmento() {
        System.out.println("Selecione o segmento que a empresa atua:");
        for (Segmentos value : Segmentos.values()) {
            System.out.println(value.ordinal() + 1 + " - " + value.getNome());
        }
        int opcaoSegmento = getInt() - 1;
        return Segmentos.values()[opcaoSegmento];
    }

    private static Estados getEstado() {
        System.out.println("Selecione o estado:");
        for (Estados value : Estados.values()) {
            System.out.println(value.ordinal() + 1 + " - " + value.getNome());
        }
        int opcaoEstado = getInt() - 1;
        return Estados.values()[opcaoEstado];
    }

    private static RegionaisSENAI getRegional() {
        System.out.println("Selecione a regional que a empresa estará vinculada:");
        for (RegionaisSENAI value : RegionaisSENAI.values()) {
            System.out.println(value.ordinal() + 1 + " - " + value.getNome());
        }
        int opcaoRegional = getInt() - 1;
        return RegionaisSENAI.values()[opcaoRegional];
    }

    private static Status getStatus() {
        System.out.println("Selecione o status:");
        for (Status value : Status.values()) {
            System.out.println(value.ordinal() + 1 + " - " + value.getNome());
        }
        int opcaoStatus = getInt() - 1;
        return Status.values()[opcaoStatus];
    }

    private static PerfilAcesso getPerfilAcesso() {
        System.out.println("Selecione o perfil de acesso do usuário:");
        for (PerfilAcesso value : PerfilAcesso.values()) {
            System.out.println(value.ordinal() + 1 + " - " + value.getNome());
        }
        int opcaoPerfilAcesso = getInt() - 1;
        return PerfilAcesso.values()[opcaoPerfilAcesso];
    }

    public static Empresa validacaoEmpresa() {
        while (true) {
            String cnpj = getCNPJ("Digite o CNPJ da empresa:");

            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpj)) return empresa;
            }

            System.out.println("Empresa não encontrada!");
        }
    }

    public static Trilha validacaoTrilha() {
        while (true) {
            Empresa empresa = validacaoEmpresa();
            System.out.println("Selecione uma das trlhas disponiveis:");
            for (int i = 0; i < empresa.getTrilhas().size(); i++) {
                System.out.println((i + 1) + " - " + empresa.getTrilhas().get(i).getNomeTrilha());
            }
            int opcaoTrilha = getInt() - 1;
            if (opcaoTrilha < empresa.getTrilhas().size()) {
                return empresa.getTrilhas().get(opcaoTrilha);
            }
            System.out.println("Trilha não encontrada!");
        }
    }

    public static void main(String[] args) {
        menuAdministrativo();
    }
}
