import br.com.uol.test.Configuracao;
import br.com.uol.test.model.Jogador;
import br.com.uol.test.repository.JogadorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes={Configuracao.class})
public class JogadorRespositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    JogadorRepository jogadorRepository;

    @Test
    public void whenFindByNameThenReturnJogador() {
        Jogador guilherme = new Jogador("guilherme", "guilherme.hypolito@outlook.com", "", "", "");
        em.persist(guilherme);
        em.flush();

        Jogador jogadorBase = jogadorRepository.buscaPorNomeJogador(guilherme.getNome());

        assertThat(jogadorBase.getNome()).isEqualTo(guilherme.getNome());
    }

}
