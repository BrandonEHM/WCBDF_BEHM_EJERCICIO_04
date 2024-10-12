package upiiz.Suppliers.controllers;

import upiiz.Suppliers.models.Supplier;
import upiiz.Suppliers.services.SuppliersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/suppliers")
@RestController
public class SuppliersController {
    // Requiero INYECTAR el servicio
    SuppliersService suppliersService;

    public SuppliersController(SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    // GET - Todas las Suppliers
    @GetMapping
    public ResponseEntity<List<Supplier>> getSuppliers() {
        return ResponseEntity.ok(suppliersService.getAllSuppliers());  // Este también debería estar correcto
    }
    // GET - Solo un Supplier
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable Long id) {
        return ResponseEntity.ok(suppliersService.getSupplierById(id));
    }

    // POST - Crear un Supplier
    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(suppliersService.createSupplier(supplier));
    }

    // PUT - Actualizar un Supplier
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier, @PathVariable Long id) {
        supplier.setId(id);
        return ResponseEntity.ok(suppliersService.updateSupplier(supplier));
    }

    // DELETE - Eliminar una Supplier por Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        suppliersService.deleteSupplier(id);  // Ahora debería estar correcto
        return ResponseEntity.noContent().build();
    }
}
