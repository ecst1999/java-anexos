package instrospeccion;

public class UsoEmpleado {

	public static void main(String[] args) {
		
		Persona steve = new Persona("Steve");
		
		System.out.println(steve.getNombre());
		
		Empleado karla = new Empleado("Karla", 35000);
		
		System.out.println(karla.getNombre());
		
		System.out.println(karla.getSalario());
		
		// System.out.println(steve.getClass());
		
		// Class cl1 = steve.getClass();
		
		// System.out.println(cl1.getName());
		
		String nombreClase = "instrospeccion.Persona";
		
		Class cl1;
		
		try {
			cl1 = Class.forName(nombreClase);
			
			System.out.println(cl1.getName());
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		nombreClase = "instrospeccion.Empleado";
		
		try {
			cl1 = Class.forName(nombreClase);
			
			System.out.println(cl1.getName());
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
}

class Persona {
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private String nombre;
	
}

class Empleado extends Persona{

	public Empleado(String nombre, double salario) {
		super(nombre);
		
		this.salario = salario;
		
	}
	
	public void setIncentivo(double incentivo) {
		salario += incentivo;				
	}
	
	public double getSalario() {
		return salario;
	}
	
	private double salario;
	
}
