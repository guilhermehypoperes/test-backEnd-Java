import br.com.uol.test.Configuracao;
import br.com.uol.test.model.Jogador;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Configuracao.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class JogadorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void whenPostJogadorThenResultSuccess() throws Exception {
        Jogador guilherme = new Jogador("guilherme", "guilherme.hypolito@outlook.com", "11986301847", "Os Vingadores", "Hulk");

        MvcResult result =  mvc.perform(MockMvcRequestBuilders.post("/salvar")
                                               .contentType(MediaType.APPLICATION_JSON)
                                               .content(new Gson().toJson(guilherme))).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }


}
