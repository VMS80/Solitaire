
package solitariov2;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Senku {
    
    int posicionFI;
    int posicionFF;
    int posicionCI;
    int posicionCF;
    int posicionCInter;
    int posicionFInter;
    char origen = '#';
    char destino = 'O';
    char intermedio = '#';
    char [][] matriz;
    int contadorMov = 0;
    ArrayList<Movimientos> listado = new ArrayList();


    
    Senku(char[][] matriz,int tamanio){
        this.matriz = matriz;
        
        for(int f = 0; f < tamanio ; f++){
            for (int c = 0; c < tamanio; c++){
                if((f <=1 && c<=1) || (f<=1 && c>=5) || (f>=5 && c<=1 )|| (c>=5 && f>=5)){
                    matriz [f][c] = ' ';
                }else{
                    if (f == tamanio/2 && c == tamanio/2){
                        matriz [f][c] = 'O';
                    }else{
                        matriz [f][c] = '#';                     }
                }
            }
        }
    }
    
    public boolean Comprueba(int posicionFI, int posicionFF, int posicionCI, int posicionCF){
        this.posicionFI = posicionFI;
        this.posicionFF = posicionFF;
        this.posicionCI = posicionCI;
        this.posicionCF = posicionCF;
        
        switch(getMovimiento()){
                    case("izquierda"):
                        if(matriz[posicionFF][posicionCF] == 'O' && matriz[posicionFF][posicionCF+1] == '#'
                                && posicionCF - posicionCI == -2){
                            this.posicionFInter = posicionFF;
                            this.posicionCInter = posicionCF+1;
                            guardaMovimiento();
                            matriz[posicionFF][posicionCF] = '#';
                            matriz[posicionFF][posicionCF+1] = 'O';
                            matriz[posicionFI][posicionCI] = 'O';
                            return true;
                        }else{
                            return false;
                        }                        
                    case("derecha"):
                        if(matriz[posicionFF][posicionCF] == 'O' && matriz[posicionFF][posicionCF-1] == '#'
                                && posicionCF - posicionCI == 2){
                            this.posicionFInter = posicionFI;
                            this.posicionCInter = posicionCF-1;
                            guardaMovimiento();                            
                            matriz[posicionFF][posicionCF] = '#';
                            matriz[posicionFF][posicionCF-1] = 'O';
                            matriz[posicionFI][posicionCI] = 'O';
                            return true;
                        }else{
                            return false;
                        }                       
                    case("arriba"):
                        if(matriz[posicionFF][posicionCF] == 'O' && matriz[posicionFF+1][posicionCF] == '#'
                                && posicionFF - posicionFI == -2){
                            this.posicionFInter = posicionFF+1;
                            this.posicionCInter = posicionCI;
                            guardaMovimiento();
                            matriz[posicionFF][posicionCF] = '#';
                            matriz[posicionFF+1][posicionCF] = 'O';
                            matriz[posicionFI][posicionCI] = 'O';                            
                            return true;
                        }else{
                            return false;
                        }
                    case("abajo"):
                        if(matriz[posicionFF][posicionCF] == 'O' && matriz[posicionFF-1][posicionCF] == '#'
                                && posicionFF - posicionFI == 2){
                            this.posicionFInter = posicionFF-1;
                            this.posicionCInter = posicionCI;
                            guardaMovimiento();
                            matriz[posicionFF][posicionCF] = '#';
                            matriz[posicionFF-1][posicionCF] = 'O';
                            matriz[posicionFI][posicionCI] = 'O';
                            return true;
                        }else{
                            return false;
                        }

        }
        return false;
    }
    
    
    private String getMovimiento(){
        if (posicionFI>posicionFF){
            return "arriba";
        }
        
        if (posicionFI<posicionFF){
            return "abajo";
        }
        
        if (posicionCI > posicionCF){
            return "izquierda";
        }
        
        if (posicionCI < posicionCF){
            return "derecha";
        }
        
        return "";
    }
    
    public int getNMovimiento(){
        this.contadorMov++;
        return this.contadorMov;
    }
    
    public void guardaMovimiento(){
        Movimientos movimiento = new Movimientos(posicionFI, posicionCI, posicionFF, posicionCF,
                                 posicionFInter, posicionCInter, origen, destino, intermedio);
        listado.add(movimiento);
    }
    
    public int deshaceMovimiento(){
        if(contadorMov>0){
            Movimientos movimiento = listado.get(contadorMov-1);
            posicionFI = movimiento.posicionFI;
            posicionCI = movimiento.posicionCI;
            posicionFF = movimiento.posicionFF;
            posicionCF = movimiento.posicionCF;
            posicionFInter = movimiento.posicionFInter;
            posicionCInter = movimiento.posicionCInter;
            origen = movimiento.origen;
            destino = movimiento.destino;
            intermedio = movimiento.intermedio;
            matriz[posicionFI][posicionCI] = origen;
            matriz[posicionFF][posicionCF] = destino;
            matriz[posicionFInter][posicionCInter] = intermedio;
            listado.remove(contadorMov-1);
            contadorMov--;
            return contadorMov;
        }
        return contadorMov;
    }
    
    public void guardaFichero() throws ParserConfigurationException, TransformerConfigurationException, TransformerException{
        

            DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
            Document documento = creadorDocumento.newDocument();

            Element elementoRaiz = documento.createElement("MOVIMIENTOS");
            documento.appendChild(elementoRaiz);
            for (int i =0;i<listado.size();i++){
                Movimientos movimiento = listado.get(i);
                Element elementoMovimiento = documento.createElement("MOVIMIENTO");
                elementoRaiz.appendChild(elementoMovimiento);

                Element elementoFilaInicial = documento.createElement("FILA_INICIAL");
                elementoMovimiento.appendChild(elementoFilaInicial);
                Text textoFilaInicial = documento.createTextNode(String.valueOf(movimiento.posicionFI));
                elementoFilaInicial.appendChild(textoFilaInicial);

                Element elementoColumnaInicial = documento.createElement("COLUMNA_INICIAL");
                elementoMovimiento.appendChild(elementoColumnaInicial);
                Text textoColumnaInicial = documento.createTextNode(String.valueOf(movimiento.posicionCI));
                elementoColumnaInicial.appendChild(textoColumnaInicial);

                Element elementoFilaFinal = documento.createElement("FILA_FINAL");
                elementoMovimiento.appendChild(elementoFilaFinal);
                Text textoFilaFinal = documento.createTextNode(String.valueOf(movimiento.posicionFF));
                elementoFilaFinal.appendChild(textoFilaFinal);

                Element elementoColumnaFinal = documento.createElement("COLUMNA_FINAL");
                elementoMovimiento.appendChild(elementoColumnaFinal);
                Text textoColumnaFinal = documento.createTextNode(String.valueOf(movimiento.posicionCF));
                elementoColumnaFinal.appendChild(textoColumnaFinal);

                Element elementoFilaIntermedia = documento.createElement("FILA_INTERMEDIA");
                elementoMovimiento.appendChild(elementoFilaIntermedia);
                Text textoFilaIntermedia = documento.createTextNode(String.valueOf(movimiento.posicionFInter));
                elementoFilaIntermedia.appendChild(textoFilaIntermedia);

                Element elementoColumnaIntermedia = documento.createElement("COLUMNA_INTERMEDIA");
                elementoMovimiento.appendChild(elementoColumnaIntermedia);
                Text textoColumnaIntermedia = documento.createTextNode(String.valueOf(movimiento.posicionCInter)); 
                elementoColumnaIntermedia.appendChild(textoColumnaIntermedia);
        }
            TransformerFactory fabricaTransformador = TransformerFactory.newInstance();
            Transformer transformador = fabricaTransformador.newTransformer();

            transformador.setOutputProperty(OutputKeys.INDENT, "yes");

            transformador.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "3");
            Source origen = new DOMSource(documento);
            Result destino = new StreamResult("movimientos.xml");
            transformador.transform(origen, destino);
        
        
    }
}
