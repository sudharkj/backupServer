package com.jsrk.backup.server.globals;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.springframework.stereotype.Component;

/**
 * A singleton bean configured at server startup to contain user configured
 * messages
 */
@Startup
@Singleton
@Component
public class MessageConfig {

}
