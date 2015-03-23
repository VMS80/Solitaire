/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariov2;

import java.awt.Color;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.text.Caret;

/**
 *
 * @author Sergio
 */
public class framePrincipal extends javax.swing.JFrame {
    

    
    
    int fCursor = 51;
    int cCursor = 52;
    int tamanio = 7;
    char [][] matriz = new char[tamanio][tamanio];
    int puntoF = tamanio/2;
    int puntoC = tamanio/2;
    boolean seleccionado = false;
    
    //posiciones en la matriz iniciales seleccionadas para el cambio
    int posicionFI;
    int posicionCI;
    //posiciones en la matriz finales seleccionadas para el cambio
    int posicionFF;
    int posicionCF;
    
    Senku juego = new Senku(matriz, tamanio);
    

    public framePrincipal() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaMostrar = new javax.swing.JTextArea();
        botonMostrar = new javax.swing.JButton();
        botonArriba = new javax.swing.JButton();
        botonIzquierda = new javax.swing.JButton();
        botonDerecha = new javax.swing.JButton();
        botonAbajo = new javax.swing.JButton();
        botonGo = new javax.swing.JButton();
        etiquetaNJugadas = new javax.swing.JLabel();
        textoNJugadas = new javax.swing.JTextField();
        botonDeshacer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaMostrar.setEditable(false);
        areaMostrar.setColumns(20);
        areaMostrar.setFont(new java.awt.Font("Rod", 0, 18)); // NOI18N
        areaMostrar.setRows(5);
        jScrollPane1.setViewportView(areaMostrar);

