package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mycompany.myapp.service.ShowtimeRequestService;

@Controller
public class ShowtimeController {
		private static final Logger logger = LoggerFactory.getLogger(ShowtimeController.class);
		
		@Autowired
		private ShowtimeRequestService requestService;
}
