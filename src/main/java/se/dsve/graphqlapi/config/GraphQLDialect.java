package se.dsve.graphqlapi.config;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLDialect {

    @Bean
    public GraphQLScalarType dateScalar() {
        return GraphQLScalarType.newScalar()
                .name("Date")
                .description("Custom Date scalar type")
                .coercing(new Coercing<java.util.Date, String>() {
                    @Override
                    public String serialize(Object dataFetcherResult) {
                        return dataFetcherResult.toString();
                    }

                    @Override
                    public java.util.Date parseValue(Object input) {
                        return java.util.Date.from(java.time.Instant.parse(input.toString()));
                    }

                    @Override
                    public java.util.Date parseLiteral(Object input) {
                        if (input instanceof StringValue) {
                            return java.util.Date.from(java.time.Instant.parse(((StringValue) input).getValue()));
                        }
                        return null;
                    }
                })
                .build();
    }
}