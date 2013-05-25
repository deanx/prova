package com.wallmart.prova.infra.web;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.crypto.codec.Base64;

public class HttpUtils {
	
	
	public static SimpleClientHttpRequestFactory getHttpRequestFactory() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory() {
			@Override
			protected void prepareConnection(HttpURLConnection connection,
					String httpMethod) throws IOException {
				super.prepareConnection(connection, httpMethod);

				// Basic Authentication for Police API
				String authorisation = "teste" + ":" + "prova";
				byte[] encodedAuthorisation = Base64.encode(authorisation
						.getBytes());
				connection.setRequestProperty("Authorization", "Basic "
						+ new String(encodedAuthorisation));
			}
		};
		
		return factory;
	}
}
