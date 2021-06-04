package app.ito.poo;
import clases.ito.poo.CuentasBancarias;
import clases.ito.poo.CuentaBancaria;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Date;
public class Aplicacion {
	static CuentasBancarias c= new CuentasBancarias();
	
	

	
	static void run(){
		
		int l;
		Scanner lector=new Scanner(System.in);
	System.out.println("Bienvenido a Banco bienes mexicanos\n elige con detenimiento lo que desees hacer:"
			+ "\n 1.- Agregar una cuenta \n 2.- Mostrar lista de cuentas agregadas\n 3.- Realizar un deposito"
			+ "\n 4.- Realizar un retiro \n 5.- Eliminar una cuenta\n 6.- Mostrar el menú de consultas\n 7.- Finalizar");
	l=lector.nextInt();
	

	do {
		
		switch(l){
		
		case 1:
			int numerocuenta,monto;
			String nombre,r,f;
			do {
				System.out.println("Ingresa el numero de la cuenta");
					numerocuenta=lector.nextInt();
					lector.nextLine();//se hace para que 
				System.out.println("Ingresa el nombre del titular de cuenta");
					nombre=lector.nextLine();
				System.out.println("ingresa el monto que deseas agregar para la cuenta");
					monto=lector.nextInt();
					lector.nextLine();
				System.out.println("Ingresa la fecha de apertura de la cuenta");
					f=lector.nextLine();
					

					c.addItem(new CuentaBancaria(numerocuenta,nombre,monto,LocalDate.parse(f)));
					 
								System.out.println("Añadiras una nueva cuenta? responder si o no");
					r=lector.nextLine();
					
			}while(r.equalsIgnoreCase("SI"));
			
			break;
			
			
				case 2:
					System.out.println("imprimiendo lista de cuentas agregadas...\n");
					for(int i=0;i<=c.getSize();i++)
						System.out.println(c.getItem(i));
					break;
					
					
					case 3:
						System.out.println("Cuentas disponibles para deposito \n");
						for(int i=0;i<=c.getSize();i++)
							System.out.println("posicion "+(i+1)+c.getItem(i));
						System.out.println("\n\n Elige la posicion de la cuenta en la cual harás el deposito");
						int pos=lector.nextInt();
						lector.nextLine();
						System.out.println("Introduce el monto a depositar");
						float mon=lector.nextFloat();			
						System.out.println("Cuenta con deposito: "+c.Deposito(pos, mon));
						break;
						
						
						
							case 4:
								System.out.println("Cuentas disponibles a retirar");
								for(int i=0;i<=c.getSize();i++)
									System.out.println("posicion "+(i+1)+c.getItem(i));
								System.out.println("\n\nElige la posicion de lacuenta a retirar");
								int pos1=lector.nextInt();
								lector.nextLine();
								System.out.println("¿Cuanto deseas retirar?");
								float ret=lector.nextFloat();
								System.out.println("estado de cuenta despues del retiro: "+c.Retiro(pos1, ret));
									break;
									
									
										case 5:
											System.out.println("Cuentas...\n\n");
											for (int i=0;i<=c.getSize();i++) 
												System.out.println("Posicion "+(i+1)+c.getItem(i));
											System.out.println("\n\n introduce la posicion de la cueta que desees eliminar");
											int posis =lector.nextInt();
											c.EliminarCuenta(posis);
											System.out.println("Cuentas resultantes\n");
											for (int i=0;i<=c.getSize();i++)
												System.out.println(c.getItem(i));
											break;
											
											
											
											case 6:
												int a;
												do {
													System.out.println("Que deseas hacer \n1.- Obtener el monto total de todas las cuentas "
															+ "\n 2.- Obtener el monto promedio entre todas las cuentas"
															+ "\n3.- Obtener el listado de cuentas con saldo superior a $10,000.00 "
															+ "\n 4.- Obtener Cuenta con maximo saldo"
															+ "\n 5.-Obtener la cuenta con el saldo minimo"
															+ "\n 6- Salir");
														a= lector.nextInt();
														switch (a) {
														case 1:
															MontosTotales();
															break;
															
															case 2:
																PromedioMontosTotales();
																break;
																
																case 3:
																	CuentaMillonaria();
																	break;
																	
																	case 4:
																		CuentasMayores2();
																		break;
																		
																		case 5:
																			CuentasMenores2();
																			break;
														}
												}while(a>0&&a<6);
												break;
								
		}	
					
		
		System.out.println("\nBienvenido a Banco bienes mexicanos\n elige con detenimiento lo que desees hacer:"
				+ "\n 1. Agregar una cuenta \n 2. Mostrar lista de cuentas agregadas\n 3.- Realizar un deposito"
				+ "\n4.-Realizar un retiro \n 5.- Eliminar una cuenta\n 6.- Mostrar el menú de consultas\n 7.- Finalizar");
		l=lector.nextInt();
		 
	}while(l>0&&l<7);
	
	
	
	
	}
	 static void MontosTotales() {
		float monto=0;
		for(int i=0;i<c.getSize();i++) {
			monto+=c.getItem(i).getSaldo();
			
		}
			System.out.println("Monto total: $ "+monto);
	}
	
		
	static void PromedioMontosTotales() {
		float monto=0;
		for(int i=0;i<c.getSize();i++) 
			monto+=c.getItem(i).getSaldo();
			
		float promedio=monto/c.getSize();
		System.out.println("El monto promedio de las cuentas es: $"+promedio);
	}
	
	static void cuenMayoraMil() {
		if(!c.isFree()) {
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldo()>10000)
					System.out.println(c.getItem(i));
	    }else
	    	System.out.println("No existen cuentas por el momento ");
	}
	
	static void CuentaMillonaria() {
		if(!c.isFree()) {
		int f=0;
		for(int i=0;i<c.getSize();i++) 
			if(c.getItem(i).getSaldo()>10000)
				f++;
			if(f!=0) {
				f=0;
				for(int i=0;i<c.getSize();i++)
					if(c.getItem(i).getSaldo()>10000)
				System.out.println(c.getItem(i));
				}else
					System.out.println("No hay ninguna cuenta mayor a $10,000.00");
			}else
				System.out.println("no existen cuentas");		
		}
	
	
	static float Saldomax() {
		
		float mayor=c.getItem(0).getSaldo();
		int i=0;
		for(;i<c.getSize();i++)
			if(c.getItem(i).getSaldo()>mayor) {
				mayor=c.getItem(i).getSaldo();
			}
		return mayor;
	}
	
	static void CuentasMayores2() {
		if(!c.isFree()) {
		float mayor= Saldomax();
		for(int i=0;i<c.getSize();i++)
			if(c.getItem(i).getSaldo()==mayor)		
		
		for (;i<c.getSize();i++)
			if(c.getItem(i).getSaldo()==mayor)
				
		System.out.println(c.getItem(i));
		}else
			System.out.println("No hay cuentas");
	}
	
	static float Saldomin() {
		float menor=c.getItem(0).getSaldo();
		for (int i=0;i<c.getSize();i++)
			if(c.getItem(i).getSaldo()<menor)
				menor=c.getItem(i).getSaldo();
		return menor;
	}
	static void CuentasMenores2() {
		if(!c.isFree()) {
			float  men=Saldomin();
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldo()==men)
			for(;i<c.getSize();i++)
				if(c.getItem(i).getSaldo()==men)
			System.out.println(c.getItem(i));
				
		}else
			System.out.println("No se hayaron las cuentas ");
	}
	

}
