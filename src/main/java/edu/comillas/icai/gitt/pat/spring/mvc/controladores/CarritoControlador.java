package edu.comillas.icai.gitt.pat.spring.mvc.controladores;

import edu.comillas.icai.gitt.pat.spring.mvc.modelo.Carrito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CarritoControlador {
    private final Map<Integer, Carrito> carritos = new HashMap<>();

    @PostMapping("/api/carrito")
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito nuevoCarrito) {
        carritos.put(Carrito.getIdCarrito(), nuevoCarrito);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCarrito);
    }

    @GetMapping("/api/carrito")
    public List<Carrito> getCarritos() {
        return new ArrayList<>(carritos.values());
    }

    @GetMapping("/api/carrito/{idCarrito}")
    public ResponseEntity<Carrito> getCarrito(@PathVariable int idCarrito) {
        Carrito c = carritos.get(idCarrito);
        return (c != null) ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/carrito/{idCarrito}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarCarrito(@PathVariable int idCarrito) {
        carritos.remove(idCarrito);
    }

    @PutMapping("/api/carrito/{idCarrito}")
    public ResponseEntity<Carrito> modificaCarrito(@PathVariable Integer idCarrito, @RequestBody Carrito carrito) {
        if (!carritos.containsKey(idCarrito)) {
            return ResponseEntity.notFound().build();
        }
        carritos.put(idCarrito, carrito);
        return ResponseEntity.ok(carrito);
    }
}
