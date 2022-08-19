package com.commandespringboot;

        import com.commandespringboot.models.Marque;
        import com.commandespringboot.repository.MarqueRepository;
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
public class MarqueRepositoryTests {
    @Autowired
    private MarqueRepository marqueRepository;
    private List<Marque> marqueArrayList = new ArrayList<>();
    @Test
    public  void testAddMarque(){
        marqueArrayList.add(new Marque("Coca-Cola"));
        marqueArrayList.add(new Marque("Fanta"));
        marqueArrayList.add(new Marque("Sprit"));
        marqueArrayList.add(new Marque("Rani"));
        marqueArrayList.add(new Marque("Presséa"));
        marqueArrayList.add(new Marque("RedBull"));

        /*List<Marque> okay = marqueRepository.saveAll(marqueArrayList);

        Assertions.assertThat(okay).isNotNull();
        for (Marque t : marqueArrayList){
            Assertions.assertThat(t.getId()).isGreaterThan(0);
        }*/
    }


}
