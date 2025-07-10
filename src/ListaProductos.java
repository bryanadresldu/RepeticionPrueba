import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaProductos {
   public static ArrayList<Producto> listaProductos=new ArrayList<>();

   public static void actualizarLista(Producto p){
       listaProductos.add(p);
   }

    public static ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
}
