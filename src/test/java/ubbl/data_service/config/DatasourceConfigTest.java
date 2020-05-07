package ubbl.data_service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceConfigTest {
    // integration test. uses local mongodb instance
    @Autowired MongoClient mg;
    
    public void envDatabaseNameIsNotNull() {
        String uri = System.getenv("MONGODB_URI");
        String db = uri.substring(uri.lastIndexOf("/")+1);
        assertThat(db, is("ubbdb"));
    }
    
    @Test
    public void mongoClientIsNotNull() {
        assertThat(this.mg, notNullValue());
    }
}
