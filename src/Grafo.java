class Grafo {
    protected int[][] matrizAdjacencia;
    protected int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdjacencia = new int[numVertices][numVertices];
    }

    public void adicionarAresta(int v1, int v2, int peso) {
        if (v1 >= numVertices || v2 >= numVertices || v1 < 0 || v2 < 0) {
            System.out.println("Vértice não existe!");
            return;
        }
        matrizAdjacencia[v1][v2] += peso;
    }

    public void exibirMatriz() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }
}