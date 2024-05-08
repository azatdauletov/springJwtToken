package kg.alima.SpringJwtToken.model;

public class AuthenticationResponce {
    private String token;

    public String getToken() {
        return token;
    }

    public AuthenticationResponce(String token) {
        this.token = token;
    }
}
