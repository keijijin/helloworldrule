package org.acme.utils;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.MatchEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrackingAgendaEventListener extends DefaultAgendaEventListener {
  public void afterMatchFired(AfterMatchFiredEvent event) {
        super.afterMatchFired(event);
        log.debug("ルール発火 : " + createMsg(event));
    }
  public void matchCreated(MatchCreatedEvent event) {
        super.matchCreated(event);
        log.debug("ルール適合 : " + createMsg(event));
    }
  public void matchCancelled(MatchCancelledEvent event) {
        super.matchCancelled(event);
        log.debug("キャンセル : " + createMsg(event));
    }
  private String createMsg(MatchEvent event) {
        return event.getMatch().getRule().getName() + " : " + event.getMatch().getObjects();
    }
}

