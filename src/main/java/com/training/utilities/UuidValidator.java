package com.training.utilities;

import java.util.regex.Pattern;

public class UuidValidator {

    public boolean isValidUUID(String accountId) {
        return accountId==null ? false:
                Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$")
                        .matcher(accountId).matches();
    }
}