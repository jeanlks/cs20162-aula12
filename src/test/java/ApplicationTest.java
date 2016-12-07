

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.inf.ufg.controller.ControllerExecuta;
import br.inf.ufg.controller.ControllerRead;
import br.inf.ufg.controller.ControllerRetorno;
import br.inf.ufg.controller.ControllerWriteHTML;
import br.inf.ufg.controller.ControllerWriteJson;
import br.inf.ufg.view.Application;
import br.inf.ufg.write.WriteInterface;

public class ApplicationTest {
    Application application;
    ControllerRead controllerRead;
    WriteInterface controllerWrite;
    ControllerRetorno controllerRetorno;
    ControllerExecuta controllerExecuta;
    Long tempoInicial,tempoFinal,tempoDecorrido,usoMemoria;
    Runtime runtime;
    List<String[]> resultado =
            new ArrayList<String[]>();
    
    @Before
    public void init(){
      application = new Application(); 
      controllerRead = new ControllerRead();
      controllerExecuta = new ControllerExecuta();
      controllerRetorno = new ControllerRetorno();
      runtime = Runtime.getRuntime();
    }
    
    
    @Test
    public void testMainFluxoHtml() throws IOException{
        Application application = new Application();
        String[] args = new String[2];
        args[0] = "test.txt";
        args[1] = "-h";
      
        application.main(args);
    }
    
    @Test
    public void testMainFluxoJson() throws IOException{
        Application application = new Application();
        String[] args = new String[1];
        args[0] = "test.txt";
        application.main(args);
    }
    @Test
    public void testMainFluxoResultado() throws IOException{
        Application application = new Application();
        String[] args = new String[2];
        args[0] = "test.txt";
        args[1] = "-8";
        application.main(args);
    }
    @Test
    public void testLendoArquivoEEscrevendoJSON() throws IOException {
        tempoInicial = System.currentTimeMillis();
        resultado = controllerRead.lerArquivo("test.txt");
        controllerRetorno.setListaRetorno(controllerExecuta.executa(resultado));
        controllerWrite = new ControllerWriteJson();
        tempoFinal = System.currentTimeMillis();
        tempoDecorrido = tempoFinal -tempoInicial;
        usoMemoria = runtime.totalMemory() - runtime.freeMemory();
        controllerWrite.write(controllerRetorno.getListaRetorno(),tempoDecorrido,usoMemoria);
        assertNotNull(controllerRead.lerArquivo("test.txt"));
         
    }
    @Test(expected = NullPointerException.class)
    public void testLendoArquivoNaoExistenteNet() throws IOException  {
        controllerRead.lerArquivo("https://raw.githubusercontent.com/jeanlks/cs20162-aula12/master/testsdf.txt");   
    }
    
    @Test(expected = NullPointerException.class)
    public void testLendoArquivoNaoExistenteLocal() throws IOException  {
        controllerRead.lerArquivo("/testsdf.txt");   
    }

    @Test
    public void testLendoArquivoEEscrevendoHTML() throws IOException {
        tempoInicial = System.currentTimeMillis();
        resultado = controllerRead.lerArquivo("https://raw.githubusercontent.com/jeanlks/cs20162-aula12/master/test.txt");
        controllerRetorno.setListaRetorno(controllerExecuta.executa(resultado));
        
        controllerWrite = new ControllerWriteHTML();
        tempoFinal = System.currentTimeMillis();
        tempoDecorrido = tempoFinal -tempoInicial;
        usoMemoria = runtime.totalMemory() - runtime.freeMemory();
        controllerRetorno.setUsoMemoria(usoMemoria);
        controllerRetorno.setTempoDecorrido(tempoDecorrido);
        controllerWrite.write(controllerRetorno.getListaRetorno(),tempoDecorrido, usoMemoria);
        
    }
    @Test 
    public void testTempoDecorrido() throws IOException{
        tempoInicial = System.currentTimeMillis();
        resultado = controllerRead.lerArquivo("test.txt");
        controllerRetorno.setListaRetorno(controllerExecuta.executa(resultado));
        controllerWrite = new ControllerWriteHTML();
        tempoFinal = System.currentTimeMillis();
        tempoDecorrido = tempoFinal -tempoInicial;
        usoMemoria = runtime.totalMemory() - runtime.freeMemory();
        controllerRetorno.setUsoMemoria(usoMemoria);
        controllerRetorno.setTempoDecorrido(tempoDecorrido);
        assertNotNull(controllerRetorno.getTempoDecorrido());
    }
    @Test 
    public void testUsoDeMemoria() throws IOException{
        tempoInicial = System.currentTimeMillis();
        resultado = controllerRead.lerArquivo("test.txt");
        controllerRetorno.setListaRetorno(controllerExecuta.executa(resultado));
        controllerWrite = new ControllerWriteHTML();
        tempoFinal = System.currentTimeMillis();
        tempoDecorrido = tempoFinal -tempoInicial;
        usoMemoria = runtime.totalMemory() - runtime.freeMemory();
        controllerRetorno.setUsoMemoria(usoMemoria);
        controllerRetorno.setTempoDecorrido(tempoDecorrido);
        assertNotNull(controllerRetorno.getUsoMemoria());
    }

}
