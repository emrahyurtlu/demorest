package com.company.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
    private final String AUTHORIZATION_HEADER = "Authorization";
    private final String AUTHORIZATION_HEADER_PREFIX = "Basic ";

    /*
     * Bu metod sayesinde Basic Auth yöntemini uyguladık.
     * Kulanıcı adı: user ve şifresi pass olarak gelen
     * isteklere cevap verdik.
     * */
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        //return;
        /*List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
        if (authHeader != null && authHeader.size() > 0) {
            String authToken = authHeader.get(0);
            authToken = authToken.replace(AUTHORIZATION_HEADER_PREFIX, "");
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] bytesEncoded = decoder.decode(authToken.getBytes());
            String decodedString = new String(bytesEncoded);
            System.out.println("Decoded String: " + decodedString);
            StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
            String username = tokenizer.nextToken();
            String password = tokenizer.nextToken();

            System.out.println("\n" + username + ":" + password + "\n");

            if (username.equals("user") && password.equals("pass")) {
                return;
            }
        }

        Response authErrorResponse = Response.status(Response.Status.UNAUTHORIZED).entity("Wrong auht info").build();
        requestContext.abortWith(authErrorResponse);*/
    }
}
