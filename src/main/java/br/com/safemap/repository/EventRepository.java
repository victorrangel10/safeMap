package br.com.safemap.repository;

import br.com.safemap.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

    // Custom query methods can be defined here if needed
    // For example, to find events by category or severity
    List<Event> findByCategory(String category);
    
    List<Event> findBySeverity(Integer severity);
    
    List<Event> findByReviewed(boolean reviewed);
    
}
