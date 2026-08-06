package com.example.tobis.domain;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class User {
    @Id
    String id;

    @NonNull
    String name;

    @NonNull
    String password;
}
