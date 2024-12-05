package Strategy;

public class CartaoDebito implements MetodoPagamento{

	@Override
	public void processarPagamento(Double valor) {
		System.out.println("Pagamento efetuado: R$ " + valor + " com Cartao de Debito");
		
	}

	@Override
	public String toString() {
		return "Cartao de Debito";
	}
	
}
