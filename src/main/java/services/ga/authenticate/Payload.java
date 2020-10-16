package services.ga.authenticate;

public class Payload {
    String accessToken;
    String accountId;
    String firstName;
    String lastName;
    String loginStatus;
    String openIdToken;
    String  refreshToken;
    int tokenExpiration;
    String uid;

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public String getOpenIdToken() {
        return openIdToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
    public int getTokenExpiration() {
        return tokenExpiration;
    }

    public String getUid() {
        return uid;
    }
}