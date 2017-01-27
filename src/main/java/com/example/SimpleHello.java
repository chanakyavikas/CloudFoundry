/*
 * Copyright (c) 2017 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 
 * @author predix -
 */
@RestController
public class SimpleHello {

	@RequestMapping("/")
	public String index() {
        return "Greetings from Spring Boot!";
    }
	
	@RequestMapping(value = "/redirect"/*, method = RequestMethod.GET*/)
    public void method(HttpServletResponse httpServletResponse) {
		String projectUrl = "https://ce30a5ca-9c2a-41f7-9ced-be97360eb282.predix-uaa.run.aws-usw02-pr.ice.predix.io/oauth/token";
        httpServletResponse.setHeader("Location", projectUrl);
    }
	
	@RequestMapping(
		      value = "/redirectWithRedirectView"/*, 
		      method = RequestMethod.GET*/
		    )
		    public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {
		        //attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
		        //attributes.addAttribute("attribute", "redirectWithRedirectView");
		        return new RedirectView("https://ce30a5ca-9c2a-41f7-9ced-be97360eb282.predix-uaa.run.aws-usw02-pr.ice.predix.io/login");
		    }
}
