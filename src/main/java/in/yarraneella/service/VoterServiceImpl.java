package in.yarraneella.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.yarraneella.entity.Voter;
import in.yarraneella.model.VoterRequest;
import in.yarraneella.model.VoterResponse;
import in.yarraneella.repository.VoterRepository;

@Service
public class VoterServiceImpl implements VoterService {
	@Autowired
	private VoterRepository voterRepository;

	@Override
	public VoterResponse createVoter(VoterRequest voterRequest) {
		Voter vote = new Voter();
		vote.setAge(voterRequest.getAge());
		vote.setEmail(voterRequest.getEmail());
		vote.setName(voterRequest.getName());
		vote = voterRepository.save(vote);
		VoterResponse vResponse = new VoterResponse();
		vResponse.setAge(vote.getAge());
		vResponse.setEmail(vote.getEmail());
		vResponse.setName(vote.getName());
		vResponse.setVoterID(vote.getVoterID());
		return vResponse;
	}

}
