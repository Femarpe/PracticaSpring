package com.ADA.PracticaSpring.controler;

import com.ADA.PracticaSpring.domain.Arma;
import com.ADA.PracticaSpring.repository.ArmaRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArmaRestControler {
    private final Log log = LogFactory.getLog(ArmaRestControler.class);

    private final ArmaRepository armaRepository;

    public ArmaRestControler(ArmaRepository armaRepository) {
        this.armaRepository = armaRepository;
    }

    @GetMapping("/arma")
    List<Arma> getAll() {
        return (List<Arma>) armaRepository.findAll();
    }

    @GetMapping("/armas/{id}")
    Arma one(@PathVariable Long id) throws ArmaNotFoundException {
        return armaRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new ArmaNotFoundException(id));
    }

    @GetMapping("/")
    public String showDocumenation(Model model) {
        return "index";
    }

    @GetMapping("/view/armas")
    public String getArmas(Model model){
        model.addAttribute("armas",armaRepository.findAll());
        return "arma/list";
    }

    @GetMapping("/view/addarma")
    public String addArma(Model model){
        model.addAttribute("arma", new Arma());
        return "arma/add-arma";
    }

    @PostMapping("/view/createdarma")
    public String addArma(@ModelAttribute Arma arma, Model model){
        armaRepository.save(arma);
        model.addAttribute("arma", arma);
        return "arma/result";
    }

    @PostMapping("/armas")
    Arma newArma(@RequestBody Arma newArma) {
        log.info("newArma");
        return armaRepository.save(newArma);
    }


    @PutMapping("/armas/{id}")
    Arma replaceAdv(@RequestBody Arma newArma, @PathVariable Long id) {
        return armaRepository.findById(Math.toIntExact(id)).map(arma -> {
            arma.setNombreArma(newArma.getNombreArma());
            return armaRepository.save(arma);
        }).orElseGet(() -> {
            newArma.setIdArma(id);
            return armaRepository.save(newArma);
        });
    }

    @DeleteMapping("/armas/{id}")
    void deleteArma(@PathVariable long id) {
        armaRepository.deleteById(Math.toIntExact(id));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private class ArmaNotFoundException extends RuntimeException {
        public ArmaNotFoundException(Long id) {
            System.out.println("arma con id:" + id + "no locolizado");
        }
    }
}
