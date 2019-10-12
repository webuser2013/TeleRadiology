package com.kinsolutions.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebStimulatorController {

	@RequestMapping("/stimulator")
	public String welcome() {
  		return "WebStimulator";
	}
}
