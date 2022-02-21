import static utils.InputUtils.getCNPJ;
import static utils.InputUtils.getCPF;
import static utils.InputUtils.getData;
import static utils.InputUtils.getEmail;
import static utils.InputUtils.getInt;
import static utils.InputUtils.getSenha;
import static utils.InputUtils.getString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import types.Estados;
import types.PerfilAcesso;
import types.RegionaisSENAI;
import types.Segmentos;
import types.StatusModulo;
import types.TipoEmpresa;
import utils.DateUtils;


public class Main {

    public static List<Empresa> empresas = new ArrayList<>();
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
            System.out.println("7 - Alterar Status do Módulo");
            System.out.println("8 - Alterar Funçao do Trabalhador");
            System.out.println("9 - Alterar Setor/Area do Trabalhador");
            System.out.println("10 - Alterar Empresa do Trabalhador");
            System.out.println("11 - Voltar");
            int tipoOperacao = getInt(1, 11);

            if (tipoOperacao == 1) cadastrarEmpresa();
            else if (tipoOperacao == 2) cadastrarTrilha();
            else if (tipoOperacao == 3) cadastrarModulo();
            else if (tipoOperacao == 4) cadastrarTrabalhador();
            else if (tipoOperacao == 5) cadastrarUsuario();
            else if (tipoOperacao == 6) menuRelatorio();
            else if (tipoOperacao == 7) alterarStatusModulo();
            else if (tipoOperacao == 8) alterarFuncao();
            else if (tipoOperacao == 9) alterarSetorArea();
            else if (tipoOperacao == 10) alterarEmpresaTrabalhador();
            else if (tipoOperacao == 11) return;
        }
    }

    private static void menuOperacional() {
        while (true) {
            System.out.println("1 - Realizar Processo de Avaliação");
            System.out.println("2 - Relatórios");
            System.out.println("3 - Voltar");
            int tipoOperacao = getInt(1, 3);

            if (tipoOperacao == 1) realizarProcessoAvaliacao();
            else if (tipoOperacao == 2) menuRelatorio();
            else if (tipoOperacao == 3) return;
        }
    }

    private static void menuRh() {
        while (true) {
            System.out.println("1 - Acompanhar Processo de Avaliação");
            System.out.println("2 - Relatórios");
            System.out.println("3 - Voltar");
            int tipoOperacao = getInt(1, 3);

            if (tipoOperacao == 1) acompanharProcessoAvaliacao();
            else if (tipoOperacao == 2) menuRelatorio();
            else if (tipoOperacao == 3) return;
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

        Empresa empresa;
        if (tipoEmpresa == TipoEmpresa.FILIAL) {
            String nomeFilial = getString("Digite o nome da Filial:");
            empresa = new Empresa(nome, cnpj, tipoEmpresa, nomeFilial, segmento, cidade, estado, regionalSenai);
        } else {
            empresa = new Empresa(nome, cnpj, tipoEmpresa, segmento, cidade, estado, regionalSenai);
        }
        empresas.add(empresa);

        while (true) {
            String isContinuar = getString("Você deseja cadastrar uma nova trilha para esta empresa? (S/N)");
            if (isContinuar.equals("S")) {
                cadastrarTrilha(empresa);
            } else {
                return;
            }
        }
    }

    public static void cadastrarTrilha() {
        Empresa empresa = validacaoEmpresa();
        cadastrarTrilha(empresa);
    }

    public static void cadastrarTrilha(Empresa empresa) {
        System.out.println("CADASTRO DE TRILHAS");
        String ocupacao = getString("Digite a ocupação da trilha:");
        int contagem =
                (int) empresa.getTrilhas().stream().filter(trilha -> trilha.getOcupacao().equals(ocupacao)).count() + 1;
        int anoAtual = LocalDate.now().getYear();
        String nomeTrilha = (ocupacao + " | " + empresa.getNomeEmpresa() + " | " + contagem + " | " + anoAtual);
        String apelidoTrilha = (ocupacao + " | " + contagem);

        Trilha trilha = new Trilha(empresa, ocupacao, contagem, nomeTrilha, apelidoTrilha);
        empresa.getTrilhas().add(trilha);

        String isContinuar;
        do {
            cadastrarModulo(trilha);
            isContinuar = getString("Você deseja cadastrar outro módulo para esta trilha? (S/N)");
        } while (isContinuar.equals("S"));
    }

    public static void cadastrarModulo() {
        Trilha trilha = validacaoTrilha();
        cadastrarModulo(trilha);
    }

    public static void cadastrarModulo(Trilha trilha) {
        System.out.println("CADASTRO DE MÓDULOS");
        String nomeModulo = getString("Digite o nome do módulo:");
        String habilidades = getString("Digite as habilidades:");
        String tarefaAvaliacao = getString("Digite as tarefas de validação do módulo:");
        LocalDate prazoLimite = DateUtils.addDiasUteis(LocalDate.now(), 10);
        StatusModulo statusModulo = getStatus();

        Modulo modulo = new Modulo(trilha, nomeModulo, habilidades, tarefaAvaliacao, prazoLimite, statusModulo);
        trilha.getModulos().add(modulo);
    }

    public static void alterarStatusModulo() {
        Modulo modulo = validacaoModulo();
        StatusModulo statusModulo = getStatus();
        modulo.setStatus(statusModulo);
    }

    public static void alterarFuncao() {
        Trabalhador trabalhador = validacaoTrabalhador();
        String funcao = getString("Digite a nova função do trabalhador:");
        trabalhador.setFuncao(funcao);
        trabalhador.setDataAlteracao(LocalDate.now());
    }

    public static void alterarSetorArea() {
        Trabalhador trabalhador = validacaoTrabalhador();
        String setorArea = getString("Digite o novo setor/área do trabalhador:");
        trabalhador.setAreaSetor(setorArea);
    }

    public static void alterarEmpresaTrabalhador() {
        Trabalhador trabalhador = validacaoTrabalhador();
        Empresa empresa = validacaoEmpresa();
        trabalhador.setEmpresa(empresa);
    }

    public static void cadastrarTrabalhador() {
        System.out.println("CADASTRO DE TRABALHOR");
        String nomeTrabalhador = getString("Digite o nome do trabalhador:");
        String cpf = getCPF("Digite o CPF do trabalhador:");
        Empresa empresa = validacaoEmpresa();
        String setorArea = getString("Digite o setor/área do trabalhador:");
        String funcao = getString("Digite a função do trabalhador:");
        LocalDate data = getData("Digite a data da última alteração de função (dd/MM/yyyy):");

        List<Trilha> trilhas = new ArrayList<>();
        List<Modulo> modulos = new ArrayList<>();

        String novaTrilha;
        do {
            Trilha trilha = validacaoTrilha(empresa);
            String novoModulo;
            do {
                Modulo modulo = validacaoModulo(trilha);
                modulos.add(modulo);
                novoModulo = getString("Você deseja selecionar outro módulo desta trilha? (S/N)");
            } while (novoModulo.equals("S"));
            trilhas.add(trilha);
            novaTrilha = getString("Você deseja selecionar outra trilha? (S/N)");
        } while (novaTrilha.equals("S"));


        //        Avaliacao;
        //        Anotacoes;

        Trabalhador trabalhador =
                new Trabalhador(nomeTrabalhador, cpf, empresa, setorArea, funcao, data, trilhas, modulos);
        trabalhadores.add(trabalhador);
    }

    public static void cadastrarUsuario() {
        System.out.println("CADASTRO DE USUÁRIO");
        String nomeTrabalhador = getString("Digite o nome do usuário:");
        String cpf = getCPF("Digite o CPF do usuário:");
        String email = getEmail("Digite o e-mail do usuário:");
        String senha = getSenha("Digite a senha do usuário:");
        List<PerfilAcesso> perfis = new ArrayList<>();
        String novoPerfilAcesso;
        do {
            perfis.add(getPerfilAcesso());
            novoPerfilAcesso = getString("Você deseja selecionar outro módulo desta trilha? (S/N)");
        } while (novoPerfilAcesso.equals("S"));

        Usuario usuario = new Usuario(nomeTrabalhador, cpf, email, senha, perfis);
        usuarios.add(usuario);
    }

    private static TipoEmpresa getTipoEmpresa() {
        System.out.println("Selecione o tipo da empresa:");
        for (TipoEmpresa value : TipoEmpresa.values()) {
            System.out.println(value.ordinal() + 1 + " - " + value.getNome());
        }
        int opcaoTipoEmpresa = getInt(1, TipoEmpresa.values().length) - 1;
        return TipoEmpresa.values()[opcaoTipoEmpresa];
    }

    private static Segmentos getSegmento() {
        System.out.println("Selecione o segmento que a empresa atua:");
        for (Segmentos value : Segmentos.values()) {
            System.out.println(value.ordinal() + 1 + " - " + value.getNome());
        }
        int opcaoSegmento = getInt(1, Segmentos.values().length) - 1;
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

    private static StatusModulo getStatus() {
        System.out.println("Selecione o status:");
        for (StatusModulo value : StatusModulo.values()) {
            System.out.println(value.ordinal() + 1 + " - " + value.getNome());
        }
        int opcaoStatus = getInt() - 1;
        return StatusModulo.values()[opcaoStatus];
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
        Empresa empresa = validacaoEmpresa();
        return validacaoTrilha(empresa);
    }

    public static Trilha validacaoTrilha(Empresa empresa) {
        while (true) {
            System.out.println("Selecione uma das trilhas:");
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

    public static Modulo validacaoModulo() {
        Trilha trilha = validacaoTrilha();
        return validacaoModulo(trilha);
    }

    public static Modulo validacaoModulo(Trilha trilha) {
        while (true) {
            System.out.println("Selecione um dos módulos:");
            for (int i = 0; i < trilha.getModulos().size(); i++) {
                System.out.println((i + 1) + " - " + trilha.getModulos().get(i).getNomeModulo());
            }
            int opcaoModulo = getInt() - 1;
            if (opcaoModulo < trilha.getModulos().size()) {
                return trilha.getModulos().get(opcaoModulo);
            }
            System.out.println("Modulo não encontrado!");
        }
    }

    public static Trabalhador validacaoTrabalhador() {
        while (true) {
            String cpf = getCPF("Digite o CPF do trabalhador:");

            for (Trabalhador trabalhador : trabalhadores) {
                if (trabalhador.getCpf().equals(cpf)) return trabalhador;
            }

            System.out.println("Trabalhador não encontrado!");
        }
    }

    public static void menuRelatorio() {
        while (true) {
            System.out.println("Seja bem-vindo ao Habilit Pro");
            System.out.println("1 - Relatórios de Empresas");
            System.out.println("2 - Relatórios de Trilhas");
            System.out.println("3 - Relatórios de Módulos");
            System.out.println("4 - Voltar");
            int tipoOperacao = getInt();

            if (tipoOperacao == 1) relatorioEmpresas();
            else if (tipoOperacao == 2) relatorioTrilhas();
            else if (tipoOperacao == 3) relatorioModulos();
            else if (tipoOperacao == 4) return;
            else System.out.println("Digite uma opção válida!!");
        }
    }

    private static void relatorioEmpresas() {
        System.out.println("Empresas:");
        for (Empresa empresa : empresas) {
            System.out.println(empresa);
        }
    }

    private static void relatorioTrilhas() {
        Empresa empresa = validacaoEmpresa();
        System.out.println("Trilhas:");
        for (Trilha trilha : empresa.getTrilhas()) {
            System.out.println(trilha);
        }
    }

    private static void relatorioModulos() {
        Trilha trilha = validacaoTrilha();
        System.out.println("Módulos:");
        for (Modulo modulo : trilha.getModulos()) {
            System.out.println(modulo);
        }
    }

    private static Usuario login() {
        while (true) {
            System.out.println("Login de Acesso:");
            String email = getString("Digite o seu e-mail:");
            String senha = getString("Digite a sua senha:");

            for (Usuario usuario : usuarios) {
                if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                    return usuario;
                }
            }
            System.out.println("E-mail ou Senha inválidos!");
        }
    }

    private static void cadastrarUsuarioInicial() {
        Usuario usuario = new Usuario("Administrador", "55347249005", "admin",
                "admin", List.of(PerfilAcesso.ADMINISTRATIVO, PerfilAcesso.OPERACIONAL, PerfilAcesso.RH));
        usuarios.add(usuario);
    }

    private static void realizarProcessoAvaliacao() {
        Trabalhador trabalhador = validacaoTrabalhador();

        List<Modulo> modulosEmAvaliacao = trabalhador.getModulos().stream()
                .filter(Modulo::isModuloEmAvaliacao).collect(Collectors.toList());

        if (modulosEmAvaliacao.isEmpty()) {
            System.out.println("Esse trabalhador não possui nenhum módulo em fase de avaliação!!");
            return;
        }

        System.out.println("Selecione o módulo para realizar a avaliação:");
        for (int i = 0; i < modulosEmAvaliacao.size(); i++) {
            Modulo modulo = modulosEmAvaliacao.get(i);
            System.out.println(i + 1 + " - " + modulo.getTrilha().getNomeTrilha() + " - " + modulo.getNomeModulo());
        }
        int tipoModulo = getInt(1, modulosEmAvaliacao.size()) - 1;
        Modulo modulo = modulosEmAvaliacao.get(tipoModulo);

        System.out.println("Digite a avaliação/score do módulo (1 a 5):");
        int score = getInt(1, 5);
        String anotacoes = getString("Digite as anotações para a avaliação do módulo:");

        Avaliacao avaliacao = new Avaliacao(trabalhador, modulo, score, anotacoes);
        modulo.getAvaliacoes().add(avaliacao);
    }

    private static void acompanharProcessoAvaliacao() {
        Modulo modulo = validacaoModulo();

        if (modulo.getAvaliacoes().isEmpty()) {
            System.out.println("Ainda não foram realizadas avaliações para o módulo");
        } else {
            System.out.println("Avaliações do módulo:");
            int soma = 0;
            for (Avaliacao avaliacao : modulo.getAvaliacoes()) {
                System.out.println(avaliacao);
                soma += avaliacao.getAvaliacao();
            }
            BigDecimal media = BigDecimal.valueOf(soma).divide(BigDecimal.valueOf(modulo.getAvaliacoes().size()), 2, RoundingMode.HALF_EVEN);
            System.out.println("Nível de satisfação (Geral): " + media.toString());
        }
    }

    public static void main(String[] args) {
        cadastrarUsuarioInicial();
        System.out.println("Seja bem-vindo ao Habilit Pro");
        Usuario usuario = login();
        while (true) {
            System.out.println("Selecione qual menu deseja visualizar:");
            for (int i = 0; i < usuario.getPerfis().size(); i++) {
                System.out.println(i + 1 + " - " + usuario.getPerfis().get(i).getNome());
            }
            System.out.println(usuario.getPerfis().size() + 1 + " - Sair");
            int tipoMenu = getInt(1, usuario.getPerfis().size() + 1) - 1;

            if (tipoMenu == usuario.getPerfis().size()) {
                login();
                continue;
            }

            PerfilAcesso perfilAcesso = usuario.getPerfis().get(tipoMenu);
            if (perfilAcesso == PerfilAcesso.ADMINISTRATIVO) menuAdministrativo();
            else if (perfilAcesso == PerfilAcesso.OPERACIONAL) menuOperacional();
            else if (perfilAcesso == PerfilAcesso.RH) menuRh();
        }
    }
}
