package data.pet.controller;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
@WebMvcTest(controllers = PetController.class)
class PetControllerTest {
    /*@Autowired
    MockMvc mockMvc;
    @MockBean
    private PetServiceImpl petService;

    @Test
    void getPetWithOkStatus() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/api/pets");
        this.mockMvc.perform(requestBuilder)
                .andExpectAll(
                        status().isOk(),
                        content().contentTypeCompatibleWith("application/json"),
                        content().json("""
                                [
                                    {
                                        "id": 0,
                                        "images": [
                                          {
                                            "id": 0,
                                            "name": "string",
                                            "path": "string",
                                            "avatar": true
                                          }
                                        ],
                                        "name": "string",
                                        "gender": {
                                          "id": 0,
                                          "name": "string"
                                        },
                                        "description": "string",
                                        "history": "string",
                                        "healthType": {
                                          "id": 0,
                                          "name": "string"
                                        },
                                        "dateOfBirth": "2024-10-12T12:58:57.297Z",
                                        "createdAt": "2024-10-12T12:58:57.297Z",
                                        "breed": true,
                                        "petTypeId": {
                                          "id": 0,
                                          "name": "string"
                                        },
                                        "color": {
                                          "id": 0,
                                          "name": "string"
                                        },
                                        "hair": {
                                          "id": 0,
                                          "name": "string"
                                        },
                                        "size": {
                                          "id": 0,
                                          "name": "string"
                                        },
                                        "adopted": true,
                                        "booked": true
                                      }
                                ]
                                """)
                );
    }*/
}