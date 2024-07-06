package com.pnegrete.ChallengeLibreria.principal;

import com.pnegrete.ChallengeLibreria.model.Autor;
import com.pnegrete.ChallengeLibreria.model.DatosAutor;
import com.pnegrete.ChallengeLibreria.model.DatosLibro;
import com.pnegrete.ChallengeLibreria.model.Libro;
import com.pnegrete.ChallengeLibreria.repository.AutorRepository;
import com.pnegrete.ChallengeLibreria.repository.LibroRepository;
import com.pnegrete.ChallengeLibreria.service.ConsumoApi;
import com.pnegrete.ChallengeLibreria.service.ConvercionDatos;

import java.util.Scanner;

public class Principal {
    private final Scanner sc = new Scanner(System.in);
    private final ConsumoApi pedido = new ConsumoApi();
    private final AutorRepository repositorioAutor;
    private final LibroRepository repositorioLibro;
    private final ConvercionDatos conversor = new ConvercionDatos();
    private static final String ADDRESS = "https://gutendex.com/books?search=";

    public Principal(AutorRepository repositorioAutor, LibroRepository repositorioLibro) {
        this.repositorioAutor = repositorioAutor;
        this.repositorioLibro = repositorioLibro;
    }

    public void principal() {
        imprimirEncabezado();

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    buscarNuevoLibro();
                    break;
                case 2:
                    buscarLibrosRegistrados();
                    break;
                case 3:
                    buscarAutoresRegistrados();
                    break;
                case 4:
                    buscarAutoresVivosPorAno();
                    break;
                case 5:
                    buscarLibrosPorIdioma();
                    break;
                case 6:
                    buscarTop10();
                    break;
                case 7:
                    buscarAutorPorNombre();
                    break;
                case 8:
                    cantidadDescargasPorAutor();
                    break;
                case 0:
                    System.out.println("S A L I R...");
                    break;
                default:
                    System.out.println("\n\n========== Opción inválida (selecciona un número del 0 al 8) =============\n\n");
            }
        } while (opcion != 0);
    }

    private void imprimirEncabezado() {
        String headerBase = "\033[34m\n" +
                "                =================================================================================\n" +
                "                                \n" +
                "                        ██╗     ██╗██████╗ ██████╗ ███████╗██████╗ ██╗ █████╗ \n" +
                "                        ██║     ██║██╔══██╗██╔══██╗██╔════╝██╔══██╗██║██╔══██╗\n" +
                "                        ██║     ██║██████╔╝██████╔╝█████╗  ██████╔╝██║███████║\n" +
                "                        ██║     ██║██╔══██╗██╔══██╗██╔══╝  ██╔══██╗██║██╔══██║\n" +
                "                        ███████╗██║██████╔╝██║  ██║███████╗██║  ██║██║██║  ██║\n" +
                "                        ╚══════╝╚═╝╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═╝\n" +
                "                         █████╗ ██╗     ██╗   ██╗██████╗  █████╗              \n" +
                "                        ██╔══██╗██║     ██║   ██║██╔══██╗██╔══██╗             \n" +
                "                        ███████║██║     ██║   ██║██████╔╝███████║             \n" +
                "                        ██╔══██║██║     ██║   ██║██╔══██╗██╔══██║             \n" +
                "                        ██║  ██║███████╗╚██████╔╝██║  ██║██║  ██║             \n" +
                "                        ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝             \n" +
                "                                                                             \n" +
                "                =================================================================================\n" +
                "\033[0m";
        System.out.println(headerBase);
    }

    private void mostrarMenu() {
        String menu = """
                        
                =========================== M E N U =============================================
                1 - BUSCAR LIBRO POR TÍTULO
                2 - LISTA DE LIBROS REGISTRADOS
                3 - LISTA DE AUTORES REGISTRADOS
                4 - LISTA DE AUTORES VIVOS EN DETERMINADO AÑO
                5 - LISTA DE LIBROS EN DETERMINADO IDIOMA
                6 - TOP 10 LIBROS
                7 - BUSCAR AUTORES POR NOMBRE
                8 - CANTIDAD DE DESCARGAS POR AUTOR
                                
                0 - S A I R
                =================================================================================
                """;
        System.out.println(menu);
    }

    private void buscarNuevoLibro() {
        System.out.println("\n¿Qué libro desea buscar?");
        String buscaUsuario = sc.nextLine();
        String datos = pedido.consumo(ADDRESS + buscaUsuario.replace(" ", "%20"));
        salvarEnDB(datos);
    }

    private void salvarEnDB(String datos) {
        try {
            Libro libro = new Libro(conversor.getData(datos, DatosLibro.class));
            Autor autor = new Autor(conversor.getData(datos, DatosAutor.class));
            Autor autorDB;

            if (!repositorioAutor.existsByNombre(autor.getNombre())) {
                repositorioAutor.save(autor);
                autorDB = autor;
            } else {
                autorDB = repositorioAutor.findByNombre(autor.getNombre());
            }

            if (!repositorioLibro.existsByNombre(libro.getNombre())) {
                libro.setAutor(autorDB);
                repositorioLibro.save(libro);
            } else {
                System.out.println("\nEl libro ya existe en la Base de Datos.\n");
            }

            System.out.println(libro);

        } catch (NullPointerException e) {
            System.out.println("\n\n============= Libro no encontrado ==============\n\n");
        }
    }

    private void buscarLibrosRegistrados() {
        var librosRegistrados = repositorioLibro.findAll();
        if (!librosRegistrados.isEmpty()) {
            System.out.println("\nLibros registrados en la Base de Datos:");
            librosRegistrados.forEach(System.out::println);
        } else {
            System.out.println("\n¡No se encontraron libros en la Base de Datos!\n");
        }
    }

    private void buscarAutoresRegistrados() {
        var autoresRegistrados = repositorioAutor.findAll();
        if (!autoresRegistrados.isEmpty()) {
            System.out.println("\nAutores registrados en la Base de Datos:");
            autoresRegistrados.forEach(System.out::println);
        } else {
            System.out.println("\n¡No se encontraron autores en la Base de Datos!\n");
        }
    }

    private void buscarAutoresVivosPorAno() {
        System.out.println("\n¿Qué año desea buscar?");
        int anoSeleccionado = sc.nextInt();
        sc.nextLine();

        var autoresVivos = repositorioAutor.buscarPorfechaDeFallecimiento(anoSeleccionado);
        if (!autoresVivos.isEmpty()) {
            System.out.println("\nAutores vivos en el año " + anoSeleccionado + ":");
            autoresVivos.forEach(System.out::println);
        } else {
            System.out.println("\n¡No se encontraron autores vivos en el año " + anoSeleccionado + "!\n");
        }
    }

    private void buscarLibrosPorIdioma() {
        var idiomasRegistrados = repositorioLibro.bucaridiomas();
        if (!idiomasRegistrados.isEmpty()) {
            System.out.println("\nIdiomas registrados en la Base de Datos:");
            idiomasRegistrados.forEach(System.out::println);

            System.out.println("\nSeleccione uno de los idiomas registrados en la Base de Datos:");
            String idiomaSeleccionado = sc.nextLine().trim();

            var librosEnIdioma = repositorioLibro.buscarPorIdioma(idiomaSeleccionado);
            if (!librosEnIdioma.isEmpty()) {
                System.out.println("\nLibros en el idioma '" + idiomaSeleccionado + "':");
                librosEnIdioma.forEach(System.out::println);
            } else {
                System.out.println("\nNo se encontraron libros en el idioma '" + idiomaSeleccionado + "'.\n");
            }
        } else {
            System.out.println("\n¡No hay idiomas registrados en la Base de Datos!\n");
        }
    }

    private void buscarTop10() {
        var top10 = repositorioLibro.findTop10ByOrderByCantidadDeDescargas();
        if (!top10.isEmpty()) {
            System.out.println("\nTop 10 Mejores Libros:");
            top10.forEach(System.out::println);
        } else {
            System.out.println("\n¡No se encontraron libros para mostrar en el Top 10!\n");
        }
    }

    private void buscarAutorPorNombre() {
        System.out.println("\n¿Cuál es el nombre del autor?");
        String nombreAutor = sc.nextLine();

        var autorEncontrado = repositorioAutor.encontrarPorNombre(nombreAutor);
        if (!autorEncontrado.isEmpty()) {
            System.out.println("\nAutor encontrado:");
            autorEncontrado.forEach(System.out::println);
        } else {
            System.out.println("\n¡Autor no encontrado!\n");
        }
    }

    private void cantidadDescargasPorAutor() {
        System.out.println("\n¿De cuál autor desea conocer la cantidad de descargas?");
        String nombreAutor = sc.nextLine();

        var librosDelAutor = repositorioLibro.encontrarLibrosPorAutor(nombreAutor);
        if (!librosDelAutor.isEmpty()) {
            double promedioDescargas = librosDelAutor.stream()
                    .mapToDouble(Libro::getCantidadDeDescargas)
                    .average()
                    .orElse(0);

            System.out.println("\nCantidad promedio de descargas para '" + nombreAutor + "': " + promedioDescargas + "\n");
        } else {
            System.out.println("\nNo se encontraron libros para el autor '" + nombreAutor + "'.\n");
        }
    }
}
