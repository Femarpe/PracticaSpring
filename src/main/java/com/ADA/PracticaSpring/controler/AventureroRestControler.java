package com.ADA.PracticaSpring.controler;

import com.ADA.PracticaSpring.domain.Aventurero;
import com.ADA.PracticaSpring.repository.AventureroRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AventureroRestControler {
    private final Log log = LogFactory.getLog(ArmaRestControler.class);

    private final AventureroRepository aventureroRepository;

    public AventureroRestControler(AventureroRepository aventureroRepository) {
        this.aventureroRepository = aventureroRepository;
    }

    @GetMapping("/aventurero")
    List<Aventurero> getAll() {
        return (List<Aventurero>) aventureroRepository.findAll();
    }

    @GetMapping("/aventureros/{id}")
    Aventurero one(@PathVariable Long id) throws AventureroNotFoundException {
        return aventureroRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new AventureroNotFoundException(id));
    }

    @GetMapping("/")
    public String showDocumenation(Model model) {
        return "index";
    }

    @GetMapping("/view/aventureros")
    public String getAventureros(Model model){
        model.addAttribute("aventureros",aventureroRepository.findAll());
        return "aventurero/list";
    }

    @GetMapping("/view/addaventurero")
    public String addAventurero(Model model){
        model.addAttribute("aventurero", new Aventurero());
        return "aventurero/add-aventurero";
    }

    @PostMapping("/view/createdaventurero")
    public String addAventurero(@ModelAttribute Aventurero aventurero, Model model){
        aventureroRepository.save(aventurero);
        model.addAttribute("aventurero", aventurero);
        return "aventurero/result";
    }

    @PostMapping("/aventureros")
    Aventurero newAventurero(@RequestBody Aventurero newAventurero) {
        log.info("newAventurero");
        return aventureroRepository.save(newAventurero);
    }


    @PutMapping("/aventureros/{id}")
    Aventurero replaceAdv(@RequestBody Aventurero newAventurero, @PathVariable Long id) {
        return aventureroRepository.findById(Math.toIntExact(id)).map(aventurero -> {
            aventurero.setNombreAventurero(newAventurero.getNombreAventurero());
            return aventureroRepository.save(aventurero);
        }).orElseGet(() -> {
            newAventurero.setIdAdv(id);
            return aventureroRepository.save(newAventurero);
        });
    }

    @DeleteMapping("/aventureros/{id}")
    void deleteAventurero(@PathVariable long id) {
        aventureroRepository.deleteById(Math.toIntExact(id));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private class AventureroNotFoundException extends RuntimeException {
        public AventureroNotFoundException(Long id) {
            System.out.println("aventurero con id:" + id + "no locolizado");
        }
    }
}
