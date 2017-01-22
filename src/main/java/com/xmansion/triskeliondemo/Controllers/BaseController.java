package com.xmansion.triskeliondemo.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

/**
 * Created by [)/\ on 29/10/16.
 */

@RestController
@RefreshScope
@Slf4j
public class BaseController {

	@Autowired
	HttpServletRequest httpServletRequest;

	@Value("${appOwner}")
	public String appOwner;
	@Value("${appVersion}")
	public String appVersion;
	@Value("${appEnvironment}")
	public String appEnvironment;


	private String getHeaderDetails() {

		String responseText = "Welcome to Triskelion Demo.\n" +
				"App owner | " + appOwner +
				"\nApp version | " + appVersion +
				"\nApp Envionment | " +appEnvironment +
				" \n\n\n\n\n";
		StringBuilder stringBuilder = new StringBuilder(responseText);

		Collections
				.list(httpServletRequest.getHeaderNames())
				.stream()
				.forEach(header->stringBuilder
						.append("\n" + header + "\t" + httpServletRequest.getHeader(header) )
				);
		return  stringBuilder.toString();
	}

	@RequestMapping(value = "/echo", method = RequestMethod.GET)
	public ResponseEntity<String> echo() {
		return new ResponseEntity<String>(
				getHeaderDetails(), HttpStatus.OK);
	}


}
