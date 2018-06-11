package resources;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import beans.PostResponse;
import beans.User;
import services.AuthenticationService;
import services.BetService;


@Path("/")
@Component
public class BetResource{
	
	@Autowired
	private BetService betService;
	
	@Autowired
	private AuthenticationService authenticationService;

	
	@GET
    @Path("/leaderboard")
    @Produces(MediaType.APPLICATION_JSON)
    public  PostResponse getLeaderBoardList() {
        return betService.getAllUserPointsInDesc();
    }
	
	@GET
    @Path("/upcomingMatches")
    @Produces(MediaType.APPLICATION_JSON)
    public PostResponse getUpcomingMatches() {
       return betService.getAllUpcomingMatches(); 
    }
	
	@POST
    @Path("/vote")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String vote(String matchId, String vote) {
        return null;
    }
	
	@GET
    @Path("/userReportCard")
    @Produces(MediaType.APPLICATION_JSON)
    public PostResponse userReportCard(@QueryParam("userEmail") String userEmail) {
       return betService.getUserReportCard(userEmail);
    }
	

	@POST
    @Path("/createUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PostResponse createUser(User user) {
        return authenticationService.createUser(user);        
    }
	
	@POST
    @Path("/authenticate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PostResponse authenticate(User user) {
        return authenticationService.authenticate(user.getUserEmail(), user.getUserPassword());
    }
	
	
}