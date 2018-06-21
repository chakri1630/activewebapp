package com.activeweb.app.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.activeweb.app.beans.Credentials;

/**
 * Handles requests for the application home page.
 */
@RequestMapping(value="/activeweb")
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String login(@RequestBody Credentials credentials, Locale locale, Model model) {
		logger.error("Welcome home! The client locale is {}.", locale);

		try {

			// return success by calling db..

		} catch (Exception e) {
			logger.error("Somebody got an error page");
			return "error";
		}

		return "home";
	}

	/**
	 * Simply selects the login view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.error("Welcome home! The client locale is {}.", locale);

		return "login";
	}

}
