package com.myproject.cloud.config;

import com.myproject.cloud.enums.LoadbalancerStrategyEnum;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@LoadBalancerClients(defaultConfiguration = LoadBalanceConfiguration.class)
public class LoadBalanceConfiguration {

    @Value("${spring.cloud.loadbalancer.strategy}")
    private LoadbalancerStrategyEnum strategy;

    @Bean
    public ReactorLoadBalancer<ServiceInstance> getLoadBalancer(Environment environment,
            LoadBalancerClientFactory factory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        ObjectProvider<ServiceInstanceListSupplier> provider = factory.getLazyProvider(name,
                ServiceInstanceListSupplier.class);
        if (LoadbalancerStrategyEnum.RANDOM.equals(strategy)) {
            return new RandomLoadBalancer(provider, name);
        } else {
            return new RoundRobinLoadBalancer(provider, name);
        }
    }

}
