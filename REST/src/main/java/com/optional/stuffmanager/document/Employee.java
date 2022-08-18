package com.optional.stuffmanager.document;

import com.optional.stuffmanager.job.Job;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@RequiredArgsConstructor
public class Employee {

    @Id
    @Getter
    @Setter
    public String id;

    @NonNull
    @Getter
    @Setter
    private String name;

    @NonNull
    @Getter
    @Setter
    private Job job;

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

    @Getter
    @Setter
    private Role role;
}
