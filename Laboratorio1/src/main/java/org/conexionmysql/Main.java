package org.conexionmysql;

import controller.*;
import model.PedidoModel;
import view.ConsoleView;

import javax.xml.transform.Source;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Prueba MySQL!");

        ConsoleView consoleView = new ConsoleView();
        CursoController cursoController = new CursoController(consoleView);
        ProductoController productoController = new ProductoController(consoleView);
        PedidoController pedidoController = new PedidoController(consoleView);
        CategoriaController categoriaController = new CategoriaController(consoleView);
        AsociacionController asociacionController = new AsociacionController(consoleView);
        UsuarioController usuarioController = new UsuarioController(consoleView);
        SedesController sedesController = new SedesController(consoleView);
        RolController rolController = new RolController(consoleView);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    registrarUsuario(scanner, usuarioController);
                    break;
                case 2:
                    mostrarUsuario(scanner, usuarioController);
                    break;
                case 3:
                    eliminarUsuario(scanner, usuarioController);
                    break;
                case 4:
                    actualizarUsuario(scanner, usuarioController);
                    break;
                case 6:
                    agregarProducto(scanner, productoController);
                    break;
                case 7:
                    mostrarProductos(productoController);
                    break;
                case 8:
                    eliminarProductos(scanner, productoController);
                    break;
                case 9:
                    modificarProductos(scanner, productoController);
                    break;
                case 10:
                    agregarCategoria(scanner, categoriaController);
                    break;
                case 11:
                    mostrarCategoria(categoriaController);
                    break;
                case 12:
                    eliminarCategoria(scanner, categoriaController);
                    break;
                case 13:
                    modificarCategoria(scanner , categoriaController);
                    break;
                case 14:
                    agregarPedido(scanner, pedidoController);
                    break;
                case 15:
                    mostrarPedidos(pedidoController);
                    break;
                case 16:
                    eliminarPedido(scanner, pedidoController);
                    break;
                case 17:
                    modificarPedidos(scanner, pedidoController);
                    break;
                case 18:
                    agregarSedes(scanner, sedesController);
                    break;
                case 19:
                    mostrarSedes(scanner, sedesController);
                    break;
                case 20:
                    eliminarSedes(scanner,sedesController);
                    break;
                case 21:
                    modificarSede(scanner,sedesController);
                    break;
                case 22:
                    registrarRol(scanner,rolController);
                    break;
                case 23:
                    eliminarRol(scanner,rolController);
                    break;
                case 24:
                    modificarRol(scanner,rolController);
                    break;
                case 26:
                    registrarAsociacion(scanner, asociacionController);
                    break;
                case 27:
                    eliminarAsociacion(scanner, asociacionController);
                    break;
                case 28:
                    actualizarAsociacion(scanner, asociacionController);
                    break;
                case 29:
                    mostrarAsociacion(scanner, asociacionController);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("TIENDA ELECTRONICA");
        System.out.println("***USUARIOS***");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Mostrar Usuario");
        System.out.println("3. Eliminar Usuario");
        System.out.println("4. Actualizar Usuario");
        System.out.println("***PRODUCTOS***");
        System.out.println("6. Registrar Producto");
        System.out.println("7. Mostrar Producto");
        System.out.println("8. Eliminar Producto");
        System.out.println("9. Actualizar Producto");
        System.out.println("***CATEGORIAS***");
        System.out.println("10. Registrar Categoria");
        System.out.println("11. Mostrar Categoria");
        System.out.println("12. Eliminar Categoria");
        System.out.println("13. Actualizar Categoria");
        System.out.println("***PEDIDOS***");
        System.out.println("14. Registrar Pedido");
        System.out.println("15. Mostrar Pedido");
        System.out.println("16. Eliminar Pedido");
        System.out.println("17. Actualizar Pedido");
        System.out.println("***SEDES***");
        System.out.println("18. Registrar Sede");
        System.out.println("19. Mostrar Sede");
        System.out.println("20. Eliminar Sede");
        System.out.println("21. Modificar Sede");
        System.out.println("***ROL***");
        System.out.println("22. Registrar Rol");
        System.out.println("23. Eliminar Rol");
        System.out.println("24. Actualizar Rol");
        System.out.println("25. Modificar Rol");
        System.out.println("***ASOCIACION***");
        System.out.println("26. Registrar Asociacion");
        System.out.println("27. Eliminar Asociacion");
        System.out.println("28. Actualizar Asociacion");
        System.out.println("29. Mostrar Asociacion");
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
    }

    private static void registrarUsuario(Scanner scanner, UsuarioController usuarioController) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del usuario: ");
        System.out.println("Ingrese la contrasenna del usuario ");
        String contrasenna = scanner.nextLine();
        String apellido = scanner.nextLine();
        System.out.print("Ingrese la cédula del usuario: ");
        String cedula = scanner.nextLine();
        System.out.println("Ingrese el correo del usuario: ");
        String correo = scanner.nextLine();
        System.out.println("Ingrese el telefono del usuario");
        int telefono = Integer.parseInt(scanner.nextLine());
        usuarioController.agregarUsuario(apellido, cedula, nombre, correo, telefono,contrasenna);
    }

    private static void mostrarUsuario(Scanner scanner, UsuarioController usuarioController) {

        String nombre = "";
        String apellido = "";
        String cedula = "";
        String correo = "";
        int telefono = 0;
        String contrasenna = "";
        usuarioController.mostrarUsuario(nombre, apellido, cedula, correo, telefono, contrasenna);
    }

    private static void eliminarUsuario(Scanner scanner, UsuarioController usuarioController) {
        System.out.print("Ingrese el id del usuario a eliminar: ");
        int idUsuario = Integer.parseInt(scanner.nextLine());
        usuarioController.borrarUsuario(idUsuario);
    }

    private static void actualizarUsuario(Scanner scanner, UsuarioController usuarioController) {
        System.out.println("Ingrese el id del usuario que desee actualizar");
        int idusuarios = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese la cedula a actualizar: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo apellido del usuario: ");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese el nuevo telefono del usuario");
        int telefono = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nuevo correo del usuario");
        String correo = scanner.nextLine();
        System.out.println("Ingrese la nueva contraseña del usuario");
        String contrasenna = scanner.nextLine();
        usuarioController.actualizarUsuario(cedula, nombre, apellido, correo, telefono, idusuarios,contrasenna);
    }

    private static void registrarAsociacion(Scanner scanner, AsociacionController asociacionController) {
        System.out.println("Ingrese el id del usuario");
        int idUsuarioAS = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el id del Rol");
        int idRol = Integer.parseInt(scanner.nextLine());
        asociacionController.agregarAsociacion(idUsuarioAS, idRol);
    }

    private static void eliminarAsociacion(Scanner scanner, AsociacionController asociacionController) {
        System.out.println("Ingrese el id de la asociacion que desee eliminar");
        int idasociacion = Integer.parseInt(scanner.nextLine());
        asociacionController.borrarAsociacion(idasociacion);
    }

    private static void actualizarAsociacion(Scanner scanner, AsociacionController asociacionController) {
        System.out.println("Ingrese el id de la asociacion que desee actualizar");
        int idasociacionAS = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nuevo id del usuario");
        int idUsuarioASB = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nuevo id del Rol");
        int idRolAS = Integer.parseInt(scanner.nextLine());
        asociacionController.actualizarAsociacion(idUsuarioASB, idRolAS, idasociacionAS);
    }

    private static void mostrarAsociacion(Scanner scanner, AsociacionController asociacionController) {
        System.out.println("Ingrese el id del usuario");
        int idUsuarioMS = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el id del Rol");
        int idRolMS = Integer.parseInt(scanner.nextLine());
        asociacionController.mostrarAsociacion(idUsuarioMS, idRolMS);
    }
    private static void registrarRol(Scanner scanner, RolController rolController)
    {
        System.out.println("Ingrese el nombre del Rol");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la descripcion del Rol");
        String descripcion = scanner.nextLine();
        rolController.agregarRol(nombre,descripcion);
    }
    private static void eliminarRol(Scanner scanner, RolController rolController)
    {
        System.out.println("Ingrese el id del Rol que desee eliminar");
        int idRol = Integer.parseInt(scanner.nextLine());
        rolController.borarRol(idRol);
    }
    private static void modificarRol(Scanner scanner, RolController rolController)
    {
        System.out.println("Ingrese el id del rol que desee modificar");
        int idRol = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nuevo rol ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la nueva descripcion del Rol");
        String descripcion = scanner.nextLine();
        rolController.modificarRol(idRol,nombre,descripcion);
    }
    public static void agregarProducto (Scanner scanner, ProductoController productoController){
        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el precio del producto: ");
        int precio = Integer.parseInt(scanner.nextLine());
        productoController.agregarProdcuto(nombreProducto,cantidad, precio);
    }
    public static void mostrarProductos (ProductoController productoController){
        String nombreProducto = "";
        int cantidad = 0;
        int precio = 0;
        productoController.mostrarProdcuto(nombreProducto, cantidad, precio);

    }
    public static void eliminarProductos(Scanner scanner , ProductoController productoController){
        System.out.println("Ingrese el id del producto a eliminar");
        int idproducto = Integer.parseInt(scanner.nextLine());
        productoController.eliminarProducto(idproducto);

    }
    public static void modificarProductos(Scanner scanner, ProductoController productoController){
        System.out.println("Ingrese el id del producto que desee actualizar");
        int idproducto = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingrese la nueva cantidad del producto: ");
        int cantidad = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el nuevo precio del producto: ");
        int precio = Integer.parseInt(scanner.nextLine());

        productoController.modificarProducto(idproducto, nombreProducto, cantidad, precio);
    }

    public static  void agregarCategoria(Scanner scanner, CategoriaController categoriaController){
        System.out.println("Ingrese el nombre de la categoria a registrar: ");
        String nombreCategoria = scanner.nextLine();
        categoriaController.agregarCategoria(nombreCategoria);
    }

    public static void mostrarCategoria(CategoriaController categoriaController){
        String nombreCategoria = "";
        categoriaController.listarCategorias(nombreCategoria);
    }
    public static void eliminarCategoria(Scanner scanner, CategoriaController categoriaController){
        System.out.println("Ingrese el id de la categoria a eliminar: ");
        int idcategoria = Integer.parseInt(scanner.nextLine());
        categoriaController.eliminarCategoria(idcategoria);
    }
    public static void modificarCategoria(Scanner scanner, CategoriaController categoriaController){
        System.out.println("Ingrese el id de la categoria a modificar: ");
       int idcategoria = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nuevo nombre del categoria");
        String nombreCategoria = scanner.nextLine();
        categoriaController.modificarCategoria(nombreCategoria, idcategoria);
    }

    public static void agregarPedido(Scanner scanner, PedidoController pedidoController){
        System.out.println("Ingrese el id del usuario del pedido a realizar: ");
        int idUsuario = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese la fecha del pedido: ");
        String fecha = scanner.nextLine();
        System.out.println("Ingrese el total del pedido realizado: ");
        int total = scanner.nextInt();
        System.out.println("Ingrese el id de la sede donde se realizo el pedido: ");
        int idSede = scanner.nextInt();
        pedidoController.agregarPedido(idUsuario, fecha, total, idSede);
    }
    public static void mostrarPedidos(PedidoController pedidoController){
        int idUsuario = 0;
        String fecha = "";
        int total = 0;
        int idSede = 0;
        pedidoController.mostrarPedido(idUsuario, fecha, total, idSede);
    }
    public static void eliminarPedido(Scanner scanner, PedidoController pedidoController){
        System.out.println("Ingrese el id del pedido a eliminar: ");
        int idpedido = Integer.parseInt(scanner.nextLine());
        pedidoController.eliminarPedido(idpedido);
    }
    public static void modificarPedidos(Scanner scanner, PedidoController pedidoController){
        System.out.println("Ingrese el id del pedido a modificar: ");
        int idpedido = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nuevo id del usuario asignado al pedido: ");
        int idUsuario = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese la nueva fecha del pedido: ");
        String fecha = scanner.nextLine();
        System.out.println("Ingrese el nuevo total del pedido: ");
        int total = scanner.nextInt();
        System.out.println("Ingrese el nuevo id de la sede registrada al pedido: ");
        int idSede = scanner.nextInt();
        pedidoController.modificarPedido(idpedido, idUsuario, fecha, total, idSede);
    }

    public static void agregarSedes(Scanner scanner, SedesController sedesController){
        System.out.println("Nombre de la sede: ");
        String nombre = scanner.nextLine();
        System.out.println("Localizacion de la sede: ");
        String localizacion = scanner.nextLine();
        sedesController.agregarSedes(nombre,localizacion);
    }
    public static void eliminarSedes(Scanner scanner, SedesController sedesController)
    {
        System.out.println("Digite el id de la sede que desee eliminar: ");
        int idsede = Integer.parseInt(scanner.nextLine());
        sedesController.borrarSedes(idsede);
    }
    public static void mostrarSedes(Scanner scanner, SedesController sedesController){
        String nombre = "";
        String localizacion = "";
        sedesController.mostrarSede(nombre,localizacion);
    }
    public static void modificarSede(Scanner scanner, SedesController sedesController){
        System.out.println("Digite el id de la sede que desee eliminar");
        int idsede = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite el nuevo nombre de la sede ");
        String nombre = scanner.nextLine();
        System.out.println("Digite la nueva localizacion de la sede ");
        String localizacion = scanner.nextLine();
        sedesController.actualizarSede(nombre,localizacion,idsede);
    }


}
