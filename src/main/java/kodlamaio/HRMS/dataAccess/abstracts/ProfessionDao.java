package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Profession;

public interface ProfessionDao extends JpaRepository<Profession,Integer> {
 Profession findByName(String name);
}
