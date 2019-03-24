package com.example.fluidics.utils.callback;

public interface CBSuccess<T> {
    void onResponse(boolean success, T result);
}
