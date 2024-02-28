package in.yarraneella.service;

import in.yarraneella.model.VoterRequest;
import in.yarraneella.model.VoterResponse;

public interface VoterService {

	VoterResponse createVoter(VoterRequest voterRequest);

}
