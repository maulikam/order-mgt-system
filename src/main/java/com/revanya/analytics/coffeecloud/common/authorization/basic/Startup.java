package com.revanya.analytics.coffeecloud.common.authorization.basic;

import com.revanya.analytics.coffeecloud.common.authorization.entity.User;
import io.micrometer.observation.annotation.Observed;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Arrays;

@Singleton
public class Startup {
    @Transactional
    public void loadUsers(@Observes StartupEvent event) {
        User.deleteAll();
        User.add("admin", "admin", "admin");
        User.add("user", "user", "user");
    }
}
