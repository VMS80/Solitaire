
package solitariov2;

import javax.swing.JOptionPane;

public class Senku {
    
    int posicionFI;
    int posicionFF;
    int posicionCI;
    int posicionCF;
    char [][] matriz;


    
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
    
}
