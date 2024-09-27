import java.util.ArrayList;
import java.util.Arrays;

public class App {
        public static void main(String[] args) {
            
            ArrayList<String> terminais = new ArrayList<>(Arrays.asList("Terminal de ananindeua", "Terminal de belém", "Terminal de castanhal", "Terminal de Bragança", "Terminal de Tauá","Terminal de Santa Izabel"));
            
            Terminal grafoTerminais = new Terminal(terminais.size(), terminais);
            

            grafoTerminais.adicionarArestaEntreTerminais("Terminal de ananindeua", "Terminal de belém", 3); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de belém", "Terminal de ananindeua", 6); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de castanhal", "Terminal de Bragança", 2); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de Bragança", "Terminal de castanhal", 5); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de Tauá", "Terminal de Santa Izabel", 5); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de Santa Izabel", "Terminal de Tauá", 1); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de ananindeua", "Terminal de Bragança", 8); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de belém", "Terminal de castanhal", 1); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de castanhal", "Terminal de belém", 1); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de belém", "Terminal de Bragança", 1); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de belém", "Terminal de Tauá", 1); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de Tauá", "Terminal de belém", 1); 
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de belém", "Terminal de Santa Izabel", 1); 


            grafoTerminais.conexoes("Terminal de belém");
            

            int[] graus = grafoTerminais.grau();
            System.out.println("Grau de todos os terminais: " + Arrays.toString(graus));
    
            
            int grauEspecifico = grafoTerminais.grau(1); 
            System.out.println("Grau do Terminal de Belém: " + grauEspecifico);

            grafoTerminais.exibirMatriz();

            grafoTerminais.floydWarshall();

        }
    }

