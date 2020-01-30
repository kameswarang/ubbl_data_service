package ubbl.data_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;

@Configuration
public class DatasourceConfig {
    private String dbName;
    
    public String dbName() {
        return this.dbName;
    }
    
    public @Bean MongoClient mongoClient() {
      String uri = System.getenv("MONGODB_URI");
      this.dbName = uri.substring(uri.lastIndexOf("/")+1);
      
      return new MongoClient(new MongoClientURI(uri));
    }
  
    public @Bean MongoTemplate mongoTemplate() {
      return new MongoTemplate(mongoClient(), this.dbName);
    }
    
    //public @Bean MongoOperations mongoOperations() {
    //    return mongoTemplate();
    //}
}
