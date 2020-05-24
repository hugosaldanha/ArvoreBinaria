package arvorebinaria;

/*
 *	ALGESD - ï¿½rvore Binï¿½ria - Classe Controle
 *	Aplicaï¿½ï¿½o Exemplo - Por RC
 *
 */
public class BTree_C {
	private static BTree_M arvore;
	private static BTree_V dspMs;

	private static String sC1 = "ALGESD-2o.Semestre";
	private static String sC2 = "Árvore Binária (int)";
	private static String sM0 = "Até logo!";
	private static String sM1 = "Árvore Binária";
	private static String sM2 = "Árvore vazia!";
	private static String sM3 = "Digite o elemento:";
	private static String sM4 = "Número inserido com sucesso!";
	private static String sM5 = "Número removido: ";
	private static String sM6 = "Número consultado: ";
	private static String sM7 = "Não se encontra na Árvore!";
	private static String sM8 = "Tamanho da Árvore: ";
	private static String sM9 = "Árvore Pré-Ordenada: ";
	private static String sM10 = "Árvore Ordenada: ";
	private static String sM11 = "Árvore Pós-Ordenada: ";
	private static String sM12 = "Árvore a -90 graus: ";
	private static String[] sDspMn = { "Inserir", "Remover", "Consultar", "Tamanho", "Pré-Ordem", "Ordem", "Pós-Ordem",
			"Sair" };

	public static void main(String Args[]) {
		/*
		 * Instï¿½ncia da Arvore
		 * ----------------------------------------------------------
		 */
		arvore = new BTree_M();

		/*
		 * Lï¿½gica de Negï¿½cio
		 * ------------------------------------------------------------
		 */

		// Introduï¿½ï¿½o
		dspMs = new BTree_V();
		dspMs.mostra(sC1, sM1);

		// Menu Principal
		int iOpcao;
		do {
			iOpcao = dspMs.menu(sC2, sDspMn);
			switch (iOpcao) {
			case 0:
				inserirNo();
				break;
			case 1:
				removerNo();
				break;
			case 2:
				consultarNo();
				break;
			case 3:
				tamanho();
				break;
			case 4:
				preOrdem();
				break;
			case 5:
				Ordem();
				break;
			case 6:
				PosOrdem();
				break;
			default:
				break;
			}
		} while (iOpcao != sDspMn.length - 1);

		/*
		 * Despedida e Final da execuï¿½ï¿½o
		 * ------------------------------------------------
		 */
		dspMs.mostra(sC2, sM0);
		System.exit(0);
	}

	private static void PosOrdem() {
		// TODO Auto-generated method stub
		arvore.posOrder();
	}

	private static void Ordem() {
		// TODO Auto-generated method stub
		arvore.iOrder();
	}

	private static void preOrdem() {
		// TODO Auto-generated method stub
		arvore.preOrder();
	}

	public static void inserirNo() {
		// Recebe o elemento do nï¿½ e o insere na ï¿½rvore
		arvore.putNode(Integer.parseInt(dspMs.recebe(sC2, sM3)));
		dspMs.mostra(sC2, sM4); // Sucesso na inserï¿½ï¿½o
		verArvore90(); // Apresenta a ï¿½rvore no console
	}

	public static void removerNo() {
		// Remove o elemento da ï¿½rvore
		if (arvore.isEmpty())
			dspMs.mostra(sC2, sM2); // ï¿½rvore vazia
		else {
			int iNum = Integer.parseInt(dspMs.recebe(sC2, sM3));
			if (arvore.takeNode(iNum))
				dspMs.mostra(sC2, sM5 + iNum);
			else
				dspMs.mostra(sC2, sM7);
		}
		verArvore90(); // Apresenta a ï¿½rvore no console
	}

	public static void consultarNo() {
		// Consulta o elemento na ï¿½rvore
		if (arvore.isEmpty())
			dspMs.mostra(sC2, sM2); // ï¿½rvore vazia
		else {
			int iNum = Integer.parseInt(dspMs.recebe(sC2, sM3));
			if (arvore.viewNode(iNum))
				dspMs.mostra(sC2, sM6 + iNum);
			else
				dspMs.mostra(sC2, sM7);
		}
	}

	public static void verArvore90() {
		// Apresenta a ï¿½rvore graficamente a -90 graus
		dspMs.console(sM12);
		if (arvore.isEmpty())
			dspMs.console(sM2); // ï¿½rvore vazia
		else
			dspMs.console(arvore.getTree());
	}

	public static void tamanho() {
		// Consulta o tamanho da ï¿½rvore
		if (arvore.isEmpty())
			dspMs.mostra(sC2, sM2); // ï¿½rvore vazia
		else
			dspMs.mostra(sC2, sM8 + arvore.size());
	}

}
