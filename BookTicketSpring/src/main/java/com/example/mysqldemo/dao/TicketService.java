package com.example.mysqldemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysqldemo.model.Ticket;


@Service
public class TicketService 
{
	
	@Autowired
	private TicketDao TicketRepo;
	
	public List<Ticket> getAll()
	{
		return (List<Ticket>) TicketRepo.findAll();
	}

	public Ticket Add(Ticket t) 
	{
		// TODO Auto-generated method stub
		return TicketRepo.save(t);
	}

	public void DeleteTicket(int id) 
	{
		// TODO Auto-generated method stub
		TicketRepo.deleteById(id);
		
	}

}
