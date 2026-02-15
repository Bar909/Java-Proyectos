package Presentacion;
import java.util.Scanner;
import Business.LibroService;
import Business.PedidoService;
import Business.ProductoService;
import Business.UsuarioService;
import Modelos.Producto;
import Repository.ProductoRepository;

public class UI{
    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioService usuarioService = new UsuarioService();
    private static LibroService libroService = new LibroService(usuarioService);
    private static ProductoRepository productoRepository = new ProductoRepository();
    private static ProductoService productoService = new ProductoService(productoRepository);
    private static PedidoService pedidoService = new PedidoService();

    public static void main(String[] args){
        int opcion = -1;

        do{
            mostrarMenu();
            opcion = -1;

            while (opcion == -1){
                System.out.println("Selecciona una opción: ");
                if(scanner.hasNextInt()){
                    opcion = scanner.nextInt();
                    scanner.nextLine(); 
       
                }else {
                    System.out.println("Número no válido, intentelo de nuevo");
                    scanner.nextLine();
                }
            } 

            switch(opcion){
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    editarLibro();
                    break;
                case 3:
                    eliminarLibro();
                    break;
                case 4:
                    buscarLibros();
                    break;
                case 5:
                    registrarUsuario();
                    break;
                case 6:
                    prestarLibro();
                    break;
                case 7:
                    devolverLibro();
                    break;
                case 8:
                    iniciarPedido();
                    break;
                case 9:
                    agregarProductoPedido();
                    break;
                case 10:
                    mostrarPedido();
                    break;
                case 11:
                    realizarCompra();
                    break;

                case 0:
                    System.out.println("Saliendo de la aplicación.");
                default:
                    System.out.println("Opción invalida, vuelvalo a intentar.");
            }
        } while(opcion != 0);
    }
    private static void mostrarMenu(){
        System.out.println("\n--- MENÚ DE BIBLIOTECA ---");
        System.out.println("1. Agregar libro");
        System.out.println("2. Editar libro");
        System.out.println("3. Eliminar libro");
        System.out.println("4. Buscar libros");
        System.out.println("5. Registrar usuario");
        System.out.println("6. Registrar préstamo");
        System.out.println("7. Registrar devolución");
        System.out.println("8. Iniciar pedido");
        System.out.println("9. Agregar productos al pedido");
        System.out.println("10. Ver pedido");
        System.out.println("10. Realizar compra");
        System.out.println("0. Salir");
    }
    private static void agregarLibro(){
        System.out.println("Título: ");
        String titulo = scanner.nextLine();
        System.out.println("Autor: ");
        String autor = scanner.nextLine();
        System.out.println("ISBN: ");
        String isbn = scanner.nextLine();
        libroService.agregarLibro(titulo, autor, isbn);
    }
    private static void editarLibro(){
        System.out.print("ISBN del libro a editar: ");
        String isbn = scanner.nextLine();
        System.out.print("Nuevo título: ");
        String nuevoTitulo = scanner.nextLine();
        System.out.print("Nuevo autor: ");
        String nuevoAutor = scanner.nextLine();
        libroService.editarLibro(isbn, nuevoTitulo, nuevoAutor);
    }
    private static void eliminarLibro(){
        System.out.print("ISBN del libro a eliminar: ");
        String isbn = scanner.nextLine();
        libroService.eliminarLibro(isbn);
    }
    private static void buscarLibros(){
        System.out.print("Buscar por Título(1), Autor(2), ISBN(3).Introduzca el número.");
        int opciones = -1;
        while(opciones == -1){
            if(scanner.hasNextInt()){
                opciones = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Número no válido.");
                scanner.nextLine();
            }
        }
        System.out.println("Introduzca el título,autor o isbn: ");
        String termino = scanner.nextLine();
        libroService.buscarLibros(opciones, termino);
    }
    private static void registrarUsuario(){
        System.out.println("Nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.println("ID del usuario: ");
        String id = scanner.nextLine();
        usuarioService.registrarUsuario(nombre, id);
    }
    private static void prestarLibro(){
        System.out.print("ID del usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();
        libroService.prestarLibro(idUsuario, isbn);
    }
    private static void devolverLibro() {
        System.out.print("ISBN del libro a devolver: ");
        String isbn = scanner.nextLine();

        libroService.devolverLibro(isbn);
    }
    private static void iniciarPedido() {
        System.out.print("ID del usuario: ");
        String idUsuario = scanner.nextLine();
        pedidoService.iniciarPedido(idUsuario);
    }
    private static void agregarProductoPedido() {
        System.out.print("ISBN del producto: ");
        String isbn = scanner.nextLine();
        Producto producto = productoService.buscarProductoPorIsbn(isbn);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
        } else {
            pedidoService.agregarProductoPedido(producto);
        }
    }

    private static void mostrarPedido() {
        pedidoService.mostrarPedido();
    }
    private static void realizarCompra() {
        pedidoService.realizarCompra();
    }
}