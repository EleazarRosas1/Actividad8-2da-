package app.ito.poo;
import clases.ito.poo.*;

public class Aplicacion {
	static Calzados c;
	static void run() {
		c=new Calzados();
		c.addCalzado(new Calzado(465, "Piel", "5cm", 200, " Azul Marino"));
		c.addCalzado(new Calzado(46, "Piel", "2cm", 700, " Cafe"));
		c.addCalzado(new Calzado(65, "Piel", "3cm", 500, " Negro"));
		c.addCalzado(new Calzado(481, "Piel", "5cm",300, " Azul Marino"));
		c.addCalzado(new Calzado(324, "Piel", "6cm", 300, " Negro"));
		System.out.println(c.isFree());
		
		for(int i=0;i<c.getSize();i++)
			System.out.println(c.getCalzado(i));
	}
}
