package api_configuration;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import java.util.Optional;

public class CustomLoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(CustomLoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext context) {

        logger.info("Method {}",requestSpec.getMethod());
        logger.info("URI {}",requestSpec.getURI());
        logger.info("Body {}", Optional.ofNullable(requestSpec.getBody()));

        Response response = context.next(requestSpec, responseSpec);
        logger.info("Status {}", response.getStatusCode());

        logger.info("Response {}", response.getBody().asString());

        return response;
    }
}