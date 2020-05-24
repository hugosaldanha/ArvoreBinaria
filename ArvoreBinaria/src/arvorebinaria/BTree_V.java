package arvorebinaria;

/*
 *	ALGESD - ï¿½rvore Binï¿½ria - Classe Visï¿½o
 *	Aplicaï¿½ï¿½o Exemplo - Por RC
 *
 */
import javax.swing.*;

public class BTree_V {
	private String[] sSN = { "Sim", "Não" };
	private String sIO = "Selecione a opção desejada:";
	private String sExit = "Deseja sair?";

	// Mostra mensagem na Janela
	public void mostra(String sT, String sI) {
		JOptionPane.showMessageDialog(null, sI, sT, JOptionPane.PLAIN_MESSAGE);
	}

	// Apresenta texto no Console
	public void console(String sT) {
		System.out.println(sT);
	}

	// Recebe valor
	public String recebe(String sT, String sI) {
		return JOptionPane.showInputDialog(null, sI, sT, JOptionPane.QUESTION_MESSAGE);
	}

	// Apresenta Menu Principal
	public int menu(String sT, String[] sOpc) {
		int iOpcao, iSN;
		do {
			iOpcao = JOptionPane.showOptionDialog(null, sIO, sT, 1, JOptionPane.QUESTION_MESSAGE, null, sOpc, null);
			if (iOpcao == sOpc.length - 1) {
				iSN = JOptionPane.showOptionDialog(null, sExit, sT, 1, JOptionPane.QUESTION_MESSAGE, null, sSN, null);
				if (iSN == 1)
					iOpcao = -1;
			}
		} while (iOpcao < 0 || iOpcao > sOpc.length - 1);
		return iOpcao;
	}
}
