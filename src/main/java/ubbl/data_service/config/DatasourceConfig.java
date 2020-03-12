package ubbl.data_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;

@Configuration
public class DatasourceConfig {
    private String uri;
    
    private String dbName;
    
    public String dbName() {
        return this.dbName;
    }
    
    public @Bean MongoClient mongoClient() {
        this.uri = System.getenv("MONGODB_URI");
        
        if(this.uri ==  null) {
            this.uri = "mongodb://localhost/ubbdb";
        }
        
        this.dbName = uri.substring(uri.lastIndexOf("/")+1);
        System.out.println(this.uri);
        return new MongoClient(new MongoClientURI(uri));
    }
  
    public @Bean MongoTemplate mongoTemplate() {
      return new MongoTemplate(mongoClient(), this.dbName);
    }
}
