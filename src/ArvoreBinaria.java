public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if(this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            boolean esquerda = false;
            while(atual != null) {
                if(novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                    esquerda = true;
                } else {
                    pai = atual;
                    atual = atual.getDir();
                    esquerda = false;
                }
            }
            if(esquerda) {
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
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor < atual.getValor()) {
            atual.setEsq(removerRecursivo(atual.getEsq(), valor));
        } else if (valor > atual.getValor()) {
            atual.setDir(removerRecursivo(atual.getDir(), valor));
        } else {
            // Nó encontrado - precisamos removê-lo

            // Caso 1: Nó folha
            if (atual.getEsq() == null && atual.getDir() == null) {
                return null;
            }

            // Caso 2: Nó com apenas um filho
            if (atual.getEsq() == null) {
                return atual.getDir();
            }
            if (atual.getDir() == null) {
                return atual.getEsq();
            }

            // Caso 3: Nó com dois filhos
            // Encontrar o sucessor (menor valor na subárvore direita)
            No menorValorNo = encontrarMenorValor(atual.getDir());
            atual.setValor(menorValorNo.getValor());
            atual.setDir(removerRecursivo(atual.getDir(), menorValorNo.getValor()));
        }

        return atual;
    }

    private No encontrarMenorValor(No no) {
        return no.getEsq() == null ? no : encontrarMenorValor(no.getEsq());
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }
}
