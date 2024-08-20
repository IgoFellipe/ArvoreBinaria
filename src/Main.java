public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(-2);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(8);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(21);

        arvoreBinaria.remover(21);

        System.out.println("Pré-ordem: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());

        System.out.println("Em ordem: ");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());

        System.out.println("Pós Ordem: ");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
    }
}