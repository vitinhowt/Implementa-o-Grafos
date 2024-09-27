class Terminal extends Grafo {
    private String[] nomesTerminais;

    public Terminal(int numVertices, String[] nomesTerminais) {
        super(numVertices);
        if (nomesTerminais.length != numVertices) {
            throw new IllegalArgumentException("O número de terminais deve ser igual ao número de vértices.");
        }
        this.nomesTerminais = nomesTerminais;
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

    public boolean buscaDFS(String inicio, String destino) {
        int vInicio = obterIndice(inicio);
        int vDestino = obterIndice(destino);
        if (vInicio == -1 || vDestino == -1) {
            System.out.println("Terminal de início ou destino inválido.");
            return false;
        }
        boolean[] visitados = new boolean[numVertices];
        return dfs(vInicio, vDestino, visitados);
    }

    private boolean dfs(int v, int destino, boolean[] visitados) {
        if (v == destino) {
            System.out.println("Terminal " + nomesTerminais[v] + " vai até Terminal " + nomesTerminais[destino]);
            return true;
        }
        visitados[v] = true;

        for (int i = 0; i < numVertices; i++) {
            if (matrizAdjacencia[v][i] > 0 && !visitados[i]) {
                if (dfs(i, destino, visitados)) {
                    System.out.println("Terminal " + nomesTerminais[v] + " vai até Terminal " + nomesTerminais[i]);
                    return true;
                }
            }
        }
        return false;
    }

    private int obterIndice(String nome) {
        for (int i = 0; i < nomesTerminais.length; i++) {
            if (nomesTerminais[i].equals(nome)) {
                return i;
            }
        }
        return -1;
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