package uia.com.contabilidad;

import uia.com.contabilidad.cheques.Cheque;
import uia.com.contabilidad.clientes.Compra;
import uia.com.contabilidad.clientes.Requisicion;
import uia.com.contabilidad.cuentas.Cuenta;
import uia.com.contabilidad.gestor.DecoradorCheques;
import uia.com.contabilidad.gestor.DecoradorCompras;
import uia.com.contabilidad.gestor.DecoradorProveedores;
import uia.com.contabilidad.gestor.DecoradorRequisicion;
import uia.com.contabilidad.gestor.Gestor;
import uia.com.contabilidad.proveedores.Proveedor;

public class Principal {
	public static void main(String[] args) {
		//Se imprime mensaje inicial
		System.out.println("Hola UIA");
		//Se declaran variables de cada clase
		Proveedor proveedor=null;
		Compra compra=null;
		Cuenta cuenta=null;
		Requisicion requisicion=null;
		//Factura factura=null;
		Cheque cheque=null;
		//Se crea la instancia de Gestor envíando como parámetro la ruta al archivo .json
		Gestor contabilidad = new Gestor("/Users/vogel/Desktop/Examen1-AS-master/contabilidadUIA/ListaProveedores.json");
		
		 DecoradorProveedores gestorProveedores = new DecoradorProveedores(contabilidad, "proveedor");
		 DecoradorCompras gestorCompras = new DecoradorCompras(gestorProveedores, "Compra");
		 DecoradorCompras gestorCuentas = new DecoradorCompras(gestorCompras, "Cuenta");
		 DecoradorRequisicion gestorRequisicion = new DecoradorRequisicion(gestorCuentas, "Requisicion");		 
		 DecoradorCheques gestorCheques = new DecoradorCheques(gestorRequisicion, "Cheque");
		 
		 
		 gestorProveedores.Print();
		 gestorCompras.Print();
		 gestorCuentas.Print();
		 gestorRequisicion.Print();
		 gestorCheques.Print();		 
		 proveedor = (Proveedor) gestorProveedores.busca("Alfonso");
		 proveedor.Print();
		 compra = (Compra) gestorCompras.busca("Alfonso-compra-A");
		 compra.Print();
		 cuenta = (Cuenta) gestorCuentas.busca("Alfonso-compra-A-Cuenta-2");
		 cuenta.Print();
		 requisicion = (Requisicion) gestorRequisicion.busca("Alfonso-compra-A-cuenta-1-Req-Cheques");
		 requisicion.Print();
		 
		 requisicion.Print();
		 cheque = (Cheque) gestorCheques.busca("Alfonso-compra-A-cuenta-1-Req-Cheques-ChequesX");
		 cheque.Print();
		 
		requisicion.valida();
		requisicion.Print();
		
		if(requisicion.getEstado() == "Valido") {
			gestorCheques.registraCheque(cheque);
		}
		 
		 
		
	}


}
