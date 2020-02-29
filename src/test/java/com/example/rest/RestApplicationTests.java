package com.example.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.example.rest.service.VesselService;
import com.example.rest.model.VesselModel;
import com.example.rest.Data.Vessel;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RestApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VesselService vesselService;

	@Test
	public void findById() throws Exception {
		 VesselModel vessel = new VesselModel();
		vessel.setName("kristin");
		vessel.setCountry("Iceland");
		//vessel.setSpeed(12);
		//vessel.setLatitude(64.9312762);
		//vessel.setLongitude(64.9312762);

		Vessel data = new Vessel();
		given(vesselService.getVessel((long) 1)).willReturn(data);

		this.mockMvc.perform(get("/vessel/vessel/1"))
				.andExpect(status().isOk())
				.andExpect(content().json("[{'id': 1,'name': 'kristin';'country':'Iceland' }]"));
	}
}

