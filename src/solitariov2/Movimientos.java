
package solitariov2;
    
public class Movimientos {
    int posicionFI;
    int posicionCI;
    int posicionFF;
    int posicionCF;
    int posicionFInter;
    int posicionCInter;
    char origen;
    char intermedio;
    char destino;
    
    Movimientos(int posFI, int posCI, int posFF, int posCF, int posFInter, 
            int posCInter, char origen, char destino, char intermedio){
        
        this.posicionFI = posFI;
        this.posicionCI = posCI;
        this.posicionFF = posFF;
        this.posicionCF = posCF;
        this.posicionFInter = posFInter;
        this.posicionCInter = posCInter;
        this.origen = origen;
        this.destino = destino;
        this.intermedio = intermedio;   
    }
    
    /*@Override
    public String toString(){
        String movimientoDevuelto;
        
        movimientoDevuelto = posicionFI + " " + posicionCI + " " + posicionFF + " " + posicionCF + " " +
                posicionFInter + " " + posicionCInter + " " + origen + " " + destino + " " + intermedio;
        
        return movimientoDevuelto;
    }*/
    
    
   
}
