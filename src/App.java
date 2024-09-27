public class App {
    public static void main(String[] args) {
        String[] terminais = {"Terminal de ananindeua", "Terminal de belém", "Terminal de castanhal", "Terminal de Bragança", "Terminal de fortaleza","Terminal de caralho"};
        Terminal grafoTerminais = new Terminal(6, terminais);
        

        grafoTerminais.adicionarArestaEntreTerminais("Terminal de ananindeua", "Terminal de belém", 1);
        grafoTerminais.adicionarArestaEntreTerminais("Terminal de castanhal", "Terminal de Bragança", 1);
        grafoTerminais.adicionarArestaEntreTerminais("Terminal de fortaleza", "Terminal de caralho", 1);

        grafoTerminais.buscaDFS("Terminal de Ananindeua", "Terminal de belém"); // Exemplo de saída: "Terminal A vai até Terminal B", "Terminal B vai até Terminal C", "Terminal C vai até Terminal D"
        //grafoTerminais.buscaDFS("A", "E"); // Exemplo de saída: "Não existe caminho entre os terminais."
        grafoTerminais.exibirMatriz();
    }
}

