package sistemabiblioteca;

import java.util.ArrayList;

public class Libro {
    private String isbn,titulo,autor,genero;
    private int anioPublicacion;
    private boolean disponible;
    
    private ArrayList<Libro> libros = new ArrayList<>();
    
    public Libro(){
        
    }
    public Libro(String isbn, String titulo, String autor, String genero, int anioPublicacion, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    
    
    
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn 
                + ", titulo=" + titulo 
                + ", autor=" + autor 
                + ", genero=" + genero 
                + ", anioPublicacion=" + anioPublicacion 
                + ", disponible=" + disponible + '}';
    }
    
    
    public void agregarLibro(Libro libro){
        libros.add(libro);
    }
    
    public ArrayList<Libro> listarLibros(){
        return libros;
    }
    
     public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null;
    }  
    
    public boolean actualizarLibro(String isbn, Libro datosActualizados) {
    for (Libro libro : libros) {
        if (libro.getIsbn().equalsIgnoreCase(isbn)) {
            libro.setTitulo(datosActualizados.getTitulo());
            libro.setAutor(datosActualizados.getAutor());
            libro.setGenero(datosActualizados.getGenero());
            libro.setAnioPublicacion(datosActualizados.getAnioPublicacion());
            libro.setDisponible(datosActualizados.isDisponible());
            return true;
        }
    }
    return false;
    } 
    
    public boolean eliminarLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                libros.remove(libro);
                return true;
            }
        }
        return false;
    } 
    
}
