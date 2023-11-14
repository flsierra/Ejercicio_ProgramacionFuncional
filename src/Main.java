import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List <Productos> productos = new ArrayList<>();
        productos.add(new Productos("Arroz", 30.5, "Alimentos", 50));
        productos.add(new Productos("Leche", 20.0, "Alimentos", 0));
	    productos.add(new Productos("Laptop", 1500.0, "Electrónicos", 10));
	    productos.add(new Productos("TV", 800.0, "Electrónicos", 5));
        productos.add(new Productos("Mesa", 120.0, "Hogar", 15));

        //Obtener una lista de todos los productos con stock mayor a 0 y con un precio menor a 50.
        System.out.println("Lista los productos con stock >0 y precio <50 ");
        List<Productos> productosFilter = productos.stream()
                .filter(p -> p.stock > 0 && p.precio <50)
                .collect(Collectors.toList());
        System.out.print(productosFilter);
        System.out.println("");
        //Lista productos segun la categoria
        System.out.println("Lista productos segun la categoria");
        List<String> res = productos
                .stream()
                .filter(e -> e.categoria.equals("Alimentos"))
                .sorted()
                .map(e -> e.name)
                .distinct()
                .collect(Collectors.toList());
        print(res);
        System.out.println("");

        //Obtener el precio total de todos los productos.
        double precioTotalProductos = productos.stream()
                                                .mapToDouble(Productos::getPrecio)
                                                .sum();
        System.out.println("El total de los productos es " +precioTotalProductos);
    }
    public static void print(List productos){
        for (Object e:
             productos) {
            System.out.print(e+ ", ");
        }
    }

}
class Productos implements Comparable<Productos>{
    public String name;
    public double precio;
    public  String categoria;
    public int stock;

    public Productos(String name, double precio, String categoria, int stock) {
        this.name = name;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "name='" + name + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", stock=" + stock +
                '}';
    }

    @Override
    public int compareTo(Productos e) {
        return this.name.compareTo(e.name);
    }
}