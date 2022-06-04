package pe.edu.upc.clientsboot.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.clientsboot.application.dtos.*;
import pe.edu.upc.clientsboot.application.services.PersonApplicationService;
import pe.edu.upc.clientsboot.application.notification.Notification;
import pe.edu.upc.clientsboot.application.notification.Result;

@RestController
@RequestMapping("/clients/person")
//@Api(tags = "Clients")
public class PersonController {
    private final PersonApplicationService personApplicationService;

    public PersonController(PersonApplicationService personApplicationService) {
        this.personApplicationService = personApplicationService;
    }

    @PostMapping(path= "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registerPerson(@RequestBody RegisterPersonRequest registerPersonRequest) {
        try {
            Result<RegisterPersonResponse, Notification> result = personApplicationService.registerPerson(registerPersonRequest);
            if (result.isSuccess()) {
                return ApiController.created(result.getSuccess());
            }
            return ApiController.error(result.getFailure().getErrors());
        } catch(Exception e) {
            return ApiController.serverError();
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@ApiOperation(value = "Get client person by id", response = PersonView.class)
    public ResponseEntity<Object> getById(@PathVariable("id") String id) {
        try {
            PersonView personView = personApplicationService.getById(id);
            return ApiController.ok(personView);
        } catch(Exception e) {
            e.printStackTrace();
            return ApiController.serverError();
        }
    }
}
