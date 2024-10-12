package upiiz.Suppliers.repository;


import upiiz.Suppliers.models.Supplier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class SuppliersRepository {
private List<Supplier> suppliers = new ArrayList<Supplier>();

private AtomicLong id = new AtomicLong();


public Supplier guardar(Supplier supplier){
    supplier.setId(id.incrementAndGet());
    suppliers.add(supplier);
    return supplier;
}

    // GET - Todas las categorias
    public List<Supplier> obtenerTodas() {
        return suppliers;
    }

    

//Get solo un Suppliers
    public Supplier obtenerPorId(Long id){
    return suppliers.stream().filter(supplier-> supplier.getId().equals(id)).findFirst().orElse(null);

    }

    // DELETE
    public void eliminar(Long id) {
        suppliers.removeIf(supplier -> supplier.getId().equals(id));
    }

    // PUT
    public Supplier actualizar(Supplier supplier) {
        eliminar(supplier.getId());
        suppliers.add(supplier);
        return supplier;
    }
}
