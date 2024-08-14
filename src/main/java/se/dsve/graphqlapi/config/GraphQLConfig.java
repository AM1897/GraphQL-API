package se.dsve.graphqlapi.config;


import graphql.kickstart.spring.web.boot.GraphQLWebAutoConfiguration;
import graphql.kickstart.tools.boot.GraphQLJavaToolsAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({GraphQLWebAutoConfiguration.class, GraphQLJavaToolsAutoConfiguration.class})
public class GraphQLConfig {
}