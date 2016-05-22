package ru.tustrip.portal.service;

import ru.tustrip.portal.model.Agent;

import java.util.List;

/**
 * Created by antonorlov on 20/05/16.
 */
public interface AgentService {

    Agent saveAgent(final Agent agent);

    Agent getAgent(final Long id);

    void deleteAgent(final Agent agent);

    List<Agent> getAllAgents();
}
