package com.auto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auto.entity.Log;
import com.auto.service.LogService;

@Controller
@RequestMapping("/log")
public class LogController {

	@Autowired
	private LogService logService;

	@GetMapping("/list")
	public String listLogs(Model theModel) {
		List<Log> theLogs = logService.getLogsFromDatabase();
		theModel.addAttribute("logsForTheJsp", theLogs);
		return "list-logs";
	}
}
