package Integration;

import app.projetaria.codeflixvideocatalog.CodeflixVideoCatalogApplication;
import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.ports.persistence.CategoryPersistence;
import app.projetaria.codeflixvideocatalog.ports.usecase.CategoryManagerUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    private CategoryPersistence persistence;

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

        String code = extractCodeFromResponse(requestResult);
        Category category = persistence.get(UUID.fromString(code));

        assertEquals(code, category.getCode().toString());
    }

    private String extractCodeFromResponse(MvcResult requestResult) throws UnsupportedEncodingException {
        DocumentContext resultJson = JsonPath.parse(requestResult.getResponse().getContentAsString());

        return resultJson.read("['code']");
    }

    private String getCategoryJsonBy(String categoryType) throws JsonProcessingException {
        Map<String, Object> jsonCategory = JsonPath.parse(jsonCategoryData).read("$['" + categoryType + "']");
        return (new ObjectMapper()).writeValueAsString(jsonCategory);
    }
}
