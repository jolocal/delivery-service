package org.delivery.db.storeuser.enums;

import jdk.jfr.Registered;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreUserStatus {

    REGISTERED("등록"),

    UNREGISTERED("해지"),
    ;

    private String description;
}
