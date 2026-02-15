package Modelos;

public class Producto {
    private String isbn;
    private String titulo;
    private String autor;
    private double precio;

    public Producto(String isbn, String titulo, String autor, double precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public double getPrecio() { return precio; }

    public void setPrecio(double precio) { this.precio = precio; }
}