package dao;

public class User {
	private String username;
	private String login;
	private String password;
	
	 public User(String username,String login,String password) {
	      
	        this.username = username;
	        this.login = login;
	        this.password = password;
	    }
	 
	 public User() {}
	 
	 public User(String login,String password) {
	      
	       
	        this.login = login;
	        this.password = password;
	    }
	 
	  public void setId(String username) {
	        this.username = username;
	    }
	  public void setLogin(String login) {
	        this.login = login;
	    }
	  public void setPassword(String password) {
	        this.password = password;
	    }
	  public String getUsername() {
	        return username;
	    }
	  public String getLogin() {
	        return login;
	    }  
	  public String getPassword() {
	        return password;
	    }


}
