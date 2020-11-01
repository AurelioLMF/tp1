import java.util.Arrays;
import java.util.Scanner;

public class Aurelio {
	
	static int QTDE = 100;
	static int REPROVADO = 4;
	static int APROVADO = 7;
	static float media;
	static String obterSituacao;
	
	static String[] nomes = new String[QTDE];
	static float[] notasAV1 = new float[QTDE];
	static float[] notasAV2 = new float[QTDE];
	static float[] medias = new float[QTDE];
	static String[] situacao = new String[QTDE];
	
	private static void calcularMedia(float nota1, float nota2) {
		media = (nota1 + nota2)/2;
		System.out.printf("Média Final: %.1f\n", media);
	}
	
	private static void obterSituacao() {		
		if(media < REPROVADO) {
    		obterSituacao = "Reprovado";
    	}else if (media >= APROVADO ) {
    		obterSituacao = "Aprovado";
    	}else {
    		obterSituacao = "Prova Final";
    	}
		System.out.printf("Situação Final: %s\n", obterSituacao);
		System.out.println("");
	}
	
	private static void imprimir(String nomes, float nota1, float nota2, float media, String situacao){
		System.out.printf("Nome: %s\n", nomes);
		System.out.printf("Nota AV1: %.1f\n", nota1);
		System.out.printf("Nota AV2: %.1f\n", nota2);

		calcularMedia(nota1, nota2);
		obterSituacao();
	}
	
	private static void menu() {
		System.out.println("\n -------- Cadastro de alunos ------- ");
		System.out.println("[1] Registrar as notas de um novo aluno");
		System.out.println("[2] Consultar boletim de um aluno");
		System.out.println("[3] Consultar notas da turma");
		System.out.println("[4] Sair");
		System.out.print("Escolha sua opcao: ");
	}
		
	public static void main(String[] args) {
				
		Scanner in = new Scanner (System.in);
		
		Integer[] opcoes = {1,2,3,4};
		int optMenu;
		int i = 0;
		
        do {
	        menu();
			optMenu = in.nextInt();
			
	        if (Arrays.asList(opcoes).contains(optMenu)) {		
		        switch (optMenu){
		        case 1:
		        	if (i < QTDE) {
						System.out.print("\nInforme o nome do aluno: ");
			        	nomes[i] = in.next();
			        	
			        	System.out.print("Nota de AV1: ");
			        	notasAV1[i] = in.nextFloat();
			        	
			        	System.out.print("Nota de AV2: ");
			        	notasAV2[i] = in.nextFloat();        	
			        	
			        	System.out.printf("\nAluno: %s registrado com o código: %d\n", nomes[i], i);
			        	
			        	i ++;
		        	}else if (i >= QTDE) {
		        		System.out.println("Número máximo de cadastros alcançado. Não é possível cadastrar mais alunos.\n");
		        	}//fim do else if	
		        break;
		        
		        case 2:
		        	System.out.print("\nInforme o código do aluno: ");
		        	int codigo = in.nextInt();
		        	
		        	imprimir(nomes[codigo], notasAV1[codigo], notasAV2[codigo], medias[codigo], situacao[codigo]);
		        break;
		        
		        case 3:
		        	System.out.println("");
		        	System.out.println("-------------------------");
		        	System.out.println("==== Notas da turma: ====");
		        	for (i = 0; i < nomes.length; i += 1) {
		        		if(nomes[i] != null) {
		        			imprimir(nomes[i], notasAV1[i], notasAV2[i], medias[i], situacao[i]);
		        		}//fim do if
		        	}//fim do for
		        }//fim do switch
	        }else {
	        System.out.println("Opção Inválida. Tente novamente");
	        }
	        
        }while(optMenu != 4);//fim do "do"
        in.close();
        System.out.println("Finalizando o programa...");
        System.out.println("Programa finalizado com sucesso!");
	}
}