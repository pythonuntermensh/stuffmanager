package com.optional.stuffmanager.document;

import com.optional.stuffmanager.role.Role;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@RequiredArgsConstructor
public class Employee {

    @Id
    public String id;

    @NonNull
    @Getter
    private String name;

    @NonNull
    @Getter
    @Setter
    private Role role;

    @NonNull
    @Getter
    @Setter
    private int salary;

    @NonNull
    @Getter
    @Setter
    private String email;

    @NonNull
    @Getter
    @Setter
    private String password;
}
