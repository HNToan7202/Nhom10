package vn.iotstar.Reponsitories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Lecture;

@Repository
@EnableScan
public interface ILectureRepository extends CrudRepository<Lecture, String> {
	Iterable<Lecture> findByNameContaining(String name);
	Iterable<Lecture> findByUsername(String username);
}
