package ru.tustrip.portal.service;

import org.springframework.stereotype.Service;
import ru.tustrip.portal.mock.BaseMock;
import ru.tustrip.portal.model.Agent;

import java.util.List;

/**
 * Created by antonorlov on 20/05/16.
 */
@Service
public class AgentServiceImpl implements AgentService {

    @Override
    public void saveAgent(Agent agent) {

    }

    @Override
    public Agent getAgent(Integer id) {
        return BaseMock.getAgent();
    }

    @Override
    public void deleteAgent(Agent agent) {

    }

    @Override
    public List<Agent> getAllAgents() {
        return null;
    }
}
