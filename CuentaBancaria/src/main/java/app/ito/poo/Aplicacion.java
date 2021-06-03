package app.ito.poo;
import clases.ito.poo.CuentasBancarias;
import clases.ito.poo.CuentaBancaria;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Date;
public class Aplicacion {
	static CuentasBancarias c;
	

	
	static void run(){
		c= new CuentasBancarias();
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
															System.out.println("\n\nEl monto total de todas las cuentas es: $"+c.MontosTotales());
															break;
															
															case 2:
																System.out.println("\n\nEl promedio de montos es de: $"+c.PromedioMontosTotales());
																break;
																
																case 3:
																	System.out.println("\n\nCuentas con un monto mayor a $10,000.00: "+c.CuentaMillonaria());
																	break;
																	
																	case 4:
																		System.out.println("\n\nCuenta con saldo maximo: "+c.Saldomax());
																		break;
																		
																		case 5:
																			System.out.println("\n\nCuenta con el saldo minimo"+c.Saldomin());
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
	
	
	
	/*
	
	c.addItem(new CuentaBancaria(66,"Elias rojas",4000,LocalDate.of(2021, 4, 24)));
	c.addItem(new CuentaBancaria(34,"Mariana Rodriguez",46000,LocalDate.of(2021, 5, 30)));
	c.addItem(new CuentaBancaria(32,"Sofia Morales",70000,LocalDate.of(2021, 12, 2)));
	c.addItem(new CuentaBancaria(31,"Karolina Lopez",18000,LocalDate.of(2021, 3, 12)));
	c.addItem(new CuentaBancaria(29,"Jocelyn Flores",3000,LocalDate.of(2021, 2, 1)));
	System.out.println(c.isFree());
	for(int i=0;i<c.getSize();i++)
		System.out.println(c.getItem(i));


	System.out.print("\nchequeo de deposito:"+ c.Deposito(3, 5));//cantidad a depositar
	System.out.print("\nChequeo de retiro"+c.Retiro(3, 90000));
	
	c.EliminarCuenta(3);
	System.out.println("\n\n\n\n");
		for(int i=0;i<c.getSize();i++)
		System.out.println(c.getItem(i));
	
		
		System.out.println("EL MONTO TOTAL DE LAS CUENTAS ES DE :$"+c.MontosTotales());
		System.out.println("EL MONTO PROMEDIO DE LAS CUENTAS ES DE: $"+c.PromedioMontosTotales());
		System.out.println("CUENTAS CON UN MONTO MAYOR A $10,000.00:\n"+c.CuentaMillonaria());
		System.out.println("saldo maximo: "+c.Saldomax());
		System.out.println("saldo minimo: "+c.Saldomin()); */
	}
	

}
