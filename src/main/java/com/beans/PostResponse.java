package beans;

public class PostResponse {
	protected String message;
	protected String statusCode;
	
	public PostResponse(String statusCode){
		super();
		this.statusCode = statusCode;
	}
	public PostResponse(){}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
