package TransacaoBancaria;
import Strategy.*;
import Memento.*;

public class TransacaoConcluida {
	private Transacao transacao = new Transacao();
	private MetodoPagamento metodoPagamento;
	//Criando Memento e armazenando as informa��es
	TransacaoEditor editor = new TransacaoEditor();
	ListaTransacoes careTaker = new ListaTransacoes();
	
	public void RealizarPagamento(Double valor) {
		metodoPagamento.processarPagamento(valor);
	}
	
	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
	
	public void concluirTransacao() {
		System.out.println("");
		System.out.println("Transacao concluida com sucesso!");
		transacao.getTipo();
		transacao.getValor();
		setMetodoPagamento(transacao.getTipo());
		RealizarPagamento(transacao.getValor());
		editor.setTransacao(transacao);
		careTaker.addMemento(editor.saveToMemento());
		transacao.setAprovada(true);
	}
	
	public ListaTransacoes getTransacoes() {
		return careTaker;
	}
	
	//Getters e Setters
	
	public Transacao getTransacao() {
		return transacao;
	}
	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
}
