package ru.tustrip.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tustrip.portal.model.Agent;

/**
 * Created by antonorlov on 20/05/16.
 */
@Repository
public interface AgentRepository extends JpaRepository<Agent,Long> {
}
