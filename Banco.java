import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Banco {

    private PriorityQueue<Cliente> clientes;

    public Banco() {
        clientes=new PriorityQueue<Cliente>();
    }

    public void encolar(Cliente c) {
        clientes.add(c);

    }

    public  Cliente desencolar() throws Exception{

        if(clientes.isEmpty())
            throw new Exception("Ya no hay clientes en la cola");
        return clientes.poll();

    }
    public List<Cliente> listarClientes(){

        return new ArrayList<>(clientes);

    }

}
