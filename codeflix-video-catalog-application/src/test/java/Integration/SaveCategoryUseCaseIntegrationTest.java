package Integration;

import app.projetaria.codeflixvideocatalog.CodeflixVideoCatalogApplication;
import app.projetaria.codeflixvideocatalog.dto.CategoryRequestDTO;
import app.projetaria.codeflixvideocatalog.ports.usecase.CategoryManagerUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;

import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

@SpringBootTest(classes = CodeflixVideoCatalogApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("Teste de integração: Salvar categoria")
public class SaveCategoryUseCaseIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CategoryManagerUseCase categoryManagerUseCase;

    private String jsonCategoryData;

    @BeforeEach
    public void prepare() {
        InputStream jsonInputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("category.json");

        jsonCategoryData = new Scanner(jsonInputStream, "UTF-8").useDelimiter("\\Z").next();
    }

    @Test
    @DisplayName("Salvar categoria com sucesso")
    public void shouldBeSaveCategory() throws Exception {

        String jsonCategory = this.getCategoryJsonBy("valid_category");

        MvcResult requestResult = this.mvc.perform(
                post("/v1/categories").accept(MediaType.APPLICATION_JSON).content(jsonCategory).contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andReturn();

        // VALIDAR O @CONFIG PRA SUBIR O SPRING APENAS UMA VEZ EM TODOS OS TESTES INTEGRADOS

        // pegar response e bater o tamanho do code e se o code existe

        //Assertions.assertEquals(requestResult.getResponse().getco);
    }

    private String getCategoryJsonBy(String categoryType) throws JsonProcessingException {
        Map<String, Object> jsonCategory = JsonPath.parse(jsonCategoryData).read("$['" + categoryType + "']");
        return (new ObjectMapper()).writeValueAsString(jsonCategory);
    }
}
