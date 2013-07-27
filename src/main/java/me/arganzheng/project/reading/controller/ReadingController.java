package me.arganzheng.project.reading.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReadingController {

	@RequestMapping("hello")
	public ModelAndView showModules(@RequestParam(value = "name")
	String name) {
		Map<String, Object> model = new TreeMap<String, Object>();

		model.put("name", name);

		return new ModelAndView("hello", model);
	}

}
