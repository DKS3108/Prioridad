public class Cliente implements Comparable<Cliente> {
    private String nombre;
    private String tipoTransaccion;
    private int prioridad;

    public Cliente(String nombre, String tipoTransaccion, int prioridad) {
        this.nombre = nombre;
        this.tipoTransaccion = tipoTransaccion;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "Nombre: " + nombre +
                ", TipoTransaccion: '" + tipoTransaccion +
                ", Prioridad: " + prioridad + '\n';
    }

    @Override
    public int compareTo(Cliente o) {
        if(this.prioridad<o.prioridad)
            return 1;
        else return -1;
    }

}