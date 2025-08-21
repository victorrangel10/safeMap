package br.com.safemap.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.safemap.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

    // Custom query methods can be defined here if needed

    
}
