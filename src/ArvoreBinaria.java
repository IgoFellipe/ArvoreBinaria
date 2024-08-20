import java.util.Stack;

class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            while (atual != null) {
                pai = atual;
                if (novoNo.getValor() < atual.getValor()) {
                    atual = atual.getEsq();
                } else {
                    atual = atual.getDir();
                }
            }
            if (novoNo.getValor() < pai.getValor()) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void remover(int valor) {
        // 1. Encontra o nó que vai ser removido e seu pai
        No atual = this.raiz;
        No pai = null;
        boolean isEsqFilho = true;

        while (atual != null && atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                isEsqFilho = true;
                atual = atual.getEsq();
            } else {
                isEsqFilho = false;
                atual = atual.getDir();
            }
        }

        // Nó não encontrado
        if (atual == null) {
            return;
        }

        // Verifica se o nó não tem filhos
        if (atual.getEsq() == null && atual.getDir() == null) {
            if (atual == raiz) {
                raiz = null;
            } else if (isEsqFilho) {
                pai.setEsq(null);
            } else {
                pai.setDir(null);
            }
        }

        // Verifica se o nó tem só um filho
        else if (atual.getEsq() == null) {
            if (atual == raiz) {
                raiz = atual.getDir();
            } else if (isEsqFilho) {
                pai.setEsq(atual.getDir());
            } else {
                pai.setDir(atual.getDir());
            }
        } else if (atual.getDir() == null) {
            if (atual == raiz) {
                raiz = atual.getEsq();
            } else if (isEsqFilho) {
                pai.setEsq(atual.getEsq());
            } else {
                pai.setDir(atual.getEsq());
            }
        }

        // Verifica se o nó tem dois filhos
        else {
            No sucessor = getSucessor(atual);
            if (atual == raiz) {
                raiz = sucessor;
            } else if (isEsqFilho) {
                pai.setEsq(sucessor);
            } else {
                pai.setDir(sucessor);
            }
            sucessor.setEsq(atual.getEsq());
        }
    }

    private No getSucessor(No no) {
        // Verifica o menor nó a direita
        No sucessorPai = no;
        No sucessor = no;
        No atual = no.getDir();

        while (atual != null) {
            sucessorPai = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }

        // Ajustar o pai
        if (sucessor != no.getDir()) {
            sucessorPai.setEsq(sucessor.getDir());
            sucessor.setDir(no.getDir());
        }

        return sucessor;
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        Stack<No> pilha = new Stack<>();
        pilha.push(no);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.println(atual.getValor());

            if (atual.getDir() != null) {
                pilha.push(atual.getDir());
            }
            if (atual.getEsq() != null) {
                pilha.push(atual.getEsq());
            }
        }
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        Stack<No> pilha = new Stack<>();
        No atual = no;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.getEsq();
            }

            atual = pilha.pop();
            System.out.println(atual.getValor());
            atual = atual.getDir();
        }
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();
        pilha1.push(no);

        while (!pilha1.isEmpty()) {
            No atual = pilha1.pop();
            pilha2.push(atual);

            if (atual.getEsq() != null) {
                pilha1.push(atual.getEsq());
            }
            if (atual.getDir() != null) {
                pilha1.push(atual.getDir());
            }
        }

        while (!pilha2.isEmpty()) {
            System.out.println(pilha2.pop().getValor());
        }
    }
}