package ubbl.data_service.web.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins={"${UBBL_QUERY_SERVICE}"}, methods={RequestMethod.GET})
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String get() {
        return "OK";
    }
}