package interfaces.ito.poo;

public interface Arreglo<T> {
	public boolean addCalzado(T cal);
	public boolean existeCalzado(T cal);
	public T getCalzado(int pos);
	public int getSize();
	public boolean delete(T cal);
	public boolean isFree();
	public boolean isFull();
	
}
