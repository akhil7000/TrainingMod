package services.ga.authenticate;

import lombok.Getter;

@Getter
public class Payload {
    String accountId;
    String loginStatus;
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