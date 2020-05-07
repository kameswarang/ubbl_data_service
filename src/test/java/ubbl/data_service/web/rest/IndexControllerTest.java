package ubbl.data_service.web.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IndexControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void get_start_returns_response_with_correct_cors_headers() throws Exception {
		String origin = System.getenv("UBBL_QUERY_SERVICE");
	    mockMvc.perform(
	    	options("/")
	    		.header("Origin", origin)
	    		.header("Access-Control-Request-Method", "GET")
    		)
    	.andDo(print())
    	.andExpect(header().exists("Access-Control-Allow-Origin"))
    	.andExpect(header().string("Access-Control-Allow-Methods", "GET"));
	}
}