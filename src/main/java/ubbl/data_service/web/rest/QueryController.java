package ubbl.data_service.web.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class QueryController {  
    @Autowired
    public MongoOperations mongoOps;
    
    @PostMapping(path="/query", produces="application/json")
    public String executeQuery(@RequestBody String query) {
        Document result = mongoOps.executeCommand("{find: 'playerInfo', filter:" + new JSONObject(query).toString() + "}");
        
        Document cursor = result.get("cursor", Document.class);
        List<Document> firstBatch = cursor.get("firstBatch", List.class);
        
        List<String> resultJson = firstBatch.stream()
            .map(d -> d.toJson())
            .collect(Collectors.toList());
        
        return resultJson.toString();
    }
}
