
package solitariov2;

import javax.swing.JOptionPane;

public class Senku {
    
    int posicionFI;
    int posicionFF;
    int posicionCI;
    int posicionCF;
    char [][] matriz;


    
    Senku(char[][] matriz){
        this.matriz = matriz;
    }
    
    public void Comprueba(int posicionFI, int posicionFF, int posicionCI, int posicionCF){
        this.posicionFI = posicionFI;
        this.posicionFF = posicionFF;
        this.posicionCI = posicionCI;
        this.posicionFF = posicionFF;
        
        switch(getMovimiento()){
                    case("izquierda"):
                        if(matriz[posicionFF][posicionCF] == 'O' && matriz[posicionFF][posicionCF+1] == '#'
                                && posicionCF - posicionCI == -2){
                            matriz[posicionFF][posicionCF] = '#';
                            matriz[posicionFF][posicionCF+1] = 'O';
                            matriz[posicionFI][posicionCI] = 'O';
                        }else{
                            JOptionPane.showMessageDialog(null, "Movimiento no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case("derecha"):
                        if(matriz[posicionFF][posicionCF] == 'O' && matriz[posicionFF][posicionCF-1] == '#'
                                && posicionCF - posicionCI == 2){
                            matriz[posicionFF][posicionCF] = '#';
                            matriz[posicionFF][posicionCF-1] = 'O';
                            matriz[posicionFI][posicionCI] = 'O';                             
                        }else{
                            JOptionPane.showMessageDialog(null, "Movimiento no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case("arriba"):
                        if(matriz[posicionFF][posicionCF] == 'O' && matriz[posicionFF+1][posicionCF] == '#'
                                && posicionFF - posicionFI == -2){
                            matriz[posicionFF][posicionCF] = '#';
                            matriz[posicionFF+1][posicionCF] = 'O';
                            matriz[posicionFI][posicionCI] = 'O';
                        }else{
                            JOptionPane.showMessageDialog(null, "Movimiento no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case("abajo"):
                        if(matriz[posicionFF][posicionCF] == 'O' && matriz[posicionFF-1][posicionCF] == '#'
                                && posicionFF - posicionFI == 2){
                            matriz[posicionFF][posicionCF] = '#';
                            matriz[posicionFF-1][posicionCF] = 'O';
                            matriz[posicionFI][posicionCI] = 'O';
                        }else{
                            JOptionPane.showMessageDialog(null, "Movimiento no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    break;
        }
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
