package br.com.safemap.service;

import br.com.safemap.entity.Event;
import br.com.safemap.repository.EventRepository;

import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Salva um novo evento no banco de dados.
     *
     * @param event Evento a ser salvo.
     * @return Evento salvo.
     */
    public Event saveEvent(Event event) {
        event.setTimestamp(LocalDateTime.now()); // Define o horário atual como timestamp
        return eventRepository.save(event);
    }

    /**
     * Busca todos os eventos registrados.
     *
     * @return Lista de eventos.
     */
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Busca um evento pelo ID.
     *
     * @param id ID do evento.
     * @return Evento encontrado ou vazio se não existir.
     */
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    /**
     * Atualiza um evento existente.
     *
     * @param id    ID do evento a ser atualizado.
     * @param event Dados atualizados do evento.
     * @return Evento atualizado ou vazio se não encontrado.
     */
    public Optional<Event> updateEvent(Long id, Event event) {
        return eventRepository.findById(id).map(existingEvent -> {
            existingEvent.setCategory(event.getCategory());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setSeverity(event.getSeverity());
            existingEvent.setLatitude(event.getLatitude());
            existingEvent.setLongitude(event.getLongitude());
            existingEvent.setReviewed(event.isReviewed());
            return eventRepository.save(existingEvent);
        });
    }

    /**
     * Remove um evento pelo ID.
     *
     * @param id ID do evento a ser removido.
     * @return 
     */
    public ResponseEntity<Void> deleteEvent(Long id) {
        eventRepository.deleteById(id);
        return null;
    }

    /**
     * Busca eventos filtrados por categoria.
     *
     * @param category Categoria do evento.
     * @return Lista de eventos filtrados.
     */
    // public List<Event> getEventsByCategory(String category) {
    //     return eventRepository.findByCategory(category);
    // }

    /**
     * Busca eventos registrados nas últimas 24 horas.
     *
     * @return Lista de eventos recentes.
     */
    // public List<Event> getEventsFromLast24Hours() {
    //     LocalDateTime last24Hours = LocalDateTime.now().minusHours(24);
    //     //return eventRepository.findByTimestampAfter(last24Hours);
    // }
}