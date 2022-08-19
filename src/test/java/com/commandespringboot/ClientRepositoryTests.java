package com.commandespringboot;

import com.commandespringboot.models.Adresse;
import com.commandespringboot.models.Client;
import com.commandespringboot.repository.ClientRepository;
import com.commandespringboot.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ClientRepositoryTests {

   @Autowired
   private ClientRepository clientRepository;

    @Test
    public  void testAddClient(){

        Adresse adresse = new Adresse();
        adresse.setQuartier("medina");
        adresse.setVille("kaolack");

        Client client = new Client();
        client.setNom("admin");
        client.setPrenom("admin");
        client.setEmail("admin@gmail.com");
        client.setAdresse(adresse);
        client.setPassword("passer");
        client.setNumero(771249886);
        client.setRoles("ROLE_ADMIN");

        /*Client okay = clientRepository.save(client);

        Assertions.assertThat(okay).isNotNull();
        Assertions.assertThat(okay.getId()).isGreaterThan(0);*/
    }
 /*

    @Test
    public void TestFindAll(){
        List<Client> clients = clientRepository.findAll();
        Assertions.assertThat(clients.size()).isGreaterThan(0);

        for (Client client : clients) {
            System.out.println(client);
        }
    }

    @Test
    public void testGet(){
        Client client = clientRepository.findById(2L).get();
        Assertions.assertThat(client.getId()).isEqualTo(2L);
        System.out.println(client);
    }

 @Test
    public void testUpdate(){
        Client client = clientRepository.findById(2L).get();
        client.setUserName("imama@gmail.com");
        clientRepository.saveAndFlush(client);

        Assertions.assertThat(client.getUserName()).isEqualTo("imam@gmail.com");
    }*/



    /*@Test
    public void testDelete(){
        Integer id = 9;
        clientRepository.deleteById(id);

        Optional<Client> optionalClient = clientRepository.findById(id);
        Assertions.assertThat(optionalClient).isNotPresent();

    }*/
}
