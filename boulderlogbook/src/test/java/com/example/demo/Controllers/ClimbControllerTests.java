package com.example.demo.Controllers;

import com.example.demo.Models.Climb;
import com.example.demo.Models.Location;
import com.example.demo.Security.JwtAuthFilter;
import com.example.demo.Services.ClimbService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.Date;

@WebMvcTest(ClimbController.class)
@AutoConfigureMockMvc(addFilters = false)
class ClimbControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClimbService climbService;

    @MockBean
    private JwtAuthFilter jwtAuthFilter;

    @Test
    void getAllClimbs_returnsOk() throws Exception {
        mockMvc.perform(get("/api/climbs"))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getClimbById_returnsOk() throws Exception {
        mockMvc.perform(get("/api/climbs/1"))
            .andExpect(status().isOk());
    }

    @Test
void createClimb_returnsCreated() throws Exception {
    Climb mockClimb = new Climb();
    mockClimb.setId(1);
    mockClimb.setGrade("7A");
    mockClimb.setActive(true);
    mockClimb.setDate(new Date());

    Location location = new Location();
    location.setName("Test Gym");
    mockClimb.setLocation(location);

    when(climbService.createClimb(any(), anyInt(), any()))
        .thenReturn(mockClimb);

    mockMvc.perform(post("/api/climbs")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                  "grade": "7A",
                  "locationId": 1,
                  "styleTagIds": []
                }
            """))
        .andExpect(status().isCreated());
}

}
