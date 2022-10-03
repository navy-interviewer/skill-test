package com.cgi.boat.interview;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Person {
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
}
