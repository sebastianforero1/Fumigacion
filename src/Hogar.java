public class Hogar {

    protected String plaga, producto;

    protected Hogar() {
        plaga = "Sin asignar";
        producto = "Sin asignar";
    }

    // GetySet de la plaga
    public String getPlaga() {
        return plaga;
    }

    public void setPlaga(String datoPlaga) {
        plaga = datoPlaga;
    }

    // Get y set del producto
    public void setProducto(String datoProducto) {
        producto = datoProducto;
    }

    public String getProducto() {
        return producto;
    }

    @Override

    public String toString() {
        String informacion = "Plaga: " + plaga + ", Producto: " + producto;
        return informacion;
    }

}