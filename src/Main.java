
public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(2);
        arvoreBinaria.inserir(18);

        System.out.println("Pré-ordem: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());

        arvoreBinaria.remover(3);

        System.out.println("Pré-ordem após remoção da raiz: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
    }
}