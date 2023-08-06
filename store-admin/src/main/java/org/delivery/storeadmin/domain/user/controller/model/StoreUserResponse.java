package org.delivery.storeadmin.domain.user.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.storeuser.enums.StoreUserRole;
import org.delivery.db.storeuser.enums.StoreUserStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreUserResponse {

    private UserResponse user; // 사용자 정보

    private StoreResponse store; // 가맹점 정보

    // 이너클래스 어노테이션은 별도로 붙여주기
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class UserResponse {

        private Long id; // 사용자 아이디

        private String email;

        private StoreUserStatus status;

        private StoreUserRole role;

        private LocalDateTime registeredAt;

        private LocalDateTime unregisteredAt;

        private LocalDateTime lastLoginAt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class StoreResponse {

        private Long id;

        private String name;
    }

}
