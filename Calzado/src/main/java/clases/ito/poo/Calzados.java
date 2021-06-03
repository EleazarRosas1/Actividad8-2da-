package clases.ito.poo;

import interfaces.ito.poo.Arreglo;

public class Calzados implements Arreglo<Calzado> {

	
	private Calzado articulos []=null;
	private int ultimo =0;
	private final int INC=5;
	
	public Calzados() {
		super();
		this.articulos=new Calzado [INC];
		this.ultimo=-1;
	}

	private void crecerArreglo() {
		Calzado temporal[]=new Calzado[this.articulos.length+INC];
		for(int i=0;i<this.articulos.length;i++)
			temporal[i]=articulos[i];
		articulos=temporal;
	}
	@Override
	public boolean addCalzado(Calzado cal) {
		// TODO Auto-generated method stub
		boolean bandera=false;
		if(!existeCalzado(cal)) {
			if(isFull())
				crecerArreglo();
			int i=0;
			for(;i<=this.ultimo;i++)
				if(cal.compareTo(articulos[i])<0) {
					break;
				}
			for(int j=this.ultimo;j>i;j--)
				articulos[j+1]=articulos[j];
			articulos[i]=cal;
			this.ultimo++;
			bandera=true;
		}
		return bandera;
	}

	@Override
	public boolean existeCalzado(Calzado cal) {
		// TODO Auto-generated method stub
		boolean existe =false;
		for (int i=0;i<=this.ultimo;i++)
			if(cal.compareTo(articulos[i])==0) {
				existe=true;
				break;
			}
		return existe;
	}

	@Override
	public Calzado getCalzado(int pos) {
		// TODO Auto-generated method stub
		Calzado cb=null;
		if (this.isFree()&&pos>=this.ultimo)
			cb=articulos[pos];
		return cb;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.ultimo+1;
	}

	@Override
	public boolean delete(Calzado cal) {
		// TODO Auto-generated method stub
		boolean delete=false;
		if(this.existeCalzado(cal)) {
			int i=0;
			for(;i<=this.ultimo;i++)
				if(cal.compareTo(articulos[i])==0)
					break;
			for(;i<this.ultimo;i++)
				articulos[i]=articulos[i+1];
			this.ultimo--;
			delete=true;
		}
		return false;
	}

	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		return this.ultimo==-1;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.ultimo+1==this.articulos.length;
	}
	


}
