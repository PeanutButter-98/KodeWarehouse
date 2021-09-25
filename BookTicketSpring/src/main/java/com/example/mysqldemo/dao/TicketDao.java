package com.example.mysqldemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mysqldemo.model.Ticket;


@Repository("TicketRepo")
public interface TicketDao extends JpaRepository<Ticket,Integer>
{

}
