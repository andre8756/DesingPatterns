package MainApplication;

import java.time.LocalTime;
import java.util.Scanner;

import Memento.ListaTransacoes;
import Memento.TransacaoEditor;
import Strategy.BoletoBancario;
import Strategy.CartaoCredito;
import Strategy.CartaoDebito;
import Strategy.MetodoPagamento;
import Strategy.Pix;
import TransacaoBancaria.Autorizador;
import TransacaoBancaria.Transacao;
import TransacaoBancaria.VerificadorHorario;
import TransacaoBancaria.VerificadorLimiteTransacional;
import TransacaoBancaria.VerificadorSaldo;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Configurando Handlers
		Autorizador verificaSaldo = new VerificadorSaldo();
		Autorizador verificaLimite = new VerificadorLimiteTransacional();
		Autorizador verificaHorario = new VerificadorHorario();
		//Setando o proximo Handler		
		verificaSaldo.setProximo(verificaLimite);
		verificaLimite.setProximo(verificaHorario);
		
		//Criando Memento e armazenando as informa��es
		TransacaoEditor editor = new TransacaoEditor();
		ListaTransacoes careTaker = new ListaTransacoes();
		
		//Variaveis do programa
		int opcao;
		double saldoDisponivel;
		double limiteTransacional;
		
		System.out.println("** Informações importantes:\n");
		System.out.print("Saldo na conta: R$ ");
		saldoDisponivel = scanner.nextDouble();
		System.out.print("Limite Transacional: R$ ");
		limiteTransacional = scanner.nextDouble();
		System.out.println("");
		System.out.println("Programa de Transação Bancária \n");
		
		
		
		do {
			
			System.out.println("1. Realizar transação");
			System.out.println("2. Histórico de transações");
			System.out.println("3. Acessar informações do banco");
			System.out.println("4. Sair");
			System.out.print("Escolha uma opcao: ");
			opcao = scanner.nextInt();
			System.out.println();
			
			switch(opcao) {
			case 1: 
				System.out.print("Digite o valor da transação: R$ ");
				double valor = scanner.nextDouble();
				System.out.println("Método de pagamento:");
				System.out.println("1. Pix");
				System.out.println("2. Cartão de Crédito");
				System.out.println("3. Cartão de Débito");
				System.out.println("4. Boleto");
				System.out.print("Escolha o método de pagamento: ");
				int pagamentoOpcao = scanner.nextInt();
				MetodoPagamento metodopagamento;
				
				switch(pagamentoOpcao) {
				case 1:	metodopagamento = new Pix(); break;
				case 2: metodopagamento = new CartaoCredito(); break;
				case 3: metodopagamento = new CartaoDebito(); break;
				case 4: metodopagamento = new BoletoBancario(); break;
				default: System.out.println("Opcao inválida"); continue;
				}
				
				Transacao transacao = new Transacao(valor, saldoDisponivel,
				limiteTransacional, LocalTime.now(), metodopagamento);
				LocalTime horaEspecifica = LocalTime.of(14, 30);
				transacao.setHoraTransacao(horaEspecifica);
				
				System.out.println();
				//Chamando a primeira verificação da cadeia (verificador de saldo)
				verificaSaldo.autorizar(transacao);
				saldoDisponivel = saldoDisponivel - transacao.getValor();
				
				System.out.println();
				
				//Adicionando a transação no memento(caso ela estaja aprovada)
				editor.setTransacao(transacao);
				careTaker.addMemento(editor.saveToMemento());
				break;
				
			case 2:
				System.out.println("");
				System.out.println(careTaker.toString());break;
			case 3:
				Transacao transacaoInfo = new Transacao();
				System.out.println("");
				System.out.println("Valor disponível na conta: R$ "+saldoDisponivel);
				System.out.println("Limite Transacional: "+limiteTransacional);
				System.out.println("Horário de funcionamento: ");
				System.out.println(""+transacaoInfo.getHorarioLimiteIncio());
				System.out.println(""+transacaoInfo.getHorarioLimiteFim());
				System.out.println("");
				break;
				
				
			case 4:
				System.out.println("Saindo..."); break;
			}
			
			
		}while (opcao != 4);
		
		
		scanner.close();
		
	}		
}
