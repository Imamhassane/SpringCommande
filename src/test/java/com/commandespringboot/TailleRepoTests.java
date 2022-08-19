package com.commandespringboot;

import com.commandespringboot.models.Marque;
import com.commandespringboot.models.ProduitAttributes;
import com.commandespringboot.models.Taille;
import com.commandespringboot.repository.TailleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TailleRepoTests {
    @Autowired
    private TailleRepository tailleRepository;
    private List<Taille> tailleList = new ArrayList<>();
    @Test
    public  void testAddTaillet(){
        tailleList.add(new Taille(new ProduitAttributes("cannette", 700),"BOISSON"));
        tailleList.add(new Taille(new ProduitAttributes("bouteille 250ml", 500),"BOISSON"));
        tailleList.add(new Taille(new ProduitAttributes("bouteille 1L", 1500),"BOISSON"));
        tailleList.add(new Taille(new ProduitAttributes("frittes simple", 500), "FRITTES"));
        tailleList.add(new Taille(new ProduitAttributes("frittes double", 800), "FRITTES"));
        tailleList.add(new Taille(new ProduitAttributes("frittes mixte", 1200), "FRITTES"));

        /*List<Taille> okay = tailleRepository.saveAll(tailleList);

        Assertions.assertThat(okay).isNotNull();
        for (Taille t : tailleList){
            Assertions.assertThat(t.getId()).isGreaterThan(0);
        }*/
    }
    @Test
    public void TestFindAll(){
        List<Taille> tailles = tailleRepository.findByType("BOISSON");
        Assertions.assertThat(tailles.size()).isGreaterThan(0);

        for (Taille t : tailles) {
            System.out.println(t);
        }
    }
}
