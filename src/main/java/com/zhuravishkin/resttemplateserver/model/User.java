package com.zhuravishkin.resttemplateserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @JsonProperty("tuple_name")
    private String name;

    @JsonProperty("tuple_age")
    private int age;
}
