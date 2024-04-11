package co.com.barona.microservice.resolveEnigmaApi.api;

import co.com.barona.microservice.resolveEnigmaApi.model.ErrorDetail;
import co.com.barona.microservice.resolveEnigmaApi.model.GetEnigmaStepResponse;
import co.com.barona.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.barona.microservice.resolveEnigmaApi.model.JsonApiBodyResponseErrors;
import co.com.barona.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-28T01:53:31.617-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {
    @org.springframework.beans.factory.annotation.Autowired
    public GetStepApiController() {
    }

    public ResponseEntity<?> getStep(@ApiParam(value = "request body get enigma step", required = true) @Valid @RequestBody JsonApiBodyRequest body) {
        boolean isStepOne = (body.getData().get(0).getStep().equalsIgnoreCase("1"));
    	
    	if (!isStepOne) {        	
        	return new ResponseEntity<>(createResponseErrors(body), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(createResponseSuccess(body), HttpStatus.OK);
    }
    
    @GetMapping("/getStepOne")
    public ResponseEntity<String> getStepOne() {
    	return new ResponseEntity<>("Step 1: Open the refrigerator", HttpStatus.OK);
    }
    
    private List<JsonApiBodyResponseErrors> createResponseErrors(JsonApiBodyRequest body) {
    	ErrorDetail errorDetail = new ErrorDetail();
    	errorDetail.setCode("001");
    	errorDetail.setDetail("Step: ".concat(body.getData().get(0).getStep()).concat(" not supported - Expected: 1"));
    	errorDetail.setId(body.getData().get(0).getHeader().getId());
    	errorDetail.setSource("/getStep");
    	errorDetail.setStatus("400");
    	errorDetail.setTitle("Step not supported");
    	
    	JsonApiBodyResponseErrors responseError = new JsonApiBodyResponseErrors();
    	responseError.addErrorsItem(errorDetail);
    	
    	List<JsonApiBodyResponseErrors> responseErrorsList = new ArrayList<JsonApiBodyResponseErrors>(); 
    	responseErrorsList.add(responseError);
    	
    	return responseErrorsList;
    }
    
    private List<JsonApiBodyResponseSuccess> createResponseSuccess(JsonApiBodyRequest body) {
        GetEnigmaStepResponse responseEnigma = new GetEnigmaStepResponse();    
        responseEnigma.setHeader(body.getData().get(0).getHeader());
        responseEnigma.setStep(body.getData().get(0).getStep());
        responseEnigma.setStepDescription("Open the refrigerator");
        
        JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        responseSuccess.addDataItem(responseEnigma);
        
        List<JsonApiBodyResponseSuccess> responseSuccessList = new ArrayList<JsonApiBodyResponseSuccess>();  
        responseSuccessList.add(responseSuccess);
        
        return responseSuccessList;
    }
}