package org.conexionmysql;


import controller.ConexionController;
import controller.CursoController;
import controller.SedesController;
import controller.UsuarioController;
import model.RolDAO;
import model.usuariosModel;

import controller.*;

import view.ConsoleView;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLOutput;
import java.time.ZoneId;
import java.util.Scanner;

import static java.time.Clock.system;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        String nombre = "";
        String apellido = "";
        String cedula = "";
        String correo = "";
        int telefono = 0;

        Scanner scanner = new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Prueba MySQL!");
        ConsoleView viewConsole = new ConsoleView();
        ConsoleView consoleView = new ConsoleView();
        CursoController cursoController = new CursoController(consoleView);
        ProductoController productoController = new ProductoController(consoleView);
        PedidoController pedidoController = new PedidoController(consoleView);
        CategoriaController categoriaController = new CategoriaController(consoleView);
        RolController rolController = new RolController(consoleView);


        UsuarioController usuarioController = new UsuarioController(consoleView);
        SedesController sedesController = new SedesController(consoleView);

        String localizacion = "orotina";

        int idsede = 2;
        /**
         * Prueba de inserción de datos a la tabla usuario_RD
         * */
        //  usuarioController.agregarUsuario(apellido,cedula,nombre);
        // usuarioController.borrarUsuario(idusuarios);
        // usuarioController.actualizarUsuario(apellido,cedula,nombre,idusuarios);
        // usuarioController.mostrarUsuario(nombre, apellido, cedula);
        /**
         * Prueba de inserción de datos a la tabla sedes_RD
         * */
        //sedesController.agregarSedes(nombre,localizacion);
        // sedesController.actualizarSede(nombre,localizacion, idsede);
        // sedesController.mostrarSede(nombre,localizacion);
        /**
         * Prueba de inserción de datos a la tabla productos_RD
         * */
        String nombreProducto = "Mouse";
        int cantidad = 25;
        int precio = 5000;
        //productoController.agregarProdcuto(nombreProducto, cantidad, precio);
        //productoController.mostrarProdcuto(nombreProducto, cantidad, precio);
        //productoController.eliminarProducto(2);
        // productoController.modificarProducto(1, "Teclado",25, 10000);


        /**
         * Prueba de inserción de datos a la tabla pedidos_RD
         * */

        String fecha = "";
        int total = 0;
        int idSede = 0;
        int idUsuario = 0;
        //pedidoController.agregarPedido(2, "2024-01-05", 5000, 2);
        //pedidoController.modificarPedido(1, 2, "2024-02-01", 12500, 2);
        // pedidoController.eliminarPedido(2);
        //edidoController.mostrarPedido(idUsuario, fecha, total, idSede);

        /**
         * Prueba de inserción de datos a la tabla categorias_RD
         * */
        int idCategoria = 0;
        String nombreCategoria = "";
        //categoriaController.agregarCategoria("Tarjetas de video");
        //categoriaController.modificarCategoria("Mouses", 1);
        //categoriaController.eliminarCategoria(1);
        //  categoriaController.listarCategorias(nombreCategoria);
        String nombreRol = "";
        String descripcion = "";

        int opcion;
        do {
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
            System.out.println("25. Mostrar Roles");
            System.out.println("***ASOCIACION***");
            System.out.println("26. Registrar Asociacion");
            System.out.println("27. Eliminar Asociacion");
            System.out.println("28. Actualizar Asociacion");
            System.out.println("29. Modificar Asociacion");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");

            // Leer la opción del usuario
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del usuario: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del usuario: ");
                    apellido = scanner.nextLine();
                    System.out.print("Ingrese la cédula del usuario: ");
                    cedula = scanner.nextLine();
                    System.out.println("Ingrese el correo del usuario: ");
                    correo = scanner.nextLine();
                    System.out.println("Ingrese el telefono del usuario");
                    telefono = Integer.parseInt(scanner.nextLine());
                    usuarioController.agregarUsuario(apellido, cedula, nombre,correo,telefono);
                    break;
                case 2:
                    usuarioController.mostrarUsuario(nombre, apellido, cedula,correo,telefono);
                    break;
                case 3:
                    System.out.print("Ingrese el id  del usuario a eliminar: ");
                   idUsuario = Integer.parseInt(scanner.nextLine());
                    usuarioController.borrarUsuario(idUsuario);
                    break;
                case 4:
                    System.out.println("Ingrese el id del usuario que desee actualizar");
                   int idusuarios = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese la cedula a  actualizar: ");
                    cedula = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del usuario: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo apellido del usuario: ");
                    apellido = scanner.nextLine();
                    System.out.println("Ingrese el nuevo telefono del usuario");
                    telefono = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese el nuevo correo del usuario");
                    correo = scanner.nextLine();
                    usuarioController.actualizarUsuario(cedula, nombre, apellido,correo,telefono,idusuarios);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del producto: ");
                    nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese la cantidad del producto: ");
                    cantidad = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el precio del producto: ");
                    precio = Integer.parseInt(scanner.nextLine());
                    productoController.agregarProdcuto(nombreProducto,cantidad, precio);
                    break;
                case 7:
                    productoController.mostrarProdcuto(nombreProducto, cantidad, precio);
                    break;
                case 8:
                    System.out.println("Ingrese el id del producto a eliminar");
                    int idproducto = Integer.parseInt(scanner.nextLine());
                    productoController.eliminarProducto(idproducto);
                    break;
                case 9:
                    System.out.println("Ingrese el id del producto que desee actualizar");
                    idproducto = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese la nueva cantidad del producto: ");
                    cantidad = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el nuevo precio del producto: ");
                    precio = Integer.parseInt(scanner.nextLine());

                    productoController.modificarProducto(idproducto, nombreProducto, cantidad, precio);
                    break;
                case 10:
                    System.out.println("Ingrese el nombre de la categoria a registrar: ");
                    nombreCategoria = scanner.nextLine();
                    categoriaController.agregarCategoria(nombreCategoria);
                    break;
                case 11:
                    categoriaController.listarCategorias(nombreCategoria);
                    break;
                case 12:
                    System.out.println("Ingrese el id de la categoria a eliminar: ");
                    int idcategoria = Integer.parseInt(scanner.nextLine());
                    categoriaController.eliminarCategoria(idcategoria);
                    break;
                case 13:
                    System.out.println("Ingrese el id de la categoria a modificar: ");
                    idcategoria = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese el nuevo nombre del categoria");
                    nombreCategoria = scanner.nextLine();
                    categoriaController.modificarCategoria(nombreCategoria, idcategoria);
                    break;
                case 14:
                    System.out.println("Ingrese el id del usuario del pedido a realizar: ");
                    idUsuario = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese la fecha del pedido: ");
                    fecha = scanner.nextLine();
                    System.out.println("Ingrese el total del pedido realizado: ");
                    total = scanner.nextInt();
                    System.out.println("Ingrese el id de la sede donde se realizo el pedido: ");
                    idSede = scanner.nextInt();
                    pedidoController.agregarPedido(idUsuario, fecha, total, idSede);
                    break;
                case 15:
                    pedidoController.mostrarPedido(idUsuario, fecha, total, idSede);
                    break;
                case 16:
                    System.out.println("Ingrese el id del pedido a eliminar: ");
                    int idpedido = Integer.parseInt(scanner.nextLine());
                    pedidoController.eliminarPedido(idpedido);
                    break;
                case 17:
                    System.out.println("Ingrese el id del pedido a modificar: ");
                    idpedido = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese el nuevo id del usuario asignado al pedido: ");
                    idUsuario = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese la nueva fecha del pedido: ");
                    fecha = scanner.nextLine();
                    System.out.println("Ingrese el nuevo total del pedido: ");
                    total = scanner.nextInt();
                    System.out.println("Ingrese el nuevo id de la sede registrada al pedido: ");
                    idSede = scanner.nextInt();
                    pedidoController.modificarPedido(idpedido, idUsuario, fecha, total, idSede);
                    break;
                case 22:
                    System.out.println("Ingrese el nombre del rol a registrar: ");
                    nombreRol = scanner.nextLine();
                    System.out.println("Ingrese la descripción del rol a crear: ");
                    descripcion = scanner.nextLine();
                    rolController.agregarRol(nombreRol, descripcion);
                    break;
                case 23:
                    System.out.println("Ingrese el nombre del rol a eliminar: ");
                    int idrol = Integer.parseInt(scanner.nextLine());
                    rolController.borarRol(idrol);
                    break;
                case 24:
                    System.out.println("Ingres el id del rol a modificar: ");
                    idrol = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese el nuevo nombre del rol a modificar: ");
                    nombreRol = scanner.nextLine();
                    System.out.println("Ingrese la nueva descripcion del rol a modificar: ");
                    descripcion = scanner.nextLine();
                    rolController.modificarRol(idrol, nombreRol, descripcion);
                    break;
                case 25:
                    rolController.mostrarRol(nombreRol, descripcion);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    }

