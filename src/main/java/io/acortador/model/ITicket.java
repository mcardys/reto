package io.acortador.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicket extends CrudRepository<Ticket,Long> {
}
