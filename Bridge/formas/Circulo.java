package br.com.exemplo.bridge.formas;

import br.com.exemplo.bridge.cores.Cor;

//Abstra��o Refinada para um C�rculo
public class Circulo extends Forma {
 public Circulo(Cor cor) {
     super(cor);
 }

 @Override
 public void desenhar() {
     System.out.print("Desenhando um c�rculo com ");
     cor.aplicarCor();
 }
}