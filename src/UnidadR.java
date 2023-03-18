import java.util.Objects;
import java.util.Random;

public class UnidadR {

    private int numeroHogares;
    private boolean estaPreparada = false;

    private Hogar[] losHogares;

    public Hogar[] hogar;

    protected String[] losProductosH = new String[] {
            "Desinfectantes", "Fungicidas", "Inhibidores"
    };
    protected String[] losProductosR = new String[] {
            "Anticoagulantes", "Neurotoxicos", "Repelentes"
    };
    protected String[] losProductosI = new String[] {
            "Insecticidas", "Repelentes", "Desinfectantes"
    };

    public UnidadR() {
        int numeroHogares;
        estaPreparada = false;
        inicializaArreglos();
    }

    public UnidadR(int numeroHogares) {
        if (numeroHogares > 0) {
            this.numeroHogares = numeroHogares;
            System.out.println("El numero de hogares fue " + numeroHogares);
            inicializaArreglos();
        } else {
            this.numeroHogares = 0;
            estaPreparada = false;
        }
    }

    String[] Plagas = { "Hongos", "Ratas", "Insectos", "No fumigara" };

    private void inicializaArreglos() {

        System.out.println("Ya se van a elegir que necesita cada casa");
        String[] Plagas = { "Hongos", "Ratas", "Insectos", "No fumigara" };
        String[] ProductosH = { "Desinfectantes", "Fungicidas", "Inhibidores" };
        String[] ProductosR = { "Anticoagulantes", "Neurotoxicos", "Repelentes" };
        String[] ProductosI = { "Insecticidas", "Repelentes", "Desinfectantes" };

        if (numeroHogares > 0) {
            Random aleatorio = new Random();
            Random aleatorio2 = new Random();
            losHogares = new Hogar[numeroHogares];
            hogar = new Hogar[numeroHogares];

            for (int i = 0; i < hogar.length; i++) {
                losHogares[i] = new Hogar();
                hogar[i] = new Hogar();

                int indiceAleatorioplagas = aleatorio.nextInt(Plagas.length);
                int indiceAleatorioproducto = aleatorio2.nextInt(losProductosH.length);

                switch (indiceAleatorioplagas) {
                    case 0:
                        hogar[i].setPlaga(Plagas[indiceAleatorioplagas]);
                        hogar[i].setProducto(ProductosH[indiceAleatorioproducto]);
                        break;
                    case 1:
                        hogar[i].setPlaga(Plagas[indiceAleatorioplagas]);
                        hogar[i].setProducto(ProductosR[indiceAleatorioproducto]);
                        break;
                    case 2:
                        hogar[i].setPlaga(Plagas[indiceAleatorioplagas]);
                        hogar[i].setProducto(ProductosI[indiceAleatorioproducto]);
                        break;
                    case 3:
                        hogar[i].setPlaga(Plagas[indiceAleatorioplagas]);
                        hogar[i].setProducto("N/A");
                        break;

                }
            }
            estaPreparada = true;
        }
    }

    public CasasFumigadas ObtienePorcentajeHogaresFumigados() {
        CasasFumigadas resultadoPorcentaje = CalculoPorcentaje(hogar);
        return resultadoPorcentaje;
    }

    public CasasFumigadas CalculoPorcentaje(Hogar[] hogar) {

        CasasFumigadas resultado = new CasasFumigadas();
        int contadorDeCasasFumigadas = 0;
        for (Hogar hogarcito : hogar) {
            if (!Objects.equals(hogarcito.plaga, "No fumigara")) {
                contadorDeCasasFumigadas++;
            }
        }

        float numeroPorcentaje = ((contadorDeCasasFumigadas / (float) (numeroHogares) * 100));
        resultado.setPorcentaje(numeroPorcentaje);
        return resultado;

    }

    public Hogar[] getHogares() {
        return losHogares;
    }

    public String[] getPlagas() {
        return Plagas;
    }

    public ProductoModa ObtieneProductoPlagaMasUtilizado() {
        ProductoModa productoResultado = calcularProducto(hogar, Plagas);
        return productoResultado;
    }

    public ProductoModa calcularProducto(Hogar[] arrayhogar, String[] arrayplaga) {
        arrayhogar = hogar;
        /*
         * int[] contadorPlagas = new int[plaga.length];
         * for (int i = 1; i < contadorPlagas.length; i++) {
         * contadorPlagas[i] = 0;
         * }
         * for (int i = 0; i < plaga.length; i++)
         * {
         * for (int j = 0; j < hogar.length; j++)
         * {
         * if (plaga[i] == hogar[j].getPlaga())
         * contadorPlagas[i]++;
         * }
         * }
         */
        int contR = 0;
        int contI = 0;
        int contH = 0;

        String[] productos = new String[hogar.length];

        for (int i = 0; i < hogar.length; i++) {
            productos[i] = hogar[i].getProducto();
            switch (hogar[i].getPlaga()) {
                case "Hongos":
                    contH++;
                    hogar[i].getProducto();
                    break;
                case "Insectos":
                    contI++;
                    hogar[i].getProducto();
                    break;
                case "Ratas":
                    contR++;
                    hogar[i].getProducto();
                    break;
                case "No fumigara":
                    break;
            }
            System.out.println("PPPPPPP" + hogar[i].getProducto());
            System.out.println("###############" + productos.toString());

        }
        System.out.println("RATASSSS      " + contR);

        ProductoModa productoResultado = new ProductoModa();
        return productoResultado;

    }
