package ubbl.data_service.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString @Document(collection="playerInfo")
public class PlayerInfo {
    @Getter private String id;
    
    @Field("Is Captain(1=yes)")
    @Getter private Integer isCaptain;
    
    @Field("Is Wktkeeper(1=Yes)")
    @Getter private Integer isWktkeeper;
   
    @Field("Team")
    @Getter private String team;
    
    @Field("Name")
    @Getter private String name;
    
    @Field("Nationality")
    @Getter private String nationality;
    
    @Field("Player Value USD")
    @Getter private Integer playerValueUSD;
    
    @Field("Matches")
    @Getter private Integer matches;
    
    @Field("Innings played")
    @Getter private Integer inningsPlayed;
    
    @Field("Not out")
    @Getter private Integer notOut;
    
    @Field("Runs scored")
    @Getter private Integer runsScored;
    
    @Field("Highest score")
    @Getter private String highestScore;
    
    @Field("Is batsman")
    @Getter private Integer isBatsman;
    
    @Field("Batting avg")
    @Getter private Float battingAvg;
    
    @Field("Balls faced")
    @Getter private Integer ballsFaced;
    
    @Field("Strike rate")
    @Getter private Float strikeRate;
    
    @Field("100 runs made")
    @Getter private Integer hundredRunsMade;	
    
    @Field("50 runs made")
    @Getter private Integer fiftyRunsMade;
    
    @Field("4s")
    @Getter private Integer fours;	
    
    @Field("6s")
    @Getter private Integer sixes;
    
    @Field("Catches per match")
    @Getter private Float catchesPerMatch;
    
    @Field("Catches taken")
    @Getter private Integer catchesTaken;
    
    @Field("Matches played")
    @Getter private Integer matchesPlayed;
    
    @Field("Innings played 2")
    @Getter private String inningsPlayedTwo;
    
    @Field("Is bowler?")
    @Getter private Integer isBowler;
    
    @Field("Number of balls bowled")
    @Getter private String numberOfBallsBowled;
    
    @Field("Runs given")
    @Getter private String runsGiven;
    
    @Field("Wkts taken")
    @Getter private String wktsTaken;
    
    @Field("Bowling econ")
    @Getter private String bowlingEcon;
    
    @Field("5 Wicket hauls")
    @Getter private String fiveWicketHauls;
}
