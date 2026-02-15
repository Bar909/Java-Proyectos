package Modelos;
public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;
    
    public Libro(String titulo, String autor,String isbn){
    this.titulo = titulo;
    this.autor = autor;
    this.isbn = isbn;
    this.disponible = false;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public String getIsbn(){
        return isbn;
    }
    public boolean isDisponible(){
        return disponible;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public void setDisponible(boolean disponible){
    this.disponible = disponible;
    }
}

