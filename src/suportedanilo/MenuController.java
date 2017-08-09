/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suportedanilo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Administração
 */
public class MenuController implements Initializable {

    @FXML
    Label dataAtual;
    @FXML
    Label dataProxima;

    public void sair() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     Scanner ler = new Scanner(System.in);
     String dataAtual1="", dataProxima1="";
    /*System.out.printf("Informe o nome de arquivo texto:\n");
    String nome = ler.nextLine();*/
 
    System.out.printf("\nConteúdo do arquivo texto:\n");
    try {
      FileReader arq = new FileReader("data.txt");
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto
      dataAtual1 = linha;
      while (linha != null) {
        dataProxima1 = linha;
        linha = lerArq.readLine(); // lê da segunda até a última linha        
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }

        
        dataAtual.setText(dataAtual1);
        dataProxima.setText(dataProxima1);
  }

    
}
