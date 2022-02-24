package com.ADA.PracticaSpring.bootstrap;

import com.ADA.PracticaSpring.domain.Arma;
import com.ADA.PracticaSpring.domain.Aventurero;
import com.ADA.PracticaSpring.repository.ArmaRepository;
import com.ADA.PracticaSpring.repository.AventureroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AventureroRepository aventureroRepository;
    private final ArmaRepository armaRepository;

    public BootStrapData(AventureroRepository aventureroRepository, ArmaRepository armaRepository) {
        this.aventureroRepository = aventureroRepository;
        this.armaRepository = armaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Aventurero aventurero = new Aventurero("Euris");
        Arma arma = new Arma("Garra", "Cortante");

        arma.setAventurero(aventurero);
        aventurero.setArma(arma);
        armaRepository.save(arma);
        aventureroRepository.save(aventurero);


        System.out.println("numero de Aventureros: " + aventureroRepository.count());
        System.out.println("numero de Armas: " + armaRepository.count());
    }
}
