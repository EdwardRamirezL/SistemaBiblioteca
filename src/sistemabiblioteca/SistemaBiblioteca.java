package sistemabiblioteca;

import java.util.Scanner;

public class SistemaBiblioteca {

    public static void main(String[] args) {
      
        Libro biblioteca = new Libro();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== SISTEMA BIBLIOTECARIO =====");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro por ISBN");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {

                case 1:
                    System.out.println("\n--- AGREGAR LIBRO ---");

                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Genero: ");
                    String genero = sc.nextLine();

                    System.out.print("Anio de publicacion: ");
                    int anio = sc.nextInt();
                    sc.nextLine();

                    Libro nuevo = new Libro(isbn, titulo, autor, genero, anio, true);
                    biblioteca.agregarLibro(nuevo);

                    System.out.println("Libro agregado correctamente.");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE LIBROS ---");

                    for (Libro libro : biblioteca.listarLibros()) {
                        System.out.println(libro);
                    }
                    break;

                case 3:
                    System.out.println("\n--- BUSCAR LIBRO ---");

                    System.out.print("Ingrese ISBN: ");
                    String isbnBuscar = sc.nextLine();

                    Libro encontrado = biblioteca.buscarPorIsbn(isbnBuscar);

                    if (encontrado != null) {
                        System.out.println("Libro encontrado:");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- ACTUALIZAR LIBRO ---");

                    System.out.print("Ingrese ISBN del libro a actualizar: ");
                    String isbnActualizar = sc.nextLine();

                    System.out.print("Nuevo titulo: ");
                    String nuevoTitulo = sc.nextLine();

                    System.out.print("Nuevo autor: ");
                    String nuevoAutor = sc.nextLine();

                    System.out.print("Nuevo genero: ");
                    String nuevoGenero = sc.nextLine();

                    System.out.print("Nuevo anio: ");
                    int nuevoAnio = sc.nextInt();
                    sc.nextLine();

                    Libro actualizado = new Libro(isbnActualizar, nuevoTitulo, nuevoAutor, nuevoGenero, nuevoAnio, true);

                    if (biblioteca.actualizarLibro(isbnActualizar, actualizado)) {
                        System.out.println("Libro actualizado correctamente.");
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- ELIMINAR LIBRO ---");

                    System.out.print("Ingrese ISBN: ");
                    String isbnEliminar = sc.nextLine();

                    if (biblioteca.eliminarLibro(isbnEliminar)) {
                        System.out.println("Libro eliminado correctamente.");
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
