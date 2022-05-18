package org.acme;

import javax.enterprise.context.ApplicationScoped;
import org.acme.utils.TrackingAgendaEventListener;
import org.drools.core.config.DefaultRuleEventListenerConfig;

@ApplicationScoped
public class RuleEventListenerConfig extends DefaultRuleEventListenerConfig {
    public RuleEventListenerConfig() {
        super(new TrackingAgendaEventListener());
    }
}
