package ipvc.estg;

public class UserMenu implements Menu{
    @Override
    public void show(){
        System.out.println("Menu");
        System.out.println(" 1  - Editar dados");
        System.out.println(" 2  - Criar projeto");
        System.out.println(" 3  - Alterar projeto");
        System.out.println(" 4  - Criar tarefa");
        System.out.println(" 5  - Alterar tarefa");
        System.out.println(" 6  - Remover tarefas");
        System.out.println(" 7  - Listar tarefas por intervalo");
        System.out.println(" 8  - Convidar utilizador");
        System.out.println(" 9  - Alterar convidados");
        System.out.println(" 10 - Imprimir relatorio pessoal do mês");
        System.out.println(" 11 - Imprimir relatorio mensal");
        System.out.println(" 12 - LOGOUT");
    }
}

