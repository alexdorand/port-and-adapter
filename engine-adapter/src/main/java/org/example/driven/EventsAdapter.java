package org.example.driven;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.example.common.Adaptor;
import org.example.common.model.Event;
import org.example.driven.service.EventbridgeService;
import org.example.driven.service.SnsService;
import org.example.port.driven.EventPort;

@Log
@AllArgsConstructor
@Adaptor
public class EventsAdapter implements EventPort {


    private EventbridgeService eventbridgeService;
    private SnsService snsService;

    @Override
    public void trigger(Event event) {

        eventbridgeService.publish(event);
        log.info("Published event to AWS Eventbridge: "+event);

    }
}
