package co.com.barona.microservice.resolveEnigmaApi.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.barona.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;

import javax.validation.Valid;

public interface GetStepApi {

    @PostMapping("/getSteps")
    ResponseEntity<?> getStepsPost(@Valid @RequestBody JsonApiBodyRequest body);
}