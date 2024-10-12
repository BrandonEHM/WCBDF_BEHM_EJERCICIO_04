package upiiz.Suppliers.services;

import upiiz.Suppliers.repository.SuppliersRepository;
import upiiz.Suppliers.models.Supplier;
import upiiz.Suppliers.repository.SuppliersRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SuppliersService {
    // Requerimos el REPO (Datos - Listado) - Categorías
    // Requiero "INYECTAR" el servicio

    SuppliersRepository suppliersRepository;

    // Constructor - Cuando crea la instancia le pasa el repositorio
    public SuppliersService(SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
    }

    // GET - Todas las suppliers
    public List<Supplier> getAllSuppliers() {
        return suppliersRepository.obtenerTodas();
    }

    // GET - Supplier por ID
    public Supplier getSupplierById(Long id) {
        return suppliersRepository.obtenerPorId(id);
    }

    // POST - Crear supplier
    public Supplier createSupplier(Supplier supplier) {
        return suppliersRepository.guardar(supplier);
    }

    // PUT - Actualizar supplier
    public Supplier updateSupplier(Supplier supplier) {
        return suppliersRepository.actualizar(supplier);
    }

    // DELETE - Eliminar supplier
    public void deleteSupplier(Long id) {
        suppliersRepository.eliminar(id);
    }
}
