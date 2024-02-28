package in.yarraneella.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.yarraneella.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter,Integer>{

}
