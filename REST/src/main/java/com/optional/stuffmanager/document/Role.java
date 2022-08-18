package com.optional.stuffmanager.document;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@RequiredArgsConstructor
public class Role {

    @Id
    @Getter
    @Setter
    private String Id;

    @NonNull
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Set<Employee> employees;

}
