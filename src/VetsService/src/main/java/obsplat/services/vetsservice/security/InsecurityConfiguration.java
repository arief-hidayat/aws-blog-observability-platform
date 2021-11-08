// Original Copyright 2002-2017 the original author or authors. Licensed under the Apache 2.0 License.
// Modifications Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 

package obsplat.services.vetsservice.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class InsecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final static Logger log = LoggerFactory.getLogger(InsecurityConfiguration.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.warn("configuring insecure HttpSecurity");
        http.
    	authorizeRequests().anyRequest().permitAll()
    	.and()
    	.httpBasic().disable()
    	.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        log.warn("configuring insecure WebSecurity");
        web.ignoring().antMatchers("/**");
    }

}
