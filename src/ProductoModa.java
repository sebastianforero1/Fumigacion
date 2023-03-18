public class ProductoModa extends Hogar {

    private int cantidad;

    public ProductoModa() {

        plaga = "hola";
        producto = "Sin asignar";
    }

    public ProductoModa(String plaga, String producto) {
        this.plaga = plaga;
        this.producto = producto;

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int datoCantidad) {

        if (datoCantidad > 0) {
            cantidad = datoCantidad;
        } else {
            cantidad = 0;
        }
    }
}