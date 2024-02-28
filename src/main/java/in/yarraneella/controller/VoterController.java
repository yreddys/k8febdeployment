package in.yarraneella.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.yarraneella.model.VoterRequest;
import in.yarraneella.model.VoterResponse;
import in.yarraneella.service.VoterService;

@RestController
//@RequestMapping("/voter")
public class VoterController {
	@Autowired
	private VoterService voterService;

	@PostMapping("/save")
	ResponseEntity<VoterResponse> createVoter(@RequestBody VoterRequest voterRequest) {
		VoterResponse Response = voterService.createVoter(voterRequest);
		return new ResponseEntity<>(Response, HttpStatus.CREATED);

	}
}
