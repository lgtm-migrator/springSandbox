package nc.dva.examples.hystrix;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import com.google.gson.Gson;

import nc.dva.examples.player.PlayerRepository;

@Configuration
public class PlayerCountryFallbackProvider implements FallbackProvider {
	
	@Autowired
	private PlayerRepository lPlayerRepository;

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.OK.value();
			}

			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.OK.toString();
			}

			@Override
			public void close() {
			}

			@Override
			public InputStream getBody() throws IOException {

				List<String> localCountries = lPlayerRepository.findCountries();
				List<Country> result = new ArrayList<Country>();
				
				for (String codeIso3 : localCountries) {
					Country lCountry = new Country(codeIso3, codeIso3);
					result.add(lCountry);
				}

				return new ByteArrayInputStream(new Gson().toJson(result).getBytes());

			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				headers.setAccessControlAllowOrigin("*");
				return headers;
			}
		};
	}

	@Override
	public String getRoute() {
		// Might be confusing: it's the serviceId property and not the
		// route!!!
		// Be carefull !
		return "MS-Countries";
	}

}
