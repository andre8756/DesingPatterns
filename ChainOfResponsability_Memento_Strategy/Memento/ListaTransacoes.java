package Memento;

import java.util.ArrayList;



public class ListaTransacoes {
	public ArrayList<TransacaoEditor.Memento> savedStates = new ArrayList<>();
	
	// Adiciona um novo memento � lista
    public void addMemento(TransacaoEditor.Memento memento) {
    	if (memento.getState().isAprovada()) {
        	savedStates.add(memento);
    	}
    }

    // Recupera o �ltimo memento salvo e remove-o da lista
    public TransacaoEditor.Memento getLastMemento() {
        if (savedStates.size() > 0) {
            return savedStates.remove(savedStates.size() - 1);
        }
        return null;
    }
    
    public TransacaoEditor.Memento getTransacao(int indice) {
    	TransacaoEditor.Memento transacaoAdd = savedStates.get(indice);
    	return transacaoAdd;
    }

	@Override
	public String toString() {
		String informacao = "";
		int i = 1;
		for(TransacaoEditor.Memento memento : savedStates) {
			informacao = informacao+i+" - "+memento.toString()+"\n";
			i++;
		}
		return informacao;
	}
	
	
}