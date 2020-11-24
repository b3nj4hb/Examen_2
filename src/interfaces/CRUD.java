package interfaces;

import java.util.List;
import modelo.Biblioteca;

public interface CRUD {
     public List listarbiblioteca();
    public Biblioteca buscarbiblioteca(int biblioteca);
    public boolean agregarbiblioteca(Biblioteca biblioteca);
    public boolean editarbiblioteca(Biblioteca biblioteca);
    public boolean eliminarbiblioteca(int biblioteca);
}
