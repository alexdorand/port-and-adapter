package org.example.port.driven;

import org.example.common.model.Event;

public interface EventPort {
    void trigger(Event build);
}
