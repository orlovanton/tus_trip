package ru.tustrip.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tustrip.portal.model.Agent;
import ru.tustrip.portal.repository.AgentRepository;

import java.util.List;

/**
 * Created by antonorlov on 20/05/16.
 */
@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository repository;

    @Override
    public Agent saveAgent(Agent agent) {
        //todo validation
        Agent saved = repository.save(agent);
        return saved;
    }

    @Override
    public Agent getAgent(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void deleteAgent(Agent agent) {
        //todo:
        throw new UnsupportedOperationException("not impl");
    }

    @Override
    public List<Agent> getAllAgents() {
       return repository.findAll();
    }
}
