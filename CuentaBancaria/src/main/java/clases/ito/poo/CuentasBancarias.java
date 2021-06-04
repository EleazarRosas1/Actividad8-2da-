package clases.ito.poo;
import java.time.LocalDate;
import java.util.Arrays;

import clases.ito.poo.CuentaBancaria;
import interfaces.ito.poo.Arreglo;

public class CuentasBancarias implements Arreglo<CuentaBancaria>{/*normalmente aparece como Arreglo<T> y e vez de 
	t debemos de arreglarlo, agregando el nombre de la clase, con la cual se va a trabajar, como ejemplo: trabajaremos 
	con la clase CuentaBancaria*/

	private CuentaBancaria cuentas[]=null;
	private int ultimo=0;
	private  final int INC=5;

	
	public CuentasBancarias() {
		super();
		this.cuentas=new CuentaBancaria[INC];
		this.ultimo=-1;//indica que esta vacio el arreglo
	}
	private void crecerArreglo() {
		CuentaBancaria temporal[]=new CuentaBancaria[this.cuentas.length+INC];
		for(int i=0; i<this.cuentas.length;i++)
			temporal[i]=cuentas[i];
		cuentas =temporal;
	}
	@Override
	public boolean addItem(CuentaBancaria item) {
		// TODO Auto-generated method stub
		boolean bandera=false;
		if (!existeItem(item)){
			if(isFull())
				crecerArreglo();
			int i=0;
			for(;i<=this.ultimo;i++)
				if(item.compareTo(cuentas[i])<0) {
					break;
					
				}
			for(int j=this.ultimo;j>=i;j--)
				cuentas[j+1]=cuentas[j];
			cuentas[i]=item;
			this.ultimo++;
			bandera=true;
			
			
		}
		return bandera;
		
	}

	@Override
	public boolean existeItem(CuentaBancaria item) {
		// TODO Auto-generated method stub
		boolean existe =false;
		for(int i=0;i<=this.ultimo;i++)
			if(item.compareTo(cuentas[i])==0) {
				existe=true;
				break;
			}
		return existe;
	}
	

	@Override
	public CuentaBancaria getItem(int pos) {
		// TODO Auto-generated method stub
		CuentaBancaria cb=null;
		if (!this.isFree()&& pos<=this.ultimo)
			cb=cuentas[pos];
		
		return cb;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.ultimo+1;
	}

	@Override
	public boolean delete(CuentaBancaria item) {
		// TODO Auto-generated method stub
		boolean delete=false;
		if(this.existeItem(item))/*identifixa si existe item*/ {
			int i=0;
			for (;i<=this.ultimo;i++)/*inicio de reacomodo de areglo*/
				if(item.compareTo(cuentas[i])==0)
					break;
			for(;i<this.ultimo;i++)
				cuentas [i]=cuentas[i+1];
			this.ultimo--;
			delete=true;
		}
		return delete;
	}

	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		return this.ultimo==-1;
	}

	@Override
	public boolean isFull() {
		// Muestra la longitud del arreglo, ejemplo si esta en posicion 4+1=5
		return this.ultimo+1==this.cuentas.length;
	}
	
	public CuentaBancaria Deposito(int posicion,float monto) {
	posicion=posicion-1;
		CuentaBancaria cb=null;
		if ( posicion<=this.ultimo){
			cb=cuentas[posicion];
			cb.setSaldo(cb.getSaldo()+monto);			
		}
				cb.setFechaActualizacion(LocalDate.now());		
				return cb;
	}
	public CuentaBancaria Retiro(int posicion, float monto) {
		posicion=posicion-1;
		CuentaBancaria td=null;
		if(posicion<=this.ultimo) {
			td=cuentas[posicion];
			if(td.getSaldo()<monto) {
				System.out.println("\n\n\nEl saldo es insuficiente para hacer un retiro, y queda de la siguiente manera:");
			}else 
				td.setSaldo(td.getSaldo()-monto);
						}
		td.setFechaActualizacion(LocalDate.now());
		return td;
		
	}
	
	public CuentaBancaria EliminarCuenta(int pos)/*RECIBE LA POSICION DE LA CUENTA QUE QUIERE ELIMINAR*/ {
		pos=pos-1;
		CuentaBancaria am=null;
		if(pos<=this.ultimo) {
			am=cuentas[pos];
			this.delete(am);			
		}
		return am;
	}
	
	
	
}

	

