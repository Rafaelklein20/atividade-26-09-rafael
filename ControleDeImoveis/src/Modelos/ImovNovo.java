/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Aluno
 */
public class ImovNovo extends Imoveis {
    
        public double getPrecoFinal() {
            double precoFinal = getPreco()*1.10 ;
            
        return precoFinal;
    }
    
}
