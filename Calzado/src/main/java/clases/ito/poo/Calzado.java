/*******************************************************************************
 * 2021, All rights reserved.
 *******************************************************************************/
package clases.ito.poo;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Calzado.
 * 
 * @author USUARIO
 */
public class Calzado implements Comparable<Calzado>{
	public int clave = 0;
	public String material = "";
	public String troquel = "";
	public int cantProdxDia = 0;	
	public String colores = "";

	public int compareTo(Calzado o) {
		return 0;
	}
	
	public int CompareTo(Calzado o) {
		int compare=0;
		if(this.clave<o.getClave())
			compare =-1;
		else if(this.clave>o.getClave())
			compare=1;
		return compare;
	}
	
	
	
	
	
	
	public Calzado(int clave, String material, String troquel, int cantProdxDia, String colores) {
		super();
		this.clave = clave;
		this.material = material;
		this.troquel = troquel;
		this.cantProdxDia = cantProdxDia;
		this.colores = colores;
	}

	
	

	public Calzado() {
		// Start of user code constructor for Calzado)
		super();
		// End of user code
	}

	/**
	 * Description of the method costoxLote.
	 * @param costoxUnida 
	 * @return 
	 */
	public float costoxLote(float costoxUnida) {
		// Start of user code for method costoxLote
		float costoxLote = 0F;
		return costoxLote;
		// End of user code
	}

	// Start of user code (user defined methods for Calzado)

	// End of user code
	/**
	 * Returns clave.
	 * @return clave 
	 */
	public int getClave() {
		return this.clave;
	}

	/**
	 * Sets a value to attribute clave. 
	 * @param newClave 
	 */
	public void setClave(int newClave) {
		this.clave = newClave;
	}

	/**
	 * Returns material.
	 * @return material 
	 */
	public String getMaterial() {
		return this.material;
	}

	/**
	 * Sets a value to attribute material. 
	 * @param newMaterial 
	 */
	public void setMaterial(String newMaterial) {
		this.material = newMaterial;
	}

	/**
	 * Returns troquel.
	 * @return troquel 
	 */
	public String getTroquel() {
		return this.troquel;
	}

	/**
	 * Sets a value to attribute troquel. 
	 * @param newTroquel 
	 */
	public void setTroquel(String newTroquel) {
		this.troquel = newTroquel;
	}

	/**
	 * Returns cantProdxDia.
	 * @return cantProdxDia 
	 */
	public int getCantProdxDia() {
		return this.cantProdxDia;
	}

	/**
	 * Sets a value to attribute cantProdxDia. 
	 * @param newCantProdxDia 
	 */
	public void setCantProdxDia(int newCantProdxDia) {
		this.cantProdxDia = newCantProdxDia;
	}

	/**
	 * Returns colores.
	 * @return colores 
	 */
	public String getColores() {
		return this.colores;
	}

	/**
	 * Sets a value to attribute colores. 
	 * @param newColores 
	 */
	public void setColores(String newColores) {
		this.colores = newColores;
	}

	@Override
	public String toString() {
		return "Calzado [clave=" + clave + ", material=" + material + ", troquel=" + troquel + ", cantProdxDia="
				+ cantProdxDia + ", colores=" + colores + "]";
	}


	}
