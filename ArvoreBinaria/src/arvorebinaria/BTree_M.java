package arvorebinaria;

public class BTree_M {
	/*
	 * ALGESD - Nó em árvore Binária - Classe NodoAB Aplicação Exemplo - Por RC
	 * 
	 */
	private class NodoAB {
		private int iElement;
		private NodoAB ndLeft;
		private NodoAB ndRight;

		public NodoAB(int iE, NodoAB ndL, NodoAB ndR) {
			iElement = iE;
			ndLeft = ndL;
			ndRight = ndR;
		}

		public void setLeft(NodoAB ndL) {
			ndLeft = ndL;
		}

		public void setRight(NodoAB ndR) {
			ndRight = ndR;
		}

		public int getElement() {
			return iElement;
		}

		public NodoAB getLeft() {
			return ndLeft;
		}

		public NodoAB getRight() {
			return ndRight;
		}
	}

	private NodoAB ndRaiz;
	private int iTamanho;

	public BTree_M() {
		ndRaiz = null;
		iTamanho = 0;
	}

	public void putNode(int iE) {
		NodoAB ndNovo = new NodoAB(iE, null, null);
		if (isEmpty())
			ndRaiz = ndNovo;
		else
			insertLeaf(ndRaiz, ndNovo);
		iTamanho++;
	}

	public void insertLeaf(NodoAB ndNoPai, NodoAB ndNoFilho) {
		NodoAB ndAux;
		if (ndNoFilho.getElement() < ndNoPai.getElement()) {
			ndAux = ndNoPai.getLeft();
			if (ndAux != null)
				insertLeaf(ndAux, ndNoFilho);
			else
				ndNoPai.setLeft(ndNoFilho);
		} else {
			ndAux = ndNoPai.getRight();
			if (ndAux != null)
				insertLeaf(ndAux, ndNoFilho);
			else
				ndNoPai.setRight(ndNoFilho);
		}
	}

	public void preOrder() {
		System.out.print("Pre Ordem: ");
		preOrder(ndRaiz);
		System.out.println();
	}

	public void preOrder(NodoAB ndNoPai) {
		if (ndNoPai != null) {
			System.out.print(ndNoPai.iElement + " ");
			preOrder(ndNoPai.ndLeft);
			preOrder(ndNoPai.ndRight);
		}
	}

	public void iOrder() {
		System.out.print("Ordem: ");
		Order(ndRaiz);
		System.out.println();
	}

	public void Order(NodoAB ndNoPai) {
		if (ndNoPai != null) {
			Order(ndNoPai.ndLeft);
			System.out.print(ndNoPai.iElement + " ");
			Order(ndNoPai.ndRight);
		}
	}

	public void posOrder() {
		System.out.print("P�s Ordem: ");
		posOrder(ndRaiz);
		System.out.println();
	}

	public void posOrder(NodoAB ndNoPai) {
		if (ndNoPai != null) {
			posOrder(ndNoPai.ndLeft);
			posOrder(ndNoPai.ndRight);
			System.out.print(ndNoPai.iElement + " ");
		}
	}

	public boolean takeNode(int iE) {
		boolean bResp = false;
		if (isInTree(iE, ndRaiz)) {
			ndRaiz = deleteNode(iE, ndRaiz);
			bResp = true;
			iTamanho--;
		}
		return bResp;
	}

	public NodoAB deleteNode(int iE, NodoAB ndNo) {
		NodoAB ndAux, ndRet = null;

		if (ndNo != null) {
			if (ndNo.getElement() == iE) {
				if (ndNo.getLeft() == ndNo.getRight())
					ndRet = null;
				else {
					if (ndNo.getLeft() == null)
						ndRet = ndNo.getRight();
					else {
						if (ndNo.getRight() == null)
							ndRet = ndNo.getLeft();
						else {
							ndAux = ndNo.getRight();
							while (ndAux.getLeft() != null)
								ndAux = ndAux.getLeft();
							ndAux.setLeft(ndNo.getLeft());
							ndRet = ndNo.getRight();
						}
					}
				}
			} else {
				if (ndNo.getElement() < iE)
					ndNo.setRight(deleteNode(iE, ndNo.getRight()));
				else
					ndNo.setLeft(deleteNode(iE, ndNo.getLeft()));
				ndRet = ndNo;
			}
		}
		return ndRet;
	}

	public boolean viewNode(int iE) {
		return isInTree(iE, ndRaiz);
	}

	public boolean isInTree(int iE, NodoAB ndNo) {
		boolean bResp = false;
		if (ndNo != null) {
			if (iE == ndNo.getElement())
				bResp = true;
			else {
				if (iE < ndNo.getElement()) {
					if (isInTree(iE, ndNo.getLeft()))
						bResp = true;
				} else {
					if (isInTree(iE, ndNo.getRight()))
						bResp = true;
				}
			}
		}
		return bResp;
	}

	public String getTree() {
		return getLevel(0, ndRaiz);
	}

	public String getLevel(int iLevel, NodoAB ndNo) {
		String sOut = "";
		if (ndNo != null) {
			sOut += getLevel(iLevel + 1, ndNo.getLeft());
			for (int iI = 0; iI < iLevel; iI++)
				sOut += "          "; // 10 espa�os
			sOut += ndNo.getElement() + "\n";
			sOut += getLevel(iLevel + 1, ndNo.getRight());
		}
		return sOut;
	}

	public int size() {
		return iTamanho;
	}

	public boolean isEmpty() {
		boolean bR = false;
		if (size() == 0)
			bR = true;
		return bR;
	}

}
