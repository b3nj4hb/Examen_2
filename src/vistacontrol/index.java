package vistacontrol;
import modeloDAO.bibliotecaDAO;
import java.util.List;
import modelo.Biblioteca;
import utils.leer;

public class index {
 
    public static void menu()
    {
        System.out.println("Menu");
        System.out.println("1.Listar");
        System.out.println("2.Eliminar");
        System.out.println("3.Editar");
        System.out.println("4.Agregar");
        System.out.println("5.Salir");
        System.out.print("Escoja opción [1-5]: ");
    }
    public static void salir()
    {
        System.out.println("Gracias....!!!");}
     public static void listarbiblioteca()
    {
        bibliotecaDAO bibliotecaDAO = new bibliotecaDAO();
        List<Biblioteca>bibliotecas = bibliotecaDAO.listarbiblioteca();
        System.out.println("Listado de bibliotecas");
        System.out.println("Id"+"\t"+"Biblioteca"+"\t"+"\t\t"+"codigo"+"\t\t"+"Direccion"+"\t"+"Telefono"+"  \t"+"Estado");
        for (Biblioteca biblioteca : bibliotecas) {
            System.out.println("____________________________________________________________________________________________________________________");
            System.out.println(biblioteca.getIdbiblioteca()+ "\t"+
                               darFormato(biblioteca.getNombre(),30).toUpperCase()+ "\t"+
                               darFormato(biblioteca.getCodigo(),8).toUpperCase()+"\t"+
                               darFormato(biblioteca.getDireccion(),15).toUpperCase()+"\t"+
                               darFormato(biblioteca.getTelefono(),9).toUpperCase()+"\t  "+
                               biblioteca.getEstado().toUpperCase()                          
                    );
        }
    }
     public static void eliminarbiblioteca()
    {
        listarbiblioteca();
        System.out.print("Ingrese el ID de la biblioteca a Eliminar: ");
        int id = leer.entero();
        bibliotecaDAO bibliotecaDAO = new bibliotecaDAO();
        bibliotecaDAO.eliminarbiblioteca(id);
    }
     public static void error()
     {
         System.out.println("Error de caracter....");
     }
     public static void editarbiblioteca()
    {
        listarbiblioteca();
        System.out.print("Ingrese el ID de la biblioteca a Editar: ");
        int id = leer.entero();   
        String nombre;
        String codigo;
        String direccion;
        String telefono;
        String estado;
        System.out.println("Editar biblioteca");
        System.out.print("Nombre: ");
        nombre = leer.cadena();
        do {             
             System.out.print("codigo: ");
             codigo = leer.cadena();
             if(codigo.length()!=8){
                 error();
             }
         } while (codigo.length()!=8);
       do {             
             System.out.print("Direccion: ");
             direccion = leer.cadena();
             if(direccion.length()!=50){
                 error();
             }
         } while (direccion.length()!=50);
        do {             
             System.out.print("Telefono: ");
             telefono = leer.cadena();
             if(telefono.length()!=9){
                 error();
             }
         } while (telefono.length()!=9);
        do {             
             System.out.print("estado: ");
             estado = leer.cadena();
             if(estado.length()!=1){
                 error();
             }
         } while (estado.length()!=1);
        Biblioteca biblioteca = new Biblioteca(id, nombre, codigo, direccion, telefono, estado);
        bibliotecaDAO cursoDAO = new bibliotecaDAO();
        cursoDAO.editarbiblioteca(biblioteca);
    }
      public static void agregarbiblioteca()
    {
        String nombre;
        String codigo;
        String direccion;
        String telefono;
        String estado;
        
        System.out.println("Agregar Biblioteca");
        System.out.print("Nombre: ");
        nombre = leer.cadena();
        do {             
             System.out.print("codigo: ");
             codigo = leer.cadena();
             if(codigo.length()!=8){
                 error();
             }
         } while (codigo.length()!=8);
        do {             
             System.out.print("Direccion: ");
             direccion = leer.cadena();
             if(direccion.length()!=50){
                 error();
             }
         } while (direccion.length()!=50);
       
        do {             
             System.out.print("Telefono: ");
             telefono = leer.cadena();
             if(telefono.length()!=9){
                 error();
             }
         } while (telefono.length()!=9);
        do {             
             System.out.print("estado: ");
             estado = leer.cadena();
             if(estado.length()!=1){
                 error();
             }
         } while (estado.length()!=1);
       
 
        Biblioteca biblioteca = new Biblioteca(0 , nombre, codigo, direccion, telefono, estado);
        bibliotecaDAO bibliotecaDAO = new bibliotecaDAO();
        bibliotecaDAO.agregarbiblioteca(biblioteca);
    }
      public static String darFormato(String cadena, int v){
        if (cadena.length()>v) {
        cadena = cadena.substring(0,v-3) + "...";
        }
        if (cadena.length()<v) {
            while(cadena.length()!=v){
        cadena = cadena + " ";
        }}
        
        return cadena;
    }
       
       public static String darFormato2(String cadena){
        if (cadena.length()>=12) {
            cadena = cadena.substring(0,13) + "..."+" ";
        }
         else {
            if (cadena.length()>=1) {
            cadena = cadena + " "+" \t";
        }
        }
        
        
        return cadena;
    }
     public static void inicio()
     {
          int opcion;
        do {            
            menu();
            opcion = leer.entero();
            switch(opcion){
                case 1:
                    listarbiblioteca();
                    break;
                case 2:
                    eliminarbiblioteca();
                    break;
                case 3:
                    editarbiblioteca();
                    break;
                case 4:
                    agregarbiblioteca();
                    break;
                case 5:
                    salir();
                    break;
            }
        } while (opcion!=5);
     }
    
    
    
    public static void main(String[] args) {
        inicio();
    }
}
