package com.example.mysqldemo.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysqldemo.dao.TicketService;
import com.example.mysqldemo.model.Ticket;

import ch.qos.logback.classic.Logger;

@RestController
public class TicketController 
{
	private static final Logger log = 
			(Logger) LoggerFactory.getLogger(TicketController.class);
	@Autowired
	private TicketService tdao;
	
	@GetMapping("/Tickets")
	public List<Ticket> showAll()
	{
	return tdao.getAll();	
	}
	@PostMapping("/BookTicket")
	public Ticket BookHere(@RequestBody Ticket t)
	{
		Ticket tick = tdao.Add(t);
		log.info("Ticket Obj"+tick.toString());
		return tick;
		
	}
	@DeleteMapping("/Cancel/{id}")
	public String CancelTicket(int id)
	{
		tdao.DeleteTicket(id);
		return "Cancelled Succesfully";
	}
	
}
