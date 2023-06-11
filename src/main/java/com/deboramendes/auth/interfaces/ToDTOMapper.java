package com.deboramendes.auth.interfaces;

public interface ToDTOMapper<T, U> {
    U toDTO(final T source);
}
