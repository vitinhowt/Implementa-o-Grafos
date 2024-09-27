import java.util.ArrayList;

class Terminal extends Grafo {
    public static ArrayList<String> nomeTerminais = new ArrayList<>();

    public Terminal(int numVertices, ArrayList<String> nomeTerminais) {
        super(numVertices);
        if (nomeTerminais.size() != numVertices) {
            throw new IllegalArgumentException("O número de terminais deve ser igual ao número de vértices.");
        }
        Terminal.nomeTerminais = nomeTerminais;  // Armazena os nomes dos terminais
    }

    public void adicionarArestaEntreTerminais(String nome1, String nome2, int peso) {
        int v1 = obterIndice(nome1);
        int v2 = obterIndice(nome2);
        if (v1 != -1 && v2 != -1) {
            adicionarAresta(v1, v2, peso);
        } else {
            System.out.println("Um ou ambos os terminais não existem.");
        }
    }


    public void conexoes(String inicio) {
        int vInicio = obterIndice(inicio);
             
        for (int j = 0; j < numVertices; j++) {
            if (matrizAdjacencia[vInicio][j] > 0) {
                System.out.println(nomeTerminais.get(vInicio) + " tem conexão com " + nomeTerminais.get(j) );
                System.out.println();
                System.out.println(nomeTerminais.get(j) + " tem conexão com " + nomeTerminais.get(vInicio) );
                System.out.println();
            }
        }
    
        
    }


    private int obterIndice(String nome) {
        for (int i = 0; i < nomeTerminais.size(); i++) {
            if (nomeTerminais.get(i).equals(nome)) {
                return i;
            }
        }
        return 0;
    }



    public int[] grau() {
        
        int[] graus = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            int grau = 0;
            for (int j = 0; j < numVertices; j++) {
                grau += matrizAdjacencia[i][j];
            }
            graus[i] = grau;
        }
        return graus;
    }
    
    public int grau(int v) {
        if (v >= 0 && v < numVertices) {
            int grau = 0;
            for (int j = 0; j < numVertices; j++) {
                grau += matrizAdjacencia[v][j];
            }
            return grau;
        } else {
            System.out.println("Vértice não existe!");
            return -1; 
        }
    }
    

    @Override
    public void exibirMatriz() {
        // Exibir cabeçalhos das colunas com os nomes dos terminais
        System.out.print("  ");
        for (int i = 0; i < nomeTerminais.size(); i++) {
            String label = "T" + i;
            System.out.print(label + "  ");
        }
        System.out.println(); 

        // Exibir a matriz com os nomes dos terminais como rótulos nas linhas
        for (int i = 0; i < numVertices; i++) {
            String label = "T" + i;
            System.out.print(label + " "); // Nome do terminal na linha
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdjacencia[i][j] + "   ");
            }
            System.out.println();
        }
    }

    //Usado para calulcar a menor distância entre todos os pares de vértices 
    //Complexidade O(n³)
    public void floydWarshall() {
        //É preciso calcular a distância entre cada par de vértice
        int[][] distancias = new int[numVertices][numVertices];

        //Vamo inicializar a matriz de distâncias
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    distancias[i][j] = 0; // Distância de um vértice para ele mesmo é 0
                } else if (matrizAdjacencia[i][j] > 0) {
                    distancias[i][j] = matrizAdjacencia[i][j]; // Aresta direta
                } else {
                    distancias[i][j] = Integer.MAX_VALUE; // Sem aresta, representa "infinito"
                }
            }
        }

        //Imprimir matriz de distância original
        System.out.println("Impressão de matriz de distância original:");
        System.out.print("  ");
        for (int i = 0; i < nomeTerminais.size(); i++) {
            String label = "T" + i;
            System.out.print(label + "  ");
        }
        System.out.println(); 
        for (int i = 0; i < numVertices; i++) {
            String label = "T" + i;
            System.out.print(label + " "); 
            for (int j = 0; j < numVertices; j++) {
                if (distancias[i][j] == Integer.MAX_VALUE) {
                    System.out.print("∞   "); // Exibe o símbolo de infinito
                } else {
                    System.out.print(distancias[i][j] + "   ");
                }
            }
            System.out.println();
        }

        //K será quantas vezes teremos que percorrer uma linha e uma coluna da matriz p/ processo de avaliação dos vértices
        for (int k = 0; k < numVertices; k++){
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distancias[i][k] != Integer.MAX_VALUE && distancias[k][j] != Integer.MAX_VALUE) {
                        distancias[i][j] = Math.min(distancias[i][j], distancias[i][k] + distancias[k][j]);
                    }
                }
            }
        }

        System.out.println("Impressão de matriz de distância final:");
        System.out.print("  ");
        for (int i = 0; i < nomeTerminais.size(); i++) {
            String label = "T" + i;
            System.out.print(label + "  ");
        }
        System.out.println(); 
        for (int i = 0; i < numVertices; i++) {
            String label = "T" + i;
            System.out.print(label + " "); 
            for (int j = 0; j < numVertices; j++) {
                if (distancias[i][j] == Integer.MAX_VALUE) {
                    System.out.print("∞   "); // Exibe o símbolo de infinito
                } else {
                    System.out.print(distancias[i][j] + "   ");
                }
            }
            System.out.println();
        }

    }

}
