package com.example.fluidics.adapter;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {


    private static final String REGISTER_REQUEST_URL = "http://192.168.100.60/Register.php";
    private Map<String, String> parame;

    public RegisterRequest(String name, String app, String apm, String email, String password, Response.Listener<String> listener) {

        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        parame = new HashMap<>();
        parame.put("name", name);
        parame.put("app", app);
        parame.put("apm", apm);
        parame.put("email", email);
        parame.put("password", password);


    }

    public Map<String, String> getParame() {
        return parame;
    }
}
