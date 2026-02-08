package edu.comillas.icai.gitt.pat.spring.mvc.controladores;

import edu.comillas.icai.gitt.pat.spring.mvc.modelo.Carrito;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class carritoControlador {
    private final Map<Integer, Carrito> carritos = new HashMap<>();

    @PostMapping("/api/contadores")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito creaCarrito(@RequestBody Carrito carrito) {
        carritos.put(Carrito.getIdCarrito(), carrito);
       return carrito;
    }

    @GetMapping("/api/carrito")
    public List<Carrito> getCarritos(){
        return (List<Carrito>) carritos.values();
    }
    @GetMapping("/api/carrito/{idCarrito}")
    public List<Carrito> getCarrito(@PathVariable int idCarrito){
        return Collections.singletonList(carritos.get(idCarrito));
    }
    @DeleteMapping("/api/carrito/{idCarrito}")
    public void borrarCarrito(@PathVariable int idCarrito){
        carritos.remove(idCarrito);
    }


    @PutMapping("/api/carrito/{idCarrito}")
    public Carrito modificaCarrito(@PathVariable Integer idCarrito,@RequestBody Carrito carrito) {
        carritos.put(idCarrito,carrito);
        return carrito;
    }
}

