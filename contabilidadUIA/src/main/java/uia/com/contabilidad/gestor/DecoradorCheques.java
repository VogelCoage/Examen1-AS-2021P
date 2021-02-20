package uia.com.contabilidad.gestor;

import uia.com.contabilidad.cheques.*;

public class DecoradorCheques extends Decorador {
	
	public DecoradorCheques(IGestor gestor, String tipo)
	{
		super(gestor, tipo);
	}
	
	
	public DecoradorCheques()
	{		
	}
	
	public void validaCheques()
	{
		super.Print();
	}
	
	public void registraCheque(Cheque cheque) {
		//super.Print();
		System.out.println("\nEl Cheque: ");
		cheque.Print();
		System.out.println("ha sido registrado\n");
	}

}
