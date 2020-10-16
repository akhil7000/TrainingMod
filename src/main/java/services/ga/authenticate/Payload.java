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

    public String getAccountId() {
        return accountId;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public String getUid() {
        return uid;
    }
}