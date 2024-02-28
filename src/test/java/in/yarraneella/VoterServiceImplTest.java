package in.yarraneella;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import in.yarraneella.entity.Voter;
import in.yarraneella.model.VoterRequest;
import in.yarraneella.model.VoterResponse;
import in.yarraneella.repository.VoterRepository;
import in.yarraneella.service.VoterServiceImpl;

@ExtendWith(MockitoExtension.class)
public class VoterServiceImplTest {

    @Mock
    private VoterRepository voterRepository;

    @InjectMocks
    private VoterServiceImpl voterService;

    @Test
    public void testCreateVoter() {
        // Given
        VoterRequest voterRequest = new VoterRequest();
        voterRequest.setAge(30);
        voterRequest.setEmail("example@example.com");
        voterRequest.setName("John Doe");

        Voter voter = new Voter();
        voter.setVoterID(1);
        voter.setAge(voterRequest.getAge());
        voter.setEmail(voterRequest.getEmail());
        voter.setName(voterRequest.getName());

        when(voterRepository.save(any(Voter.class))).thenReturn(voter);

        // When
        VoterResponse voterResponse = voterService.createVoter(voterRequest);

        // Then
        assertEquals(voterRequest.getAge(), voterResponse.getAge());
        assertEquals(voterRequest.getEmail(), voterResponse.getEmail());
        assertEquals(voterRequest.getName(), voterResponse.getName());
        assertEquals(voter.getVoterID(), voterResponse.getVoterID());
        
        // Verify
        verify(voterRepository).save(any(Voter.class));
    }
}
