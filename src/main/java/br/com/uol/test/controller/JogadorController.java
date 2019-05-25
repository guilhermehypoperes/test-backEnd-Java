package br.com.uol.test.controller;


import br.com.uol.test.model.Jogador;
import br.com.uol.test.repository.JogadorRepository;
import br.com.uol.test.util.CodinomeUtil;
import br.com.uol.test.util.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    ConfigProperties properties;

    @RequestMapping("jogadores")
    public String listaJogadores(Model model){

        Iterable<Jogador> jogadores = jogadorRepository.findAll();
        model.addAttribute("jogadores",jogadores);

        return "jogador";
    }

    @RequestMapping(value = "salvar",method = RequestMethod.POST)
    public ResponseEntity<String> salvar(@RequestBody Jogador jogador, Model model){
        try {
            //Recupera os codinomes em uso de acordo com o arquivo
            List<String> listaDeCodinomesEmUso = jogadorRepository.buscaListaCodinome(jogador.getGrupo());

            String codinome = new CodinomeUtil().getCodinomeDisponivel(jogador.getGrupo(), listaDeCodinomesEmUso, properties);
            if(!codinome.isEmpty()){
                jogador.setCodinome(codinome);
                jogadorRepository.save(jogador);
                return new ResponseEntity<String>("Jogador cadastrado com sucesso!",HttpStatus.OK);
            }else{
                return new ResponseEntity<String>("Sem codinome disponivel para a lista selecionada!",HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao cadastrar jogador!",HttpStatus.BAD_REQUEST);
        }
    }

}
