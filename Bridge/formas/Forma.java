package br.com.exemplo.bridge.formas;

import br.com.exemplo.bridge.cores.Cor;

//Abstração
public abstract class Forma {
 protected Cor cor;

 // Construtor que recebe uma implementação de cor
 protected Forma(Cor cor) {
     this.cor = cor;
 }

public abstract void desenhar();
}
