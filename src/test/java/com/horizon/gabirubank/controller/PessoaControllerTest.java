package com.horizon.gabirubank.controller;

import com.horizon.gabirubank.model.dto.DadosPessoaDTO;
import com.horizon.gabirubank.service.PessoaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class PessoaControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private JacksonTester<DadosPessoaDTO> dadosPessoaDTOJson;

    @MockBean
    private PessoaService pessoaService;

    @Test
    @DisplayName("Deve retornar código http 400")
    void cadastrar_pessoa_sem_sucesso() throws Exception {
        var response = mvc.perform(post("/pessoa")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve retornar código http 200")
    void cadastrar_pessoa_com_sucesso() throws Exception {
        var pessoaDto = new DadosPessoaDTO(2l,"teste","11111111111","22222222222");
        when(pessoaService.salvar(any())).thenReturn(pessoaDto);

        var response = mvc.perform(
                post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosPessoaDTOJson.write(pessoaDto).getJson())
        ).andReturn().getResponse();


        var jsonEsperado = dadosPessoaDTOJson.write(pessoaDto).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}