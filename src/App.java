import java.util.ArrayList;
import java.util.Arrays;

public class App {
        public static void main(String[] args) {
            ArrayList<String> terminais = new ArrayList<>(Arrays.asList("Terminal de ananindeua", "Terminal de belém", "Terminal de castanhal", "Terminal de Bragança", "Terminal de fortaleza","Terminal de sei la aonde"));
            
            Terminal grafoTerminais = new Terminal(6, terminais);
            

            grafoTerminais.adicionarArestaEntreTerminais("Terminal de ananindeua", "Terminal de belém", 1);
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de castanhal", "Terminal de Bragança", 1);
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de fortaleza", "Terminal de sei la aonde", 1);
            grafoTerminais.adicionarArestaEntreTerminais("Terminal de ananindeua", "Terminal de Bragança", 1);

            grafoTerminais.conexoes("Terminal de Ananindeua");
            grafoTerminais.conexoes("Terminal de castanhal");
            grafoTerminais.conexoes("Terminal de fortaleza");

            int[] graus = grafoTerminais.grau();
            System.out.println("Grau de todos os terminais: " + Arrays.toString(graus));
    
            
            int grauEspecifico = grafoTerminais.grau(0); 
            System.out.println("Grau do Terminal de ananindeua: " + grauEspecifico);

            grafoTerminais.exibirMatriz();
        }
    }

