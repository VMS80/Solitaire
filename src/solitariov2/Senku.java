
package solitariov2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

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

    
    
    
   
    
    
    
}
