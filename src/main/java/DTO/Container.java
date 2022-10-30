package DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Container <Key, Value> {

    private final   Key key;
    private final Value value;

    @Override
    public String toString() {

        return value.toString();
    }
}