        botonMostrar.setText("Mostrar");
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarActionPerformed(evt);
            }
        });

        botonArriba.setText("↑");
        botonArriba.setEnabled(false);
        botonArriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonArribaActionPerformed(evt);
            }
        });

        botonIzquierda.setText("←");
        botonIzquierda.setEnabled(false);
        botonIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIzquierdaActionPerformed(evt);
            }
        });

        botonDerecha.setText("→");
        botonDerecha.setEnabled(false);
        botonDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDerechaActionPerformed(evt);
            }
        });

        botonAbajo.setText("↓");
        botonAbajo.setEnabled(false);
        botonAbajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbajoActionPerformed(evt);
            }
        });

        botonGo.setText("GO");
        botonGo.setEnabled(false);
        botonGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGoActionPerformed(evt);
            }
        });

        etiquetaNJugadas.setText("Nº Jugadas:");

        textoNJugadas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        botonDeshacer.setText("Deshacer");
        botonDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDeshacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaNJugadas)
                        .addGap(30, 30, 30)
                        .addComponent(textoNJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(botonDeshacer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(botonIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(botonArriba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonAbajo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonGo, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(botonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonMostrar)
                        .addGap(18, 18, 18)
                        .addComponent(botonArriba)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonGo)
                            .addComponent(botonIzquierda)
                            .addComponent(botonDerecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAbajo)
                        .addGap(18, 18, 18)
                        .addComponent(botonDeshacer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaNJugadas)
                            .addComponent(textoNJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
       // char [][] matriz = new char[7][7];
        

        
        
        muestraMatriz();

        areaMostrar.setSelectionColor(Color.red);
        areaMostrar.setSelectionStart(51);
        areaMostrar.setSelectionEnd(52);
        areaMostrar.requestFocus();
        
        activaFlechas();


         
    }//GEN-LAST:event_botonMostrarActionPerformed

    private void botonArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonArribaActionPerformed
        if(puntoF>0){
            if (matriz[puntoF-1][puntoC]=='#' || matriz[puntoF-1][puntoC] == 'O'){
                areaMostrar.setSelectionStart(fCursor-15);
                areaMostrar.setSelectionEnd(fCursor-14);
                areaMostrar.requestFocus();
                fCursor-=15;
                puntoF-=1;           
            }
        }
        areaMostrar.requestFocus();
    }//GEN-LAST:event_botonArribaActionPerformed

    private void botonAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbajoActionPerformed
        if(puntoF<tamanio-1){
            if(matriz[puntoF+1][puntoC]=='#' || matriz[puntoF+1][puntoC] == 'O'){
                areaMostrar.setSelectionStart(fCursor+15);
                areaMostrar.setSelectionEnd(fCursor+16);
                areaMostrar.requestFocus();
                fCursor +=15;
                puntoF+=1;
            }
        }
        areaMostrar.requestFocus();
    }//GEN-LAST:event_botonAbajoActionPerformed

    private void botonDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDerechaActionPerformed
        if (puntoC<tamanio-1){
            if(matriz[puntoF][puntoC+1] == '#' || matriz[puntoF][puntoC+1] == 'O'){
                areaMostrar.setSelectionStart(fCursor +2 );
                areaMostrar.setSelectionEnd(fCursor + 3);
                areaMostrar.requestFocus();
                fCursor +=2;
                puntoC+=1;
            }
        }
        areaMostrar.requestFocus();
            
    }//GEN-LAST:event_botonDerechaActionPerformed

    private void botonIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIzquierdaActionPerformed
        if (puntoC>0){
                if(matriz[puntoF][puntoC-1] == '#' || matriz[puntoF][puntoC-1] == 'O'){
                areaMostrar.setSelectionStart(fCursor -2);
                areaMostrar.setSelectionEnd(fCursor -1);
                areaMostrar.requestFocus();
                puntoC-=1;
                fCursor -=2;
            } 
        }
        areaMostrar.requestFocus();
    }//GEN-LAST:event_botonIzquierdaActionPerformed

    private void botonGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGoActionPerformed
        
        if (areaMostrar.getSelectionColor()== Color.red && matriz[puntoF][puntoC] == '#'){
            areaMostrar.setSelectionColor(Color.green);
            seleccionado = true;
            posicionFI = puntoF;
            posicionCI = puntoC;
        }else{
            areaMostrar.setSelectionColor(Color.red);
            seleccionado = false;
            posicionFF = puntoF;
            posicionCF = puntoC;
        }
        
        
        
        if (!seleccionado){
            if (!juego.Comprueba(posicionFI, posicionFF, posicionCI, posicionCF)){
                JOptionPane.showMessageDialog(this, "Movimiento no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                textoNJugadas.setText(String.valueOf(juego.getNMovimiento()));
            }
        }
        
        
        muestraMatriz(); 
        areaMostrar.setSelectionStart(fCursor);
        areaMostrar.setSelectionEnd(fCursor+1);
        areaMostrar.requestFocus();
        
    }//GEN-LAST:event_botonGoActionPerformed

    private void botonDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDeshacerActionPerformed
        textoNJugadas.setText(String.valueOf(juego.deshaceMovimiento()));
        muestraMatriz();
        areaMostrar.setSelectionStart(fCursor);
        areaMostrar.setSelectionEnd(fCursor+1);
        areaMostrar.requestFocus();
    }//GEN-LAST:event_botonDeshacerActionPerformed
    
    private void activaFlechas(){
        botonArriba.setEnabled(true);
        botonAbajo.setEnabled(true);
        botonIzquierda.setEnabled(true);
        botonDerecha.setEnabled(true);
        botonGo.setEnabled(true);        
    }
    
    private void recuperaCursor(){
        
    }
    
    private void muestraMatriz(){
        areaMostrar.setText("");
        
        for(int f = 0; f < tamanio ; f++){
            for (int c = 0; c < tamanio; c++){
                areaMostrar.append(matriz[f][c] + " ");
            }
            areaMostrar.append("\n");
        }
    }
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(framePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(framePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(framePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(framePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new framePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMostrar;
    private javax.swing.JButton botonAbajo;
    private javax.swing.JButton botonArriba;
    private javax.swing.JButton botonDerecha;
    private javax.swing.JButton botonDeshacer;
    private javax.swing.JButton botonGo;
    private javax.swing.JButton botonIzquierda;
    private javax.swing.JButton botonMostrar;
    private javax.swing.JLabel etiquetaNJugadas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textoNJugadas;
    // End of variables declaration//GEN-END:variables
}
